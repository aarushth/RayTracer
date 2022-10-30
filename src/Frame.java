import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame extends JFrame implements Panel.EventListener{
	public interface EventListener{
		public void onPaintEvent(Graphics g);
		public void onKeyEvent(KeyEvent k);
	}
	
	private Panel p;
	public EventListener listener;
	
	
	public Frame(EventListener e) {
		setBounds(1, 1, 989, 750);
		listener = e;
		setTitle("Ray Tracer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
		setFocusable(true);
		p = new Panel(this);
		add(p);
		
		addKeyListener(new KeyListener());
	}

	private class KeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent event) {
			listener.onKeyEvent(event);
		}
		
	}
	public void updateFrame() {
		p.repaint();
	}
	@Override
	public void onPaintEvent(Graphics g) {
		listener.onPaintEvent(g);
		
	}

}