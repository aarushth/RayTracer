public class Plane extends Shape{

	private Vector normal;
	private float distance;
	private Point center;
	public Plane(Vector n, float d, Color col, float kd, float ka, float ref) {
		distance = d;
		normal = Vector.getUnitVector(n);
		color = col;
		kD = kd;
		kA = ka;
		reflectivity = ref;
		id = ID_COUNT++;
		center = normal.multiply(distance).getPoint();
	}
	
	@Override
	public IntersectionDetails intersection(Vector vector, Point origin){
		vector = Vector.getUnitVector(vector);
		IntersectionDetails intersection = null;
		if(vector.dotProduct(normal) != 0) {
		float intersectionDistance = (normal.dotProduct(new Vector(center.subtract(origin))))/(vector.dotProduct(normal));
		Point intersectionPoint = new Point(vector.multiply(intersectionDistance));
		intersection = new IntersectionDetails(intersectionDistance, intersectionPoint, color, this);
		}
		return intersection;
	}
	
}
