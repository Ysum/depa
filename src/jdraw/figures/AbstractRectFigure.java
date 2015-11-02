package jdraw.figures;

import jdraw.figures.handles.HandleType;
import jdraw.figures.handles.RectFigureHandle;
import jdraw.framework.FigureHandle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lukasmusy
 */
public abstract class AbstractRectFigure extends AbstractFigure {

    /**
     * Returns a list of 8 handles for this Rectangle.
     * @return all handles that are attached to the targeted figure.
     * @see jdraw.framework.Figure#getHandles()
     */
    @Override
    public List<FigureHandle> getHandles() {
        List<FigureHandle> handles = new LinkedList<>();

        for (HandleType h : HandleType.values()) {
            handles.add(new RectFigureHandle(this, h));
        }

        return handles;
    }

}
