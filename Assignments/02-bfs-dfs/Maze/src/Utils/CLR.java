package Utils;

public enum CLR {
	RESET("\033[0m"),
	RED_BG("\033[41m"),
	GREEN_BG("\033[42m"),
	BLUE_BG("\033[44m"),
	BACK_LN("\033[F");

	private String code;

	CLR(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code;
	}
}
