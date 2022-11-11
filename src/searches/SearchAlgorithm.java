package searches;

import java.awt.Point;
import java.util.Collection;
import java.util.Queue;

import application.Maze;

public abstract class SearchAlgorithm {
			
	protected Maze maze;					// The maze being solved
	protected Point goal;					// The goal Point - will let us know when search is successful
	protected Point current;				// Current point being explored
	protected Collection<Point> data;		// Data structure used to keep "fringe" points
	
	protected boolean searchOver = false;	// Is search done?
	protected boolean searchResult = false;	// Was it successful?

	
	public SearchAlgorithm(Maze mazeBlocks, Point startPoint, Point goalPoint) {
		maze = mazeBlocks;
		goal = goalPoint;
		current = startPoint;
		maze.markPath(current);
	}
	
	public boolean step(){
		// Don't keep computing after goal is reached or determined impossible.
		if(searchOver){
			colorPath();
			return searchResult;
		}
		// Find possible next steps
		Collection<Point> neighbors = getNeighbors();
		// Choose one to be a part of the path
		Point next = chooseNeighbor(neighbors);
		// mark the next step
		if(next!=null){
			markNextStep(next);
		}
		// if no next step is found, mark current 
		// state "visited" and take off queue.
		else{	
			changeState();
		}
		resetCurrent();
		checkSearchOver();
		return searchResult;	
	}

	private void checkSearchOver() {
		
	}

	private void resetCurrent() {
		
	}

	private void recordLink(Point next) {
		
	}

	private Point chooseNeighbor(Collection<Point> neighbors) {
		return null;
	}

	private Collection<Point> getNeighbors() {
		return null;
	}

	private void colorPath() {

	}
	
	private void markNextStep(Point next) {
		maze.markPath(next);
		recordLink(next);
	}
	
	private void changeState() {
		maze.markVisited(current);
		Queue<Point> queue = (Queue<Point>) data;
		queue.remove();
	}
	
	
	
}
