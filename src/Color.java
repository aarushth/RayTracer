
public class Color {
	private float red;
	private float green;
	private float blue;

	public Color(float red, float green,float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public String printPixel() {
		return " " + (int) (red*65535f) + " " + (int) (green*65535f) + " " + (int)(blue*65535f) + " ";
	}

	public Color multiply(Color c) {
		return new Color(red*c.red, green*c.green, blue*c.blue);
	}
	public Color multiply(Float f) {
		return new Color(red*f, green*f, blue*f);
	}
	
	public Color add(Color c) {
		return new Color (red + c.red, green + c.green, blue + c.blue);
	}
	
	public void clamp() {
		if (red > 1) {
			red = 1;
		}
		if(green > 1) {
			green = 1;
		}
		if (blue > 1) {
			blue = 1;
		}
	}
}
