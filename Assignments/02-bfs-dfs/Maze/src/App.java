import java.util.Scanner;

import MazeBuilder.Builder;
import Traverser.Traverser;
import Utils.CLR;
import Utils.Menu;

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

			traverser.dfs();
			traverser.bfs();
		}

		sc.close();
	}
}
