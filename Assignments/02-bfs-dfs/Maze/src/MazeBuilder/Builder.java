package MazeBuilder;

import java.util.Random;

public class Builder {
	private static final double DEFAULT_CHANCE = 0.20;

	public record Point(int x, int y) {
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
		this.x = x;
		this.y = y;
		this.wallChance = wallChance;
		maze = new CellState[y][x];

		build();
	}

	public void build() {
		Random rand = new Random();

		for (int row = 0; row < y; row++) {
			for (int col = 0; col < x; col++) {
				boolean isWall = Math.random() < wallChance;

				CellState cell = new CellState(isWall ? CellType.WALL : CellType.EMPTY);
				maze[row][col] = cell;
			}
		}

		int startX = rand.nextInt(x);
		int startY = rand.nextInt(y);
		maze[startY][startX].type = CellType.START;
		start = new Point(startX, startY);

		int endX = rand.nextInt(x);
		int endY = rand.nextInt(y);
		maze[endY][endX].type = CellType.END;
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
				str += cell.type.toString() + "";
			}

			str += "|\n";
		}

		// bottom of maze
		str += "|";
		str += "-".repeat(x) + "|\n";
		return str;
	}
}
