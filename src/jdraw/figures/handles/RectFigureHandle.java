package jdraw.figures.handles;

import jdraw.figures.AbstractRectFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by lukasmusy
 */

public class RectFigureHandle implements FigureHandle {
    private AbstractRectFigure owner;
    private HandleType type;

    private Point corner;

    public int size = 6;

    public RectFigureHandle(AbstractRectFigure f, HandleType t) {
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
            case NORTH_WEST: location = bounds.getLocation();
                break;
            case NORTH: location = new Point(rootX+width/2, rootY);
                break;
            case NORTH_EAST: location = new Point(rootX+width, rootY);
                break;
            case EAST: location = new Point(rootX+width, rootY+height/2);
                break;
            case SOUTH_EAST: location = new Point(rootX+width, rootY+height);
                break;
            case SOUTH: location = new Point(rootX+width/2, rootY+height);
                break;
            case SOUTH_WEST: location = new Point(rootX, rootY+height);
                break;
            case WEST: location = new Point(rootX, rootY+height/2);
                break;
        }

        return location;
    }

    @Override
    public void draw(Graphics g) {
        Point location = getLocation();

        int x = location.x - size/2;
        int y = location.y - size/2;

        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Cursor getCursor() {
        Cursor cursor = null;

        switch (type) {
            case NORTH_WEST: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
                break;
            case NORTH: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
                break;
            case NORTH_EAST: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
                break;
            case EAST: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
                break;
            case SOUTH_EAST: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
                break;
            case SOUTH: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
                break;
            case SOUTH_WEST: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
                break;
            case WEST: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
                break;
        }

        return cursor;
    }

    @Override
    public boolean contains(int x, int y) {
        Point location = getLocation();
        Rectangle handleRect = new Rectangle(location.x-size/2, location.y-size/2, size, size);;

        return handleRect.contains(x, y);
    }

    @Override
    public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
        List<FigureHandle> handles =  owner.getHandles();

        switch (type) {
            case NORTH_WEST: corner = handles.g;
                break;
            case NORTH: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
                break;
            case NORTH_EAST: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
                break;
            case EAST: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
                break;
            case SOUTH_EAST: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
                break;
            case SOUTH: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
                break;
            case SOUTH_WEST: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
                break;
            case WEST: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
                break;
        }
    }

    @Override
    public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
         owner.setBounds(new Point(x, y), corner);

    }

    @Override
    public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {

    }
}
