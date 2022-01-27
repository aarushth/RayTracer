public class IntersectionDetails {
	private float distance;
	private Point point;
	private Shape shape;
	public IntersectionDetails(float d, Point p, Shape s) {
		distance = d;
		point = p;
		shape = s;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public Color getColor() {
		return shape.color;
	}
	
	public void setColor(Color c) {
		shape.color = c;
	}
	
	public Shape getShape() {
		return shape;
	}
}
