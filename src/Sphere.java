public class Sphere extends Shape{
	private Point center;
	private float radius;
	
	
	public Sphere(Point c, float r, Color col, float kd, float ka, float ref) {
		center = c;
		radius = r;
		color = col;
		kD = kd;
		kA = ka;
		reflectivity = ref;
		id = ID_COUNT++;
	}
	
	@Override
	public IntersectionDetails intersection(Vector vector, Point origin){
		Vector OMinusC = new Vector(origin, center);
		float discriminant = (float) (Math.pow(vector.dotProduct(OMinusC), 2)-OMinusC.dotProduct(OMinusC)+radius*radius);
		IntersectionDetails tempReturn = null;
		if(discriminant >= 0) {
			float dTemp = -(vector.dotProduct(OMinusC));
			if (discriminant == 0 && !(dTemp < 0)) {
				
				Point i = origin.add(vector.multiply(dTemp));
				tempReturn = new IntersectionDetails(dTemp, i, color, this);
			}else {
				float d1 = (float) (dTemp + Math.sqrt(discriminant));
				float d2 = (float) (dTemp - Math.sqrt(discriminant));
				Point i1 = origin.add(vector.multiply(d1));
				Point i2 = origin.add(vector.multiply(d2));
				
				if(!(d1<0)) {
					tempReturn = new IntersectionDetails(d1, i1, color, this);
				}
				if(!(d2<0)) {
					tempReturn = new IntersectionDetails(d2, i2, color, this);
				}
			}
		}
		return tempReturn;
	}
	
	@Override
	public Vector getNormal(IntersectionDetails intersection) {
		return Vector.getUnitVector(new Vector(intersection.getPoint(), center));
	}
}