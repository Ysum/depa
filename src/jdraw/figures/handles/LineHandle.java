package jdraw.figures.handles;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by lukasmusy
 */
public class LineHandle implements FigureHandle {

    public LineHandle(Figure f, HandleType t) {

    }


    @Override
    public Figure getOwner() {
        return null;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public Cursor getCursor() {
        return null;
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
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
