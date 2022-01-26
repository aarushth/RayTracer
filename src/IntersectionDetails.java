public class IntersectionDetails {
	private float distance;
	private Point point;
	private Color color;
	private Shape shape;
	public IntersectionDetails(float d, Point p, Color c, Shape s) {
		distance = d;
		point = p;
		color = c;
		shape = s;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Shape getShape() {
		return shape;
	}
}
