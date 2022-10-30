import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Control implements Frame.EventListener{
	
	Frame frame;
	Scene scene;
	Camera camera;
	Screen screen;
	Buffer buffer;
	
	ScreenDump screenDumper = new ScreenDump();
	public Control() {
		
		//define the viewing position, viewing direction vector, 
		//and the up vector(perpendicular to the direction vector) to determine the rotation of the image
		camera = new Camera(new Point(0, 0, 0), new Vector(0, 1, 0));
		//determine the the distance of the image from the camera and the width and height of the screen in space
		
		//this is the array of all shapes
		ArrayList <Shape> shapes = new ArrayList<Shape>();
		
		
		shapes.add(new Sphere(new Point(5, 5, 0), 0.5f, new CustomColor(0, 1, 0), 0.5f, 0.2f, 0f));
		shapes.add(new Sphere(new Point(-5, 10, 0), 5f, new CustomColor(0.3f, 0.3f, 0.3f), 0.5f, 0.2f, 1f));
		shapes.add(new Sphere(new Point(0, 6, 6), 2f, new CustomColor(0.3f, 0.3f, 0.3f), 0.5f, 0.2f, 1f));
		shapes.add(new Triangle(new Point(0, 10, 4), new Point(5, 11, 4), new Point(0, 10, 0), new CustomColor(0f, 0f, 1f), 0.5f, 0.2f, 0f));
		//this is the array of all light sources
		ArrayList <Light> lights = new ArrayList<Light>();
		
		lights.add(new Light(new Point(10, 0, 0), new CustomColor(1, 1, 1)));
		//lights.add(new Light(new Point(0, 0, 0), new Color(1, 1, 1)));
		
		float shadowDeviance = 0.5f;
		String filePath = "C:\\Users\\" + "s-athadani" + "\\AppData\\RayTracerImage.ppm";
		frame = new Frame(this);
		buffer = new Buffer(frame.getWidth(), frame.getHeight(), filePath);
		screen = new Screen(5, frame.getWidth()/100, frame.getHeight()/100, camera);
		scene = new Scene(camera, screen, buffer, shapes, lights, shadowDeviance);
		
		frame.updateFrame();
	}

	@Override
	public void onPaintEvent(Graphics g) {
		scene.RayTrace();
		screenDumper.dump(buffer, g);
	}

	@Override
	public void onKeyEvent(KeyEvent k) {
		int key = k.getKeyCode();
		boolean shouldRepaint = false;
		if(key == KeyEvent.VK_LEFT) {
			shouldRepaint = leftRight(-10);
		}else if(key == KeyEvent.VK_RIGHT) {
			shouldRepaint = leftRight(10);
		}else if(key == KeyEvent.VK_UP){
			
		}else if(key == KeyEvent.VK_W) {
			camera.move(new Point(camera.getViewVector().getX()+camera.getOrigin().getX(), 
					camera.getViewVector().getY()+camera.getOrigin().getY(), 
					camera.getOrigin().getZ()+camera.getViewVector().getZ()));
			shouldRepaint = true;
		}else if(key == KeyEvent.VK_S) {
			camera.move(new Point(camera.getOrigin().getX()-camera.getViewVector().getX(), 
					camera.getOrigin().getY()-camera.getViewVector().getY(), 
					camera.getOrigin().getZ()-camera.getViewVector().getZ()));
			shouldRepaint = true;
		}else if(key == KeyEvent.VK_D) {
			camera.move(new Point(camera.getOrigin().getX()+camera.getRightVector().getX(), 
					camera.getOrigin().getY()+camera.getRightVector().getY(), 
					camera.getOrigin().getZ()+camera.getRightVector().getZ()));
			shouldRepaint = true;
		}else if(key == KeyEvent.VK_A) {
			camera.move(new Point(camera.getOrigin().getX()-camera.getRightVector().getX(), 
					camera.getOrigin().getY()-camera.getRightVector().getY(), 
					camera.getOrigin().getZ()-camera.getRightVector().getZ()));
			shouldRepaint = true;
		}else if(key == KeyEvent.VK_SPACE) {
			camera.move(new Point(camera.getOrigin().getX()+camera.getUpVector().getX(), 
					camera.getOrigin().getY()+camera.getUpVector().getY(), 
					camera.getOrigin().getZ()+camera.getUpVector().getZ()));
			shouldRepaint = true;
		}else if(key == KeyEvent.VK_SHIFT) {
			camera.move(new Point(camera.getOrigin().getX()-camera.getUpVector().getX(), 
					camera.getOrigin().getY()-camera.getUpVector().getY(), 
					camera.getOrigin().getZ()-camera.getUpVector().getZ()));
			shouldRepaint = true;
		}
		if(shouldRepaint) {
			screen.updateScreen();
			frame.updateFrame();
		}
		
	}
	
	private boolean leftRight(float f) {
		float v =  (float) Math.sqrt((camera.getViewVector().getX()*camera.getViewVector().getX()) + (camera.getViewVector().getY()*camera.getViewVector().getY()));
		float theta = (float) (Math.atan(camera.getViewVector().getX()/camera.getViewVector().getY())*180/Math.PI);
		camera.setViewVector(new Vector((float) (v*Math.sin((theta + f)*Math.PI/180)), (float) (v*Math.cos((theta + f)*Math.PI/180)), camera.getViewVector().getZ()));
		return true;
	}
	private boolean upDown(float f) {
		float v =  (float) Math.sqrt((camera.getViewVector().getX()*camera.getViewVector().getX()) + (camera.getViewVector().getY()*camera.getViewVector().getY()));
		float theta = (float) (Math.atan(camera.getViewVector().getX()/camera.getViewVector().getY())*180/Math.PI);
		camera.setViewVector(new Vector((float) (v*Math.sin((theta + f)*Math.PI/180)), (float) (v*Math.cos((theta + f)*Math.PI/180)), camera.getViewVector().getZ()));
		return true;
	}
	
}