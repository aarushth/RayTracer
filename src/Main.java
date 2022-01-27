import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		
		//define the file path where you want the image to be saved
		//        Recommendation: change this  |  to your user name on the system. 
		//                                   \ /
		String filePath = "C:\\Users\\" + "aarus" + "\\AppData\\RayTracerImage.ppm";
		//define the viewing position, viewing direction vector, 
		//and the up vector(perpendicular to the direction vector) to determine the rotation of the image
		Camera camera = new Camera(new Point(0, 0, 0), new Vector(0, 1, 0), new Vector(0,  0, 1));
		//determine the the distance of the image from the camera and the width and height of the screen in space
		Screen screen = new Screen(5, 20, 10, camera);
		//determine the resolution of the final image
		Buffer buffer = new Buffer(2000, 1000, filePath);
		//this is the array of all spheres
		ArrayList <Shape> shapes = new ArrayList<Shape>();
	
		shapes.add(new Sphere(new Point(5, 5, 0), 0.5f, new Color(0, 1, 0), 0.5f, 0.2f, 0f));
		shapes.add(new Sphere(new Point(-5, 10, 0), 5f, new Color(0.3f, 0.3f, 0.3f), 0.5f, 0.2f, 1f));
		shapes.add(new Sphere(new Point(0, 6, 6), 2f, new Color(0.3f, 0.3f, 0.3f), 0.5f, 0.2f, 1f));
		shapes.add(new Triangle(new Point(0, 10, 4), new Point(5, 11, 4), new Point(0, 10, 0), new Color(0f, 0f, 1f), 0.5f, 0.2f, 0f));
		//this is the array of all light sources
		ArrayList <Light> lights = new ArrayList<Light>();
		
		lights.add(new Light(new Point(10, 0, 0), new Color(1, 1, 1)));
		//lights.add(new Light(new Point(0, 0, 0), new Color(1, 1, 1)));
		
		float shadowDeviance = 0.5f;
		
		Scene scene = new Scene(camera, screen, buffer, shapes, lights, shadowDeviance);
		scene.RayTrace();
	}
}
