package Utils;

public enum CLR {
	// FG
	GRAY_FG("\033[90m"),
	RED_FG("\033[91m"),
	GREEN_FG("\033[92m"),
	BLUE_FG("\033[94m"),
	MAGENTA_FG("\033[95m"),

	// BG
	RED_BG("\033[41m"),
	GREEN_BG("\033[42m"),
	BLUE_BG("\033[44m"),

	// Extra
	RESET("\033[0m"),
	BACK_LN("\033[F"),
	CLEAR("\033[K"),
	BOLD("\033[1m");

	private String code;

	CLR(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code;
	}
}
