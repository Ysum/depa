package jdraw.figures;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.*;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;


/**
 * Representations of circles in JDraw.
 * 
 * @author Lukas Musy
 *
 */
public class Ellipse extends AbstractFigure {
	
	private java.awt.geom.Ellipse2D ellipse;
	
	public Ellipse(int x, int y, int w, int h) {
		ellipse = new Ellipse2D.Float(x, y, w, h);
	}

	@Override
	public void draw(Graphics g) {
		int x = (int) ellipse.getX();
		int y = (int) ellipse.getY();
		int w = (int) ellipse.getWidth();
		int h = (int) ellipse.getHeight();
		
		g.setColor(Color.CYAN);
		g.fillRect(x, y, w, h);
		g.setColor(Color.ORANGE);
		g.drawOval(x, y, w, h);
	}

	@Override
	public void move(int dx, int dy) {
		if (dx != 0 || dy != 0) {
			double x = ellipse.getX();
			double y = ellipse.getY();
			double w = ellipse.getWidth();
			double h = ellipse.getHeight();
			ellipse.setFrame(x + dx, y + dy, w, h);;
			notifyListener();
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		return ellipse.contains(x, y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		ellipse.setFrameFromDiagonal(origin, corner);
		notifyListener();
	}

	@Override
	public Rectangle getBounds() {
		return ellipse.getBounds();
	}


}
