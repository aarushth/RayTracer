import java.util.ArrayList;
import java.util.Random;

public class Point {
	private float x;
	private float y;
	private float z;
	
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point(Vector v) {
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}
	public Point add(Vector vect) {
		return new Point(vect.getX()+x, vect.getY()+y, vect.getZ()+z);
	}
	public Point add(float f) {
		return new Point(x+f, y+f, z+f);
	}
	public Point add(Point p) {
		return new Point(x+p.x, y+p.y, z+p.z);
	}
	public Point subtract(Point p) {
		return new Point(x-p.x, y-p.y, z-p.z);
	}
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	public float getZ() {
		return z;
	}
	public String toString()
	{
		return "X = " + x + " Y = " + y + " Z = " + z;
	}

	
	public Point jitter(float deviance) {
		Random r = new Random();
		ArrayList<Float> tempPoint = new ArrayList<Float>();
		tempPoint.add(x);
		tempPoint.add(y);
		tempPoint.add(z);
		for(int i = 0; i < tempPoint.size(); i++) {
			if(r.nextFloat() > 0.5) {
				tempPoint.set(i, tempPoint.get(i) + deviance*r.nextFloat());
			}else {
				tempPoint.set(i, tempPoint.get(i) - deviance*r.nextFloat());
			}
		}
		return new Point(tempPoint.get(0), tempPoint.get(1), tempPoint.get(2));
	}
}
