package gloo.project.renderer;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import gloo.project.controller.Controller;

public class Screen extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private int width;
	private int height;
	private int rowHt;
	private int rowWid;
	
	public Screen(Controller controller) {
		this.controller = controller;
	}
	
	 

    @Override
    public void paint( Graphics graphics ) {
    	super.paint(graphics); // to enable Selector displacement 
        width = getSize().width;
        height = getSize().height;
        
        rowHt = height/this.controller.getNbLines();
        rowWid = width/this.controller.getNbColumns();
        
        for (int i = 0; i < this.controller.getNbLines(); i++) {
        	graphics.drawLine(0, i * rowHt, width, i * rowHt);
        }
        for (int i = 0; i < this.controller.getNbColumns();i++) {
        	graphics.drawLine(i * rowWid, 0, i * rowWid, height);
        }
        
        // Drawing of paths
        for (int j = 0; j < this.controller.getNbLines(); j++) {
        	for (int i = 0; i < this.controller.getNbColumns(); i++) {
        			graphics.setColor(Controller.screenColor(this.controller.getColor(i, j)));
        			graphics.fillRect(1+i*rowWid, 1+j*rowHt, rowWid-1, rowHt-1);
            }
        }
        
        graphics.setColor(new Color(152, 152, 152, 100));
        graphics.fillRect(this.controller.getX()*rowWid, 
        		this.controller.getY()*rowHt,
        		rowWid, rowHt);
    }
}
