package jdraw.figures.handles;

import jdraw.figures.AbstractFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by lukasmusy
 */
public class AbstractFigureHandle implements FigureHandle {
    private HandleType type;
    private Figure owner;

    public int size = 6;

    public AbstractFigureHandle(Figure f, HandleType t) {
        this.owner = f;
        this.type = t;
    }

    @Override
    public Figure getOwner() {
        return owner;
    }

    @Override
    public Point getLocation() {
        Point location = null;

        Rectangle bounds = owner.getBounds();
        int rootX = bounds.x;
        int rootY = bounds.y;
        int width = bounds.width;
        int height = bounds.height;

        switch (type) {
            case TOP_LEFT: location = bounds.getLocation();
                break;
            case TOP_MID: location = new Point(rootX+width/2, rootY);
                break;
            case TOP_RIGHT: location = new Point(rootX+width, rootY);
                break;
            case RIGHT: location = new Point(rootX+width, rootY+height/2);
                break;
            case BOTTOM_RIGHT: location = new Point(rootX+width, rootY+height);
                break;
            case BOTTOM_MIDDLE: location = new Point(rootX+width/2, rootY+height);
                break;
            case BOTTOM_LEFT: location = new Point(rootX, rootY+height);
                break;
            case LEFT: location = new Point(rootX, rootY+height/2);
        }

        return location;
    }

    @Override
    public void draw(Graphics g) {
        Point location = getLocation();

        int x = location.x - 3;
        int y = location.y - 3;

        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Cursor getCursor() {
        return null;
    }

    @Override
    public boolean contains(int x, int y) {
        return owner.contains(x, y);
    }

    @Override
    public void startInteraction(int x, int y, MouseEvent e, DrawView v) {

    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

    }

    @Override
    public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {

    }
}
