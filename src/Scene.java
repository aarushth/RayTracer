import java.util.ArrayList;

public class Scene {
	private Camera camera;
	private Screen screen;
	private Buffer buffer;
	private float shadowDeviance;
	private ArrayList <Light> lightSources = new ArrayList<Light>();
	private ArrayList <Shape> objects = new ArrayList<Shape>();
	
	public Scene(Camera c, Screen s, Buffer b, ArrayList<Shape> sp, ArrayList<Light> l, float sd) {
		camera = c;
		screen = s;
		buffer = b;
		lightSources = l;
		objects = sp;
		shadowDeviance = sd;
	}
	
	public void RayTrace() {
		
		float multiplierHeight = screen.getHeight()/buffer.getHeight();
		float multiplierWidth = screen.getWidth()/buffer.getWidth();
		Vector colDir = camera.getViewVector().crossProduct(camera.getUpVector());
		Vector rowDir = camera.getUpVector().multiply((float) -1);
		for(float i = 0; i < buffer.getWidth(); i++) {
			for(float j = 0; j < buffer.getHeight(); j++) {
				Vector colIncr = colDir.multiply(i*multiplierWidth);
				Vector rowIncr = rowDir.multiply(j*multiplierHeight);
				Point p = screen.getUpperleftPosition().add(colIncr).add(rowIncr);
				Vector ray = Vector.getUnitVector(new Vector(p, camera.getOrigin()));
				
				buffer.putPixel(new Point(i,j, 0), traceRay(ray, camera.getOrigin(), 0));
			}
		}
		//buffer.dumpBuffer();
	}
	
	public CustomColor traceRay(Vector ray, Point origin, int recursionDepth){
		if (recursionDepth > 1) {
			return new CustomColor (0,0,0);
		}
		
		IntersectionDetails min = null;
		for(int k = 0; k < objects.size(); k++) {
			IntersectionDetails intersection =  objects.get(k).intersection(ray, camera.getOrigin());
			if(min == null || (intersection != null && intersection.getDistance() < min.getDistance())) {
				min = intersection;
			}
			
		}
		CustomColor finalCol = new CustomColor(0, 0, 0);
		if(min != null) {
			for(int k = 0; k < lightSources.size(); k ++){
				Vector shadowCheck = Vector.getUnitVector(new Vector(lightSources.get(k).getLightSourceJittered(shadowDeviance), min.getPoint()));
				boolean inShadow = false;
				for(int l = 0; l < objects.size() || inShadow; l ++) {
					if (objects.get(l).getID() != min.getShape().getID()) {
						IntersectionDetails temp = objects.get(l).intersection(shadowCheck, min.getPoint());
						inShadow = temp != null;
					}
				}
				finalCol = finalCol.add(min.getShape().colorCalc(min, ray, lightSources.get(k).getLightSourceJittered(shadowDeviance), lightSources.get(k).getLightColor(), !inShadow, this, recursionDepth+1));
			}
			finalCol.clamp();
		}
		return finalCol;
	}
	

	public String printPosition() {
		return screen.getCenterPosition();
	}
	public String printPositionTwo(){
		return screen.getHeightPosition();
	}
}