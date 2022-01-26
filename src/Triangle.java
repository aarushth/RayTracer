
public class Triangle extends Shape{
	private Point A;
	private Point B;
	private Point C;
	private Vector normal;
	private Vector BA;
	private Vector AC;
	private Vector CB;
	public Triangle(Point p1, Point p2, Point p3, Color col, float kd, float ka, float ref) {
		A = p1;
		B = p2;
		C = p3;
		color = col;
		kD = kd;
		kA = ka;
		reflectivity = ref;
		id = ID_COUNT++;
		BA = new Vector(B, A);
		AC = new Vector(A, C);
		CB = new Vector(C, B);
		normal = Vector.getUnitVector(BA.crossProduct(new Vector(C, A)));
	}
	
	@Override
	public Vector getNormal(IntersectionDetails intersection) {
		return normal;
	}
	
	@Override
	public IntersectionDetails intersection(Vector vector, Point origin){
		vector = Vector.getUnitVector(vector);
		IntersectionDetails intersection = null;
		if(vector.dotProduct(normal) != 0) {
			float intersectionDistance = (normal.dotProduct(new Vector(A)) - normal.dotProduct(new Vector(origin)))/(normal.dotProduct(vector));
			Point intersectionPoint = new Point(vector.multiply(intersectionDistance));

			Vector QA = new Vector(intersectionPoint, A);
			Vector QC = new Vector(intersectionPoint, C);
			Vector QB = new Vector(intersectionPoint, B);
			
			Vector checkA = Vector.getUnitVector(BA.crossProduct(QA));
			Vector checkB = Vector.getUnitVector(AC.crossProduct(QC));
			Vector checkC = Vector.getUnitVector(CB.crossProduct(QB));
			if(checkA.equals(normal) &&  checkB.equals(normal) &&  checkC.equals(normal)) {
				intersection = new IntersectionDetails(intersectionDistance, intersectionPoint, color, this);
			}
		}
		return intersection;
	}
}
