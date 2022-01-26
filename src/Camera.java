public class Camera {
	private Point position;
	private Vector view;
	private Vector up;
	
	public Camera(Point p, Vector v, Vector u) {
		position = p;
		view = v;
		up = u;
	}
	
	public Vector getViewVector() {
		return Vector.getUnitVector(view);
	}
	
	public Vector getUpVector() {
		return Vector.getUnitVector(up);
	}
	
	public Point getOrigin() {
		return position;
	}
}
