package MazeBuilder;

public enum CellType {
	EMPTY,
	WALL,
	START,
	END;

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
			default:
				return "?";
		}
	}
}
