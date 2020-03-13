import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Triangle implements Shapes {

	@Override
	public void drawShape(Graphics graphic, double x, double y) {
		Path2D path = new Path2D.Double();
		path.moveTo(x, y);
		path.lineTo(x + 100, y - 150);
		path.lineTo(x + 200, y);
		path.closePath();
	
		Graphics2D g2 = (Graphics2D) graphic;
		g2.draw(path);
		Frame.addShape(path, ShapesEnum.TRIANGLE);
	}

	@Override
	public boolean contains(int xpressed, int ypressed, int xshape, int yshape) {
		// TODO Auto-generated method stub
		return false;
	}

}
