package maze;

public class Maze {
	private static Maze Instance = null;
	private char[][] MazeArray;
	
	public static Maze getInstance() {
		if(Instance == null) {
			Instance = new Maze();
		}
		
		return Instance;
	}
	
	private Maze() {
		
	}
	
	
	
	

}
