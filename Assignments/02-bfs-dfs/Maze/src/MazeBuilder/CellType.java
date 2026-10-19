package MazeBuilder;

public enum CellType {
	EMPTY,
	WALL,
	START,
	END,
	PATH;

	@Override
	public String toString() {
		switch (this) {
			case EMPTY:
				return " ";
			case WALL:
				return "#";
			case START:
				return "S";
			case END:
				return "E";
			case PATH:
				return "+";
			default:
				return "?";
		}
	}
}
