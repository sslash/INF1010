class Main {
	public static void main(String [] args ) {

	}
}

// Simple container that should collect Games
class GameContainer {

}



class Game {
	private String name;

	public Game( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Ps3Game extends Game {

	public Ps3Game (String name ) {
		super (name);
	}
}

class WiiGame extends Game {
	public WiiGame( String name ) {
		super ( name );
	}
}

class XboxGame extends Game {
	public XboxGame ( String name ) {
		super ( name );
	}
}

