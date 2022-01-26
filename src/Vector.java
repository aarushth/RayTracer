public class Vector {
	private float X;
	private float Y;
	private float Z;
	
	public Vector(Point head, Point tail) {
		X = head.getX()-tail.getX();
		Y = head.getY()-tail.getY();
		Z = head.getZ()-tail.getZ();
	}
	public Vector(Point point) {
		X = point.getX();
		Y = point.getY();
		Z = point.getZ();
	}
	public Vector(float x, float y, float z) {
		X = x;
		Y = y;
		Z = z;
	}
	
	public static Vector getUnitVector(Point point){
		float divisor =  (float) Math.sqrt(Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) + Math.pow(point.getZ(), 2));
		return new Vector(point.getX()/divisor, point.getY()/divisor, point.getZ()/divisor);
	}
	public static Vector getUnitVector(Vector vector){
		float divisor =  (float) Math.sqrt(Math.pow(vector.X, 2) + Math.pow(vector.Y, 2) + Math.pow(vector.Z, 2));
		return new Vector(vector.X/divisor, vector.Y/divisor, vector.Z/divisor);
	}
	
	public Vector multiply(Float f) {
		return new Vector(X*f, Y*f, Z*f);
	}
	public Vector crossProduct(Vector tempVect) {
		return new Vector((Y*tempVect.Z - Z*tempVect.Y), (Z*tempVect.X - X*tempVect.Z), (X*tempVect.Y - Y*tempVect.X));
	}
	public Vector subtract(Vector tempVect) {
		return new Vector(X-tempVect.X, Y-tempVect.Y, Z-tempVect.Z);
	}
	public float dotProduct(Vector tempVect) {
		return ((tempVect.X*X)+(tempVect.Y*Y)+(tempVect.Z*Z));
	}
	public Point getPoint() {
		return new Point(X, Y, Z);
	}
	public boolean equals(Vector tempVect) {
		if(tempVect.X == X && tempVect.Y == Y && tempVect.Z == Z) {
			return true;
		}else {
			return false;
		}
	}
	public float getX() {
		return X;
	}
	public float getY() {
		return Y;
	}
	public float getZ() {
		return Z;
	}
}
