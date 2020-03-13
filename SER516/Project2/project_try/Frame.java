package project_try;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.glass.ui.Cursor;


public class DragNDrop extends JPanel implements MouseListener, MouseMotionListener{
	private int x1 = 100;
	private int y1 = 100;
	private int xm, ym;
	private int fl = 0;
	
	public void mouseDragged(MouseEvent e){
		
	}
	
	public void mouseMoved(MouseEvent e){
		xm = e.getX();
		ym = e.getY();
		if (fl == 1){
			x1 = xm - 50;
			y1 = ym - 70;
		}
	}
	
	public void mouseClicked(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	public void mousePressed(MouseEvent e){
		if (e.getButton() == MouseEvent.BUTTON1){
			xm = e.getX();
			ym = e.getY();
			System.out.println(ym + " " + xm);
			if (fl == 0){
				if (ym > y1 + 15 && ym < y1 + 130 && xm > x1 + 15 && xm < x1 + 130){
					fl = 1;
				}
			} else {
				fl = 0;
			}
		}
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.white);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillRect(x1, y1, 100, 100);
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Drag and Drop");
		DragNDrop g = new DragNDrop();
		frame.add(g);
		frame.addMouseListener(g);
		frame.addMouseMotionListener(g);
		frame.setSize(800, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){
			g.repaint();
		}
	}

}