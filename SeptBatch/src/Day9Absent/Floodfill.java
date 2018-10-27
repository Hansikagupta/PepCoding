package Day9Absent;

public class Floodfill {

	public static void main(String[] args) {
		boolean[][] maze = { { true, false, true, true, true, true, true, true },
				{ true, false, true, false, false, false, false, true },
				{ true, true, true, false, false, true, true, true },
				{ true, false, true, true, true, true, false, false },
				{ true, false, true, false, false, true, false, false },
				{ true, false, true, true, true, true, true, true } };
		boolean[][] visited = new boolean[6][8];
		floodfill(maze, visited, 0, 0, "");
	}

	private static void floodfill(boolean[][] maze, boolean[][] visited, int currRow, int curCol, String asf) {
		if (currRow == maze.length - 1 && curCol == maze[0].length - 1) {
			System.out.println(asf);
			return;
		}
		if (currRow < maze.length && currRow >= 0 && curCol < maze[0].length && curCol >= 0) {
			if (visited[currRow][curCol] == false && maze[currRow][curCol] == true) {
				visited[currRow][curCol] = true;
				floodfill(maze, visited, currRow + 1, curCol, asf + "d");
				floodfill(maze, visited, currRow, curCol + 1, asf + "r");
				floodfill(maze, visited, currRow, curCol - 1, asf + "l");
				floodfill(maze, visited, currRow - 1, curCol, asf + "u");
				visited[currRow][curCol] = false;
			}
		} else
			return;
	}
}
