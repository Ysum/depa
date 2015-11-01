package jdraw.figures;

import java.util.*;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

public abstract class AbstractFigure implements Figure{

	private final Set<FigureListener> figurelistener = new HashSet<>();

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * @return all handles that are attached to the targeted figure.
	 * @see jdraw.framework.Figure#getHandles()
	 */
    @Override
    public List<FigureHandle> getHandles() {
        List<FigureHandle> handles = new LinkedList<>();
        //TODO
        return handles;
    }

	public void addFigureListener(FigureListener listener) {
		if (!figurelistener.contains(listener))
			figurelistener.add(listener);
	}

	public void removeFigureListener(FigureListener listener) {
		if (figurelistener.contains(listener))
				figurelistener.remove(listener);
		else
			System.out.println("No such Figurelistener in Rect Model");
	
	}
	
	public void notifyListener() {
		for (FigureListener l : new HashSet<>(figurelistener)) {
			l.figureChanged(new FigureEvent(this));
		}
	}
	
	public Figure clone() {
		return null;
	}
	
}
