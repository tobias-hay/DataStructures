package MazeBuilder;

public class CellState {
	public CellType type;
	public boolean visited;
	public int dist;

	public CellState(CellType type) {
		this.type = type;
		this.visited = false;
		this.dist = Integer.MAX_VALUE;
	}

	@Override
	public String toString() {
		return "(" + type + ", " + visited + ", " + dist + ")";
	}
}
