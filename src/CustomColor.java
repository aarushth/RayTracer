
public class CustomColor {
	private float red;
	private float green;
	private float blue;

	public CustomColor(float r, float g, float b) {
		red = r;
		green = g;
		blue = b;
	}
	public float getRed() {
		return red;
	}
	public float getGreen() {
		return green;
	}
	public float getBlue() {
		return blue;
	}
	public String printPixel() {
		return " " + (int) (red*65535f) + " " + (int) (green*65535f) + " " + (int)(blue*65535f) + " ";
	}

	public CustomColor multiply(CustomColor c) {
		return new CustomColor(red*c.red, green*c.green, blue*c.blue);
	}
	public CustomColor multiply(Float f) {
		return new CustomColor(red*f, green*f, blue*f);
	}
	
	public CustomColor add(CustomColor c) {
		return new CustomColor (red + c.red, green + c.green, blue + c.blue);
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
