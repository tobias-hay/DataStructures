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
		this.x = x + 2;
		this.y = y + 2;
		this.wallChance = wallChance;
		maze = new CellState[this.y][this.x];

		build();
	}

	private void build() {
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
		maze[startY][startX].type = CellType.START;
		start = new Point(startX, startY);

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
