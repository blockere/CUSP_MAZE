package maze;

public class Maze {
	private static Maze Instance = null;
	//XXX Make this not this when enums
	private char[][] MazeArray = {
									{'_', '_', '_', '_'},
									{'|', ' ', 'G', '|'},
									{'|', 'X', ' ', '|'},
									{'|', 'X', ' ', '|'},
									{'|', 'D', ' ', '|'},
									{'_', '_', '_', '_'} 
								};
	
	private Coordinate droneCurrentPosition;
	private Coordinate goalPosition;
	private Direction facedDirection;
	
	public static Maze getInstance() {
		if(Instance == null) {
			Instance = new Maze();
		}
		
		return Instance;
	}
	
	private Maze() {
		// XXX Set mazeArray = to maze enum.value.
		droneCurrentPosition = findCharInMazeArray('D');
		goalPosition = findCharInMazeArray('G');
		facedDirection = Direction.NORTH;
	}
	
	public Coordinate getDroneCurrentCoordinates() {
		return droneCurrentPosition;
	}
	
	public Direction getDroneDirection() {
		return facedDirection;
	}
	
	public Coordinate getGoalCoordinates() {
		return goalPosition;
	}
	
	public boolean isObjectDetected() {
		Coordinate infrontSpot = getCoordinateInfrontOfDrone();
		char infrontChar = MazeArray[infrontSpot.getY()][infrontSpot.getX()];
		return (infrontChar == 'X' || infrontChar == '|' || infrontChar == '_');
	}
	
	public void moveFoward(){
		if (isObjectDetected()) {
			System.err.println("The drone ran full speed into an impassible object and exploded! Failed solving the maze!");
			System.exit(0);
		}
		
		Coordinate infront = getCoordinateInfrontOfDrone();
		MazeArray[infront.getY()][infront.getX()] = 'D';
		MazeArray[droneCurrentPosition.getY()][droneCurrentPosition.getX()] = ' ';
		droneCurrentPosition = infront;
	}
	
	public void turn(Direction directionToTurn) {
		facedDirection = directionToTurn;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MazeArray.length; i++) {
			for (int j = 0; j < MazeArray[i].length; j++) {
				char curChar = MazeArray[i][j];
				sb.append(" " + curChar + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private Coordinate findCharInMazeArray(char findMe) {
		for(int i = 0; i < MazeArray.length; i++) {
			for(int j = 0; j < MazeArray[i].length; j++) {
				char value = MazeArray[i][j];
				
				if(value == findMe) {
					return new Coordinate(j, i);
				}
			}
		}
		
		System.err.println("Unable to find char: " + findMe + ", in MazeArray");
		System.exit(0);
		return null;
	}
	
	private Coordinate getCoordinateInfrontOfDrone() {
		int currentX = droneCurrentPosition.getX();
		int currentY = droneCurrentPosition.getY();
		int infrontX = currentX;
		int infrontY = currentY;
		
		switch(facedDirection) {
			case EAST:
				infrontX++;
				break;
			case WEST:
				infrontX--;
				break;
			case NORTH:
				infrontY--;
				break;
			case SOUTH:
				infrontY++;
				break;
		}
		
		return new Coordinate(infrontX, infrontY);
	}
	
}
