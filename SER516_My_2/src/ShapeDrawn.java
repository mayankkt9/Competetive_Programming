
public class ShapeDrawn {
	Shapes shapeType;
	int xLoc;
	int yLoc;

	public ShapeDrawn(Shapes shapeType, int xLoc, int yLoc) {
		super();
		this.shapeType = shapeType;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public Shapes getShapeType() {
		return shapeType;
	}

	public void setShapeType(Shapes shapeType) {
		this.shapeType = shapeType;
	}

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + shapeType + " " + xLoc + " " + yLoc + ")";
	}

}
