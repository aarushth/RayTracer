public class Light {
	private Point lightSource;
	private CustomColor lightColor;
	
	public Light(Point s, CustomColor c) {
		lightSource = s;
		lightColor = c;
	}
	
	public Point getLightSource() {
		return lightSource;
	}
	
	public Point getLightSourceJittered(float deviance) {
		return this.lightSource.jitter(deviance);
	}
	
	public CustomColor getLightColor() {
		return lightColor;
	}
}
