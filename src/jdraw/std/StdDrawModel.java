/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.*;

import jdraw.figures.Rect;
import jdraw.framework.DrawCommandHandler;
import jdraw.framework.DrawModel;
import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelEvent.Type;
import jdraw.framework.DrawModelListener;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author Lukas Musy
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {
	
	private final LinkedList<Figure> figures = new LinkedList<>();
	private final Set<DrawModelListener> listeners = new HashSet<>();
	
	@Override
	public void addFigure(Figure f) {
		if(!figures.contains(f)) {
			f.addFigureListener(this);
			figures.add(f);
			notifyModelListeners(f, Type.FIGURE_ADDED);
		}
	}
	
	private void notifyModelListeners(Figure f, Type type) {
		for (DrawModelListener l : new HashSet<>(listeners)) {
			l.modelChanged(new DrawModelEvent(this, f, type));
		}
	}

	@Override
	public Iterable<Figure> getFigures() {
		return figures; 
	}

	@Override
	public void removeFigure(Figure f) {
		if (figures.contains(f)) {
			f.removeFigureListener(this);
			figures.remove(f);
			notifyModelListeners(f, Type.FIGURE_REMOVED);

		}
			
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		try {
			listeners.remove(listener);
		} catch (NoSuchElementException e) {
			System.out.println("No such listener in Model to remove");
		}
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
		if (!figures.contains(f))
			throw new IllegalArgumentException();
		
        if (index < 0 || index > figures.size()-1)
            throw  new IndexOutOfBoundsException();

		Figure figure = figures.remove(figures.indexOf(f));
		figures.add(index, figure);
		notifyModelListeners(f, Type.DRAWING_CHANGED);
	}

	@Override
	public void removeAllFigures() {
        for (Figure f : figures)
            f.removeFigureListener(this);

		figures.clear();
        notifyModelListeners(null, Type.DRAWING_CLEARED);
        listeners.clear();
	}

	@Override
	public void figureChanged(FigureEvent e) {
		notifyModelListeners(e.getFigure(), Type.FIGURE_CHANGED);
		
	}

}
