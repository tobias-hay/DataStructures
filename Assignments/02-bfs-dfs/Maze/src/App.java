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

		int xSetting = Menu.getXSetting(sc);
		int ySetting = Menu.getYSetting(sc);
		double wallChance = Menu.getWallChance(sc);
		boolean displayX = Menu.getCanDIsplaySize(sc, xSetting, true);
		boolean displayY = Menu.getCanDIsplaySize(sc, ySetting, false);

		if (displayX && displayY) {
			Builder builder = new Builder(xSetting, ySetting, wallChance);
			Traverser traverser = new Traverser(builder);

			Print.print(CLR.GRAY_FG + "Seed for this maze: " + CLR.WHITE_FG + builder.getSeed() + "\n" + CLR.RESET);

			traverser.dfs();
			traverser.bfs();
		}

		sc.close();
	}
}
