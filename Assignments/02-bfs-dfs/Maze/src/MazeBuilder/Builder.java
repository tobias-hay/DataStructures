package MazeBuilder;

import java.util.Random;

public class Builder {
	private static final double DEFAULT_CHANCE = 0.20;

	public record Point(int x, int y) {
		public Point north() {
			return new Point(x, y - 1);
		}

		public Point south() {
			return new Point(x, y + 1);
		}

		public Point east() {
			return new Point(x + 1, y);
		}

		public Point west() {
			return new Point(x - 1, y);
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	};

	private CellState[][] maze;
	private int x;
	private int y;
	private double wallChance;
	private Point start;

	public Builder(int x, int y) {
		this(x, y, DEFAULT_CHANCE);
	}

	public Builder(int x, int y, double wallChance) {
		this.x = x + 2;
		this.y = y + 2;
		this.wallChance = wallChance;
		maze = new CellState[this.y][this.x];

		build();
	}

	private void build() {
		// 133270890541875l || 135909360475000l
		long seed = System.nanoTime();
		Random rand = new Random(seed);

		System.out.println("Seed: " + seed);

		for (int row = 0; row < y; row++) {
			for (int col = 0; col < x; col++) {
				boolean isWall = shouldWall(row, col, rand);

				CellState cell = new CellState(isWall ? CellType.WALL : CellType.EMPTY);
				maze[row][col] = cell;
			}
		}

		int innerX = x - 1;
		int innerY = y - 1;

		int startX = rand.nextInt(1, innerX);
		int startY = rand.nextInt(1, innerY);
		start = new Point(startX, startY);
		setStart(start);

		int endX = rand.nextInt(1, innerX);
		int endY = rand.nextInt(1, innerY);

		// Ensure that start + end don't overlap
		while (endX == startX && endY == startY) {
			endX = rand.nextInt(1, innerX);
			endY = rand.nextInt(1, innerY);
		}

		maze[endY][endX].type = CellType.END;
	}

	private boolean shouldWall(int row, int col, Random rand) {
		return
		// Top + bottom walls
		row == 0 || row == y - 1 ||
		// Left + right walls
				col == 0 || col == x - 1 ||
				// Random walls
				rand.nextDouble() < wallChance;
	}

	public Point getStart() {
		return start;
	}

	public CellState get(Point pt) {
		return maze[pt.y][pt.x];
	}

	public boolean canVisit(Point pt) {
		return !maze[pt.y()][pt.x()].type.equals(CellType.WALL) &&
				!maze[pt.y()][pt.x()].visited;
	}

	public void visit(Point pt) {
		maze[pt.y][pt.x].visited = true;
	}

	public void setDist(Point pt, int dist) {
		maze[pt.y][pt.x].dist = dist;
	}

	public void setPath(Point pt) {
		maze[pt.y][pt.x].type = CellType.PATH;
	}

	public void setStart(Point pt) {
		maze[pt.y][pt.x].type = CellType.START;
		maze[pt.y][pt.x].dist = 0;
	}

	@Override
	public String toString() {
		// top of maze
		String str = "|";
		str += "-".repeat(x) + "|\n";

		// center bits
		for (CellState[] row : maze) {
			str += "|";

			for (CellState cell : row) {
				str += ((cell.visited ? "\033[42m" : "\033[41m") + (cell.type.equals(CellType.PATH) ? "\033[44m" : ""))
						+
						// (cell.type.equals(CellType.EMPTY) ? (cell.dist == Integer.MAX_VALUE ? " " :
						// cell.dist)
						cell.type.toString()
						+ "\033[0m";
			}

			str += "|\n";
		}

		// bottom of maze
		str += "|";
		str += "-".repeat(x) + "|\n";
		return str;
	}
}
