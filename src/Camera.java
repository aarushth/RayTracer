public class Camera {
	private Point position;
	private Vector view;
	private Vector up;
	private Vector right;
	
	public Camera(Point p, Vector v) {
		position = p;
		view = Vector.getUnitVector(v);
		right = view.crossProduct(new Vector(0, 0, 1));
		up = Vector.getUnitVector(right.crossProduct(view));
	}
	
	public Vector getViewVector() {
		return Vector.getUnitVector(view);
	}
	public void setViewVector(Vector v) {
		view = Vector.getUnitVector(v);
		right = view.crossProduct(new Vector(0, 0, 1));
		up = Vector.getUnitVector(right.crossProduct(view));
	}
	public Vector getUpVector() {
		return Vector.getUnitVector(up);
	}
	public Vector getRightVector() {
		return Vector.getUnitVector(right);
	}
	
	public Point getOrigin() {
		return position;
	}
	public void move(Point p) {
		position = p;
	}
}