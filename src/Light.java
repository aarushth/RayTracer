public class Light {
	private Point lightSource;
	private Color lightColor;
	
	public Light(Point s, Color c) {
		lightSource = s;
		lightColor = c;
	}
	
	public Point getLightSource() {
		return lightSource;
	}
	
	public Point getLightSourceJittered(float deviance) {
		return this.lightSource.jitter(deviance);
	}
	
	public Color getLightColor() {
		return lightColor;
	}
}
