package Utils;

import java.util.Scanner;

import MazeBuilder.Builder;

public class Menu {
	private static int getInt(Scanner sc, String q, int def) {
		int i = 0;

		while (true) {
			Print.print(q + " (" + def + "): ");
			i++;

			try {
				String l = sc.nextLine().trim();

				if (l.isEmpty()) {
					Print.printO(CLR.GRAY_FG + q + ": " + CLR.GREEN_FG + def + " \n" + CLR.RESET, i, true);
					return def;
				}

				int x = Integer.parseInt(l);

				if (x > 0) {
					Print.printO(CLR.GRAY_FG + q + ": " + CLR.GREEN_FG + x + CLR.RESET + "\n", i, true);
					return x;
				}

				Print.printO(CLR.RED_FG + "Invalid input, please enter a positive number\n" + CLR.RESET, 1, true);
			} catch (Exception e) {
				Print.printO(CLR.RED_FG + "Invalid input, please enter a number\n" + CLR.RESET, 1, true);
			}
		}
	}

	private static double getPercent(Scanner sc, String q, double def) {
		int i = 0;

		while (true) {
			Print.print(q + " (" + def * 100 + "%): ");
			i++;

			try {
				String l = sc.nextLine().trim();

				if (l.isEmpty()) {
					Print.printO(CLR.GRAY_FG + q + ": " + CLR.GREEN_FG + (def * 100) + "% \n" + CLR.RESET, i, true);
					return def;
				}

				int x = Integer.parseInt(l);

				if (x >= 0 && x <= 100) {
					Print.printO(CLR.GRAY_FG + q + ": " + CLR.GREEN_FG + x + "%\n" + CLR.RESET, i, true);
					return x / 100d;
				}

				Print.printO(CLR.RED_FG + "Invalid input, please enter a number between 0 and 100\n" + CLR.RESET, 1, true);
			} catch (Exception e) {
				Print.printO(CLR.RED_FG + "Invalid input, please enter a number\n" + CLR.RESET, 1, true);
			}
		}
	}

	private static boolean getYesNo(Scanner sc, String q, boolean def) {
		Print.print(q + " [" + (def ? "Y/n" : "y/N") + "]: ");

		String l = sc.nextLine().trim();

		if (l.isEmpty()) {
			return printYesNo(q, def);
		}

		if (def) {
			if (l.equalsIgnoreCase("y") || l.equalsIgnoreCase("yes")) {
				return printYesNo(q, true);
			} else {
				return printYesNo(q, false);
			}
		} else {
			if (l.equalsIgnoreCase("n") || l.equalsIgnoreCase("no")) {
				return printYesNo(q, false);
			} else {
				return printYesNo(q, true);
			}
		}
	}

	private static boolean printYesNo(String q, boolean opt) {
		Print.printO(CLR.GRAY_FG + q + ": " + (opt ? (CLR.GREEN_FG + "Yes") : (CLR.RED_FG + "No")) + "\n" + CLR.RESET, 1,
				true);
		return opt;
	}

	private static String getVerifiedSeed(Scanner sc, String q) {
		int i = 0;

		while (true) {
			Print.print(q + ": ");
			i++;

			String l = sc.nextLine().trim();

			if (Builder.verifySeed(l)) {
				Print.printO(CLR.GRAY_FG + q + ": " + CLR.WHITE_FG + l + "\n" + CLR.RESET, i, true);
				return l;
			}

			Print.printO(CLR.RED_FG
					+ "Invalid input, please enter a valid seed of the form <x>;<y>;<wallSeed> or <wallSeed>\n" + CLR.RESET, 1,
					true);
		}
	}

	public static boolean getInputSeed(Scanner sc) {
		String q = "Would you like to input a custom seed";

		return getYesNo(sc, q, false);
	}

	public static String getSeed(Scanner sc) {
		String q = "Enter the seed you would like to use";

		return getVerifiedSeed(sc, q);
	}

	public static int getXSetting(Scanner sc) {
		String q = "Enter the width of the maze";

		return getInt(sc, q, 10);
	}

	public static int getYSetting(Scanner sc) {
		String q = "Enter the height of the maze";

		return getInt(sc, q, 10);
	}

	public static double getWallChance(Scanner sc) {
		String q = "Enter the % chance to spawn a wall";

		return getPercent(sc, q, Builder.DEFAULT_CHANCE);
	}

	public static boolean getCanDIsplaySize(Scanner sc, int size, boolean xDir) {
		String q = "Can your terminal fully display " + (size + 2) + " characters " + (xDir ? "across" : "vertically");

		return getYesNo(sc, q, true);
	}
}
