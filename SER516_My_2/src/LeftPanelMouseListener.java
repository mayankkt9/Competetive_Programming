import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Parikshith Kedilaya Mallar
 *
 */
public class LeftPanelMouseListener extends MouseAdapter {
	
	private static boolean isTriangleClicked = false;
	private static boolean isSquareClicked = false;
	private static boolean isCircleClicked = false;
	Shapes obj[] = new Shapes[100];
	/**
     * Overridden method to add mouse click event handler.
	 * Used to track which shape has been clicked on the left panel,
	 * so that only that shape can be created on the right panel.
	 * 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
			for (int i = Frame.getShapes().size() - 1; i >= 0; i--) {
			    if (Frame.getShapes().get(i).contains(e.getPoint())) {
			        markIsClickedTrue(Frame.getShapesMap().get(Frame.getShapes().get(i)));
			        System.out.println(Frame.getShapesMap().get(Frame.getShapes().get(i)));
			    	return;
			    }
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    /**
	 * @param shape
	 * 
	 * Instantiates or uses the created instance of different shapes' class
	 * and sets isClicked value as true for the shape which was clicked.
	 */
	private void markIsClickedTrue(ShapesEnum shape) {
		try {
			if (ShapesEnum.SQUARE == shape) {
				setTriangleClicked(false);
				setSquareClicked(true);
				setCircleClicked(false);
			}
			if (ShapesEnum.TRIANGLE == shape) {
				setTriangleClicked(true);
				setSquareClicked(false);
				setCircleClicked(false);
			}
			if (ShapesEnum.CIRCLE == shape) {
				setTriangleClicked(false);
				setSquareClicked(false);
				setCircleClicked(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return
	 * returns which shape was clicked.
	 */
	public static ShapesEnum getSelectedShape() {
		if (isSquareClicked()) {
			return ShapesEnum.SQUARE;
		} else if (isTriangleClicked()) {
			return ShapesEnum.TRIANGLE;
		} else if (isCircleClicked()) {
			return ShapesEnum.CIRCLE;
		} else {
			return null;
		}
		
	}

	public static boolean isTriangleClicked() {
		return isTriangleClicked;
	}

	public static void setTriangleClicked(boolean isTriangleClicked) {
		LeftPanelMouseListener.isTriangleClicked = isTriangleClicked;
	}

	public static boolean isSquareClicked() {
		return isSquareClicked;
	}

	public static void setSquareClicked(boolean isSquareClicked) {
		LeftPanelMouseListener.isSquareClicked = isSquareClicked;
	}

	public static boolean isCircleClicked() {
		return isCircleClicked;
	}

	public static void setCircleClicked(boolean isCircleClicked) {
		LeftPanelMouseListener.isCircleClicked = isCircleClicked;
	}
}
