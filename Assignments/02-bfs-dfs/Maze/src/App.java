import java.util.Scanner;

import MazeBuilder.Builder;
import Traverser.Traverser;
import Utils.CLR;
import Utils.Menu;
import Utils.Print;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println(CLR.BOLD + "Welcome to the Maze Solver!!!" + CLR.RESET);

		boolean inputSeed = Menu.getInputSeed(sc);
		int xSetting = 0;
		int ySetting = 0;
		long wallSeed = 0l;

		if (inputSeed) {
			String seed = Menu.getSeed(sc);

			String[] seedParts = seed.split(";");
			try {
				if (seedParts.length > 1) {
					xSetting = Integer.parseInt(seedParts[0]);
					ySetting = Integer.parseInt(seedParts[1]);
					wallSeed = Long.parseLong(seedParts[2]);

				} else {
					wallSeed = Long.parseLong(seed);
					xSetting = Menu.getXSetting(sc);
					ySetting = Menu.getYSetting(sc);
				}
			} catch (Exception e) {
				System.err.print("Error parsing seed: " + e);
			}
		} else {
			xSetting = Menu.getXSetting(sc);
			ySetting = Menu.getYSetting(sc);
		}

		double wallChance = Menu.getWallChance(sc);

		boolean displayX = Menu.getCanDisplaySize(sc, xSetting, true);
		while (!displayX) {
			Print.print("Please enter a width that can be fully displayed\n");
			xSetting = Menu.getXSetting(sc);
			displayX = Menu.getCanDisplaySize(sc, xSetting, true);
		}

		boolean displayY = Menu.getCanDisplaySize(sc, ySetting, false);
		while (!displayY) {
			Print.print("Please enter a height that can be fully displayed\n");
			ySetting = Menu.getXSetting(sc);
			displayY = Menu.getCanDisplaySize(sc, ySetting, false);
		}

		if (displayX && displayY) {
			Builder builder;

			if (wallSeed != 0l) {
				builder = new Builder(xSetting, ySetting, wallSeed, wallChance);
			} else {
				builder = new Builder(xSetting, ySetting, wallChance);
			}

			Traverser traverser = new Traverser(builder);

			Print.print(CLR.GRAY_FG + "Seed for this maze: " + CLR.WHITE_FG + builder.getSeed() + "\n" + CLR.RESET);

			traverser.dfs();
			traverser.bfs();
		}

		sc.close();
	}
}
