import MazeBuilder.Builder;
import Traverser.Traverser;

public class App {
	public static void main(String[] args) throws Exception {
		Builder builder = new Builder(20, 20);
		System.out.println(builder);

		Traverser trav = new Traverser(builder);
		trav.dfs();
		trav.bfs();
	}
}
