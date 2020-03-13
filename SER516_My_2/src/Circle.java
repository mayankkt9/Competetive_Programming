import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Circle implements Shapes {

	@Override
	public void drawShape(Graphics graphic, double x, double y) {
		Shape circle = new Ellipse2D.Double(x, y, 200, 200);
		Graphics2D graphics2 = (Graphics2D) graphic;
		graphics2.draw(circle);
		
		Frame.addShape(circle, ShapesEnum.CIRCLE);
	}

	@Override
	public boolean contains(int xpressed, int ypressed, int xshape, int yshape) {
		// TODO Auto-generated method stub
		return false;
	}

}
