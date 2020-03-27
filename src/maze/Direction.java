package maze;

public enum Direction {
	EAST("E"),
	WEST("W"),
	NORTH("N"),
	SOUTH("S");
	
	String value;
	
	Direction(String val) {
		value = val;
	}

}
