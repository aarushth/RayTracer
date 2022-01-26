import java.io.FileWriter;
import java.io.IOException;

public class Buffer {
	
	private int width;
	private int height;
	private Color[][] screen;
	
	public Buffer(int w, int h) {
		width = w;
		height = h;
		screen = new Color[width][height];
	}
	
	public void dumpBuffer() {
		try {
		      FileWriter file = new FileWriter("C:\\Users\\aarus\\AppData\\filename.ppm");
		      file.write("P3\r\n" + Integer.toString(width) + " " + Integer.toString(height) + "\r\n65535");
		      for(int i = 0; i < height; i++) {
		    	  for(int j = 0; j < width; j++) {
		    		  if(!(screen[i][j] == null)) {
		    			  file.write("\r\n" + screen[i][j].printPixel());
		    		  }else {
		    			  file.write("\r\n 0 0 0 ");
		    		  }
		    	  }
		      }
		      file.close();
		    }catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void putPixel(Point point, Color p) {
		if(!(p == null)) {
			if(point.getX() < width && point.getX() > -1 && point.getY() < height && point.getY() > -1) {
				screen[(int) point.getY()][(int) point.getX()] = p;
			}else {
				throw new IllegalArgumentException();
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
