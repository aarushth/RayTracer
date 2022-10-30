public class Screen {
	private float distance;
	private float width;
	private float height;
	private Point heightPosition;
	private Point centerPosition;
	private Point upperLeftPosition;
	private Camera cam;
	public Screen(float d, float w, float h, Camera c) {
		distance = d;
		width = w;
		height = h;
		cam = c;
		updateScreen();
		}
	
	public void updateScreen() {
		Vector temp = cam.getViewVector().multiply(distance);
		centerPosition = cam.getOrigin().add(temp);
		temp = cam.getUpVector().multiply(height/2);
		heightPosition = centerPosition.add(temp);
		temp = cam.getUpVector().crossProduct(cam.getViewVector());
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