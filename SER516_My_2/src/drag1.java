import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


public  class GUISwing extends JFrame implements MouseMotionListener
{
	
private Graphics g1;
private Graphics g2;
private Graphics g3;
private Image img;
public int x,y;


public GUISwing()
{
	
addMouseMotionListener(this);
setSize(600,600);
setResizable(false);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}
