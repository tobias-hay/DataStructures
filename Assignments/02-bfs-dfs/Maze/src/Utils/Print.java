package Utils;

public class Print {
	public static void print(String msg) {
		System.out.print(msg);
	}

	public static void back(int n) {
		System.out.print(CLR.BACK_LN.toString().repeat(n));
	}

	public static void back(int n, boolean clear) {
		for (int i = 0; i < n; i++) {
			System.out.print(CLR.BACK_LN.toString() + (clear ? CLR.CLEAR : ""));
		}
	}

	public static void printO(String msg, int ln) {
		back(ln);
		print(msg);
	}

	public static void printO(String msg, int ln, boolean clear) {
		back(ln, clear);
		print(msg);
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
