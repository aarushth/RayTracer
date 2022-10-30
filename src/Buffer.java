import java.io.FileWriter;
import java.io.IOException;

public class Buffer {
	
	private int width;
	private int height;
	private String filePath;
	private CustomColor[][] screen;
	
	public Buffer(int w, int h, String fp) {
		filePath = fp;
		width = w;
		height = h;
		screen = new CustomColor[height][width];
	}
	
	public void dumpBuffer() {
		try {
		      FileWriter file = new FileWriter(filePath);
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
	
	public void putPixel(Point point, CustomColor p) {
		if(p != null) {
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
	public CustomColor[][] getScreen(){
		return screen;
	}
}