import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Square implements Shapes {

	@Override
	public void drawShape(Graphics graphic, double x, double y) {
		Shape square = new Rectangle2D.Double(x, y, 200, 200);
		Graphics2D graphics2 = (Graphics2D) graphic;
		graphics2.draw(square);

		Frame.addShape(square, ShapesEnum.SQUARE);
	}

	public boolean contains(int xpressed, int ypressed, int xsquare, int ysquare) {

		if (xpressed > xsquare && xpressed < xsquare + 200 && ypressed > ysquare && ypressed < ysquare + 200)
			return true;

		return false;
	}

}
