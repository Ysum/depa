package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class Line extends AbstractFigure {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5799191343905732421L;

	Line2D line;
	
	public Line(int x1, int y1, int x2, int y2) {
		line = new Line2D.Double(x1, y1, x2, y2);
	}

	@Override
	public void draw(Graphics g) {
		int x1 = (int) line.getX1();
		int y1 = (int) line.getY1();
		int x2 = (int) line.getX2();
		int y2 = (int) line.getY2();

		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);
		
	}

	@Override
	public void move(int dx, int dy) {
		if (dx != 0 || dy != 0) {
			double x1 = line.getX1()+dx;
			double y1 = line.getY1()+dy;
			double x2 = line.getX2()+dx;
			double y2 = line.getY2()+dy;
			line.setLine(x1, y1, x2, y2);
			notifyListener();
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		return line.contains(x, y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		double x1 = origin.getX();
		double y1 = origin.getY();
		double x2 = corner.getX();
		double y2 = corner.getX();
		line.setLine(x1, y1, x2, y2);
		notifyListener();
		
	}

	@Override
	public Rectangle getBounds() {
		return line.getBounds();
	}

}
