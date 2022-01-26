public class Screen {
	private float distance;
	private float width;
	private float height;
	private Point heightPosition;
	private Point centerPosition;
	private Point upperLeftPosition;

	public Screen(float d, float w, float h, Camera c) {
		distance = d;
		width = w;
		height = h;
		Vector temp = c.getViewVector().multiply(distance);
		centerPosition = c.getOrigin().add(temp);
		temp = c.getUpVector().multiply(height/2);
		heightPosition = centerPosition.add(temp);
		temp = c.getUpVector().crossProduct(c.getViewVector());
		temp = temp.multiply(width/2);
		upperLeftPosition = heightPosition.add(temp);
		}
	
	
	
	public String getCenterPosition() {
		return centerPosition.toString();
	}

	public String getHeightPosition() {
		return heightPosition.toString();
	}
	
	public Point getUpperleftPosition() {
		return upperLeftPosition;
	}
	
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
}