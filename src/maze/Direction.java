package maze;

public enum Direction {
	XPOS("X+"),
	XNEG("X-"),
	YPOS("Y+"),
	YNEG("Y-");
	
	String value;
	
	Direction(String val) {
		value = val;
	}

}
