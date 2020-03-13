import java.awt.Graphics;

/**
 * @author Raghavan
 */
public interface Shapes {
	public void drawShape(Graphics graphic, double x, double y);

	public boolean contains(int xpressed, int ypressed, int xshape, int yshape);
}
