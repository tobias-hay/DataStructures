package Traverser;

import MazeBuilder.CellState;
import MazeBuilder.CellType;

import java.util.Scanner;

import MazeBuilder.Builder;
import MazeBuilder.Builder.Point;
import Structures.Queue;
import Structures.Stack;

public class Traverser {
	private Builder mazeBuilder;
	private Scanner sc;

	public Traverser(Builder mazeBuilder) {
		this.mazeBuilder = mazeBuilder;
		this.sc = new Scanner(System.in);
	}

	public void dfs() {
		mazeBuilder.reset();
		Point start = mazeBuilder.getStart();

		int dist = 0;
		Stack<Point> points = new Stack<>();
		points.push(start);

		System.out.println("DFS (Stack) based solution:");

		while (!points.isEmpty()) {
			Point currPt = points.pop();
			CellState currState = mazeBuilder.get(currPt);

			if (currState.type == CellType.END) {
				System.out.println("Found END at " + currPt);

				backtrack(currPt);
				return;
			}

			mazeBuilder.visit(currPt);
			dist++;

			Point nPt = currPt.north();
			if (mazeBuilder.canVisit(nPt)) {
				mazeBuilder.setDist(nPt, dist);
				points.push(nPt);
			}

			Point sPt = currPt.south();
			if (mazeBuilder.canVisit(sPt)) {
				mazeBuilder.setDist(sPt, dist);
				points.push(sPt);
			}

			Point ePt = currPt.east();
			if (mazeBuilder.canVisit(ePt)) {
				mazeBuilder.setDist(ePt, dist);
				points.push(ePt);
			}

			Point wPt = currPt.west();
			if (mazeBuilder.canVisit(wPt)) {
				mazeBuilder.setDist(wPt, dist);
				points.push(wPt);
			}

			// String r = sc.nextLine();
		}

		System.out.println(mazeBuilder);
		System.out.println("Maze is impossible to solve");
	}

	public void bfs() {
		mazeBuilder.reset();
		Point start = mazeBuilder.getStart();

		int dist = 0;
		Queue<Point> points = new Queue<>();
		points.enqueue(start);

		System.out.println("BFS (Queue) based solution:");

		while (!points.isEmpty()) {
			Point currPt = points.dequeue();
			CellState currState = mazeBuilder.get(currPt);

			if (currState.type == CellType.END) {
				System.out.println("Found END at " + currPt);

				backtrack(currPt);
				return;
			}

			if (!currState.visited) {
				mazeBuilder.visit(currPt);
				dist++;

				Point nPt = currPt.north();
				if (mazeBuilder.canVisit(nPt)) {
					mazeBuilder.setDist(nPt, dist);
					points.enqueue(nPt);
				}

				Point sPt = currPt.south();
				if (mazeBuilder.canVisit(sPt)) {
					mazeBuilder.setDist(sPt, dist);
					points.enqueue(sPt);
				}

				Point ePt = currPt.east();
				if (mazeBuilder.canVisit(ePt)) {
					mazeBuilder.setDist(ePt, dist);
					points.enqueue(ePt);
				}

				Point wPt = currPt.west();
				if (mazeBuilder.canVisit(wPt)) {
					mazeBuilder.setDist(wPt, dist);
					points.enqueue(wPt);
				}

				// String l = sc.nextLine();
			}
		}

		System.out.println(mazeBuilder);
		System.out.println("Maze is impossible to solve");
	}

	private void backtrack(Point endPt) {
		Point currPt = endPt;
		CellState currState = mazeBuilder.get(currPt);

		while (currState.type.equals(CellType.EMPTY) || currState.type.equals(CellType.END)) {
			if (!currState.type.equals(CellType.END)) {
				mazeBuilder.setPath(currPt);
			}

			Point nPt = currPt.north();
			Point sPt = currPt.south();
			Point ePt = currPt.east();
			Point wPt = currPt.west();

			int nDist = mazeBuilder.get(nPt).dist;
			int sDist = mazeBuilder.get(sPt).dist;
			int eDist = mazeBuilder.get(ePt).dist;
			int wDist = mazeBuilder.get(wPt).dist;

			int minDist = Math.min(Math.min(eDist, wDist), Math.min(nDist, sDist));

			if (minDist == nDist) {
				currPt = nPt;
			} else if (minDist == sDist) {
				currPt = sPt;
			} else if (minDist == eDist) {
				currPt = ePt;
			} else if (minDist == wDist) {
				currPt = wPt;
			}

			currState = mazeBuilder.get(currPt);
		}

		System.out.println(mazeBuilder);
	}
}
