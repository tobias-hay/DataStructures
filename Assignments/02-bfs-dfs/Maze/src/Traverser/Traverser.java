package Traverser;

import MazeBuilder.CellState;
import MazeBuilder.CellType;

import java.util.Scanner;

import MazeBuilder.Builder;
import MazeBuilder.Builder.Point;
import Structures.Stack;

public class Traverser {
	private Builder mazeBuilder;
	private Point start;

	public Traverser(Builder mazeBuilder) {
		this.mazeBuilder = mazeBuilder;
		this.start = mazeBuilder.getStart();
	}

	public void dfs() {
		Scanner sc = new Scanner(System.in);
		int dist = 0;
		Stack<Point> points = new Stack<>();
		points.push(start);

		while (!points.isEmpty()) {
			Point currPt = points.pop();
			CellState currState = mazeBuilder.get(currPt);

			// System.out.println("Pts Empty: " + points.isEmpty());
			// System.out.println("Point: " + currPt);
			// System.out.println("State: " + currState);
			// System.out.println(points);

			if (currState.type == CellType.END) {
				System.out.println("Found END at " + currPt);
				sc.close();
				System.out.println(mazeBuilder);

				backtrack(currPt);
				return;
			}

			mazeBuilder.visit(currPt);
			dist++;

			Point nPt = currPt.north();
			if (mazeBuilder.canVisit(nPt)) {
				// System.out.println("Pushing North: " + nPt);
				mazeBuilder.setDist(nPt, dist);
				points.push(nPt);
			}

			Point sPt = currPt.south();
			if (mazeBuilder.canVisit(sPt)) {
				// System.out.println("Pushing South: " + sPt);
				mazeBuilder.setDist(sPt, dist);
				points.push(sPt);
			}

			Point ePt = currPt.east();
			if (mazeBuilder.canVisit(ePt)) {
				// System.out.println("Pushing East: " + ePt);
				mazeBuilder.setDist(ePt, dist);
				points.push(ePt);
			}

			Point wPt = currPt.west();
			if (mazeBuilder.canVisit(wPt)) {
				// System.out.println("Pushing West: " + wPt);
				mazeBuilder.setDist(wPt, dist);
				points.push(wPt);
			}

			// System.out.println(points);
			// System.out.println(mazeBuilder);
			// String r = sc.nextLine();
		}

		System.out.println(mazeBuilder);
		System.out.println("Maze is impossible to solve");

		sc.close();
	}

	private void backtrack(Point endPt) {
		Point currPt = endPt;
		CellState currState = mazeBuilder.get(currPt);

		while (currState.type.equals(CellType.EMPTY) || currState.type.equals(CellType.END)) {
			if (!currState.type.equals(CellType.END)) {
				mazeBuilder.setPath(currPt);
			}

			// System.out.println("Curr State: " + currState);
			// System.out.println("Curr Pt: " + currPt);

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

			// System.out.println("New State: " + currState);
			// System.out.println("New Pt: " + currPt);
		}

		System.out.println(mazeBuilder);
	}
}
