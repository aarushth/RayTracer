import java.awt.Color;
import java.awt.Graphics;

public class ScreenDump {
	public void dump(Buffer b, Graphics g) {
		CustomColor[][] screen = b.getScreen();
		CustomColor c;
		for(int i = 0; i < screen.length; i++) {
			for(int j = 0; j < screen[0].length; j++) {
				c = screen[i][j];
				g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue()));
				g.fillRect((int) (j),(int) (i), 1, 1);
			}
		}
	}
}
