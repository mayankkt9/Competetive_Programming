import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Chandan Kiragadalu Javaregowda
 *
 */
public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final String title = "Team 1";
	private static List<Shape> shapes = new ArrayList<>();
	private static Map<Shape, ShapesEnum> shapesMap = new HashMap<>();
	private int x, y;
	ArrayList<ShapeDrawn> shapeDrawn = new ArrayList<ShapeDrawn>();
	private static int totalShape = 0;
	private ShapeDrawn currentShape = new ShapeDrawn(null, 0, 0);
	private Frame() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		setTitle(title);
		setVisible(true);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Create left panel to the frame
	 */
	private void createLeftPanel() {
		try {
			JPanel leftPanel = new JPanel() {
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					Shapes square = new Square();
					square.drawShape(g, 50, 50);
					Shapes circle = new Circle();
					circle.drawShape(g, 50, 300);
					Shapes triangle = new Triangle();
					triangle.drawShape(g, 50, 750);
				}
			};
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			leftPanel.setBounds(0, 0, screenSize.width / 4, screenSize.height);
			leftPanel.setVisible(true);
			this.add(leftPanel);

			leftPanel.addMouseListener(new LeftPanelMouseListener());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create right panel to the frame paintComponent creates new shapes upon click
	 */
	private void createRightpanel() {
		try {
			JPanel rightPanel = new JPanel() {
				private static final long serialVersionUID = 1L;

				/**
				 * Uses Graphics to create shapes Checks in shapes list for all the list and
				 * creates all the shapes in the right panel. This is required while repaint()
				 * is called as all the existing components on the right panel will be erased by
				 * default. We need to re-draw all the components each time repaint() is
				 * invoked.
				 */
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					for (Shape shape : getShapes()) {
						if (shape.getBounds().getX() != 50) {
							Graphics2D g2 = (Graphics2D) g;
							g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
							g2.draw(shape);
						}
					}
					ShapesEnum selectedShape = LeftPanelMouseListener.getSelectedShape();
					System.out.println("---"+shapeDrawn);
					for (ShapeDrawn sh : shapeDrawn) {
						sh.getShapeType().drawShape(g, sh.getxLoc(), sh.getyLoc());
						System.out.println("99");
					}
				}

			};
			rightPanel.setBackground(Color.WHITE);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			rightPanel.setBounds(screenSize.width / 4, 0, 3 * screenSize.width / 4, screenSize.height);
			rightPanel.setVisible(true);
			this.add(rightPanel);

			
			rightPanel.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					x = e.getX();
					y = e.getY();
					
//					for (ShapeDrawn s : shapeDrawn) {
//						if (s.getShapeType().contains(x, y, s.getxLoc(), s.getyLoc())) {
//							System.out.println("Yes");
//							currentShape = s;
//						}
//					}
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					x = e.getX();
					y = e.getY();
				
					if (currentShape.getShapeType()!=null) {
//						currentShape.setxLoc(x);
//						currentShape.setyLoc(y);
//						repaint();
						
//						Graphics graphics = getGraphics();
//
//						graphics.setXORMode(getBackground());
//
//						currentShape.getShapeType().drawShape(graphics, currentShape.getxLoc(), currentShape.getyLoc());
//
//						currentShape.setxLoc(x);
//
//						currentShape.setyLoc(y);
//
//						currentShape.getShapeType().drawShape(graphics, currentShape.getxLoc(), currentShape.getyLoc());
//
//
//						graphics.dispose();
						
						
					}
				}
			});
			
			rightPanel.addMouseListener(new MouseAdapter() {
				/**
				 * Overridden method to add mouse click event handler. Will call
				 * paintComponent(Graphics) method using repaint().
				 * 
				 */
				@Override
				public void mouseClicked(MouseEvent e) {
					x = e.getX();
					y = e.getY();

					System.out.println(shapeDrawn);
					for (ShapeDrawn s : shapeDrawn) {
						if (s.getShapeType().contains(x, y, s.getxLoc(), s.getyLoc())) {
							System.out.println("Already Present");
							currentShape = s;
							shapeDrawn.remove(s);
							repaint();
							return;
						}
					}
					
					ShapesEnum selectedShape = LeftPanelMouseListener.getSelectedShape();

					if (selectedShape == ShapesEnum.SQUARE) {
						shapeDrawn.add(new ShapeDrawn(new Square(), x, y));
					} else if (selectedShape == ShapesEnum.TRIANGLE) {
						shapeDrawn.add(new ShapeDrawn(new Triangle(), x, y));
					} else if (selectedShape == ShapesEnum.CIRCLE) {
						shapeDrawn.add(new ShapeDrawn(new Circle(), x, y));
					}
					repaint();
					System.out.println("90"+shapeDrawn);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to update shapes and shapesMap lists. Used to track the shapes created
	 * and kind of shape created.
	 * 
	 * @param shape
	 * @param shapesEnum
	 */
	public static void addShape(Shape shape, ShapesEnum shapesEnum) {
		if (!getShapes().contains(shape)) {
			getShapes().add(shape);
			getShapesMap().put(shape, shapesEnum);
		}
	}

	public static List<Shape> getShapes() {
		return shapes;
	}

	public static void setShapes(List<Shape> shapes) {
		Frame.shapes = shapes;
	}

	public static Map<Shape, ShapesEnum> getShapesMap() {
		return shapesMap;
	}

	public static void setShapesMap(Map<Shape, ShapesEnum> shapesMap) {
		Frame.shapesMap = shapesMap;
	}

	/**
	 * @param args This method schedules a job for the event-dispatching thread.
	 *             This method is responsible for creating and showing application's
	 *             GUI.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frame frame = new Frame();
				frame.createLeftPanel();
				frame.createRightpanel();
			}
		});
	}
}
