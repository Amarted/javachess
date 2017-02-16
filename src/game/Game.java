package game;

/**
 * Total TODOs.
 * 
 */
import java.util.*;
import stuff.chess.classic.ClassicChessBoard;
import stuff.Figure;
import stuff.parameters.Coordinates;
import stuff.parameters.Color;

/**
 *
 * @author massakra
 */
public class Game {

	static GameWindow window = new GameWindow();
	static ClassicChessBoard board = new ClassicChessBoard();
	static Coordinates selected = new Coordinates();
	static Coordinates move = new Coordinates();
	static Figure figure;
	static Color walkColor = Color.white;
	static int turnNumber = 0;
	static Map<String, Integer> cellLeters;
	
	static void initialize() {
		
	}
	
	static void select(int x, int y) throws GameException
	{
		selected.set(x, y);
		figure = board.figure(selected);
		if(figure == null) throw new GameException("No figure in cell " + x + "," + y + ". Current player is " + walkColor + ".");
		else if(figure.color() != walkColor) throw new GameException("Wrong player: " + figure.color()+ "! Turn: " + (turnNumber+1));
		
	}
	
	static void move(int x, int y)
	{
		move.set(x, y);
		if(board.move(figure, move)) {
			changeWalkPlayer();
		}	
		turnNumber++;
	}
	static void move(String cellName)
	{
		int x = 0;
		int y = 0;
		move.set(x, y);
		if(board.move(figure, move)) {
			changeWalkPlayer();
		}	
		turnNumber++;
	}
	private static void createWindow() {
		window = new GameWindow(800, 600);
		window.show();
	}
	private static void changeWalkPlayer() {
		walkColor = walkColor == Color.white ? Color.black : Color.white;
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		initialize();
		board.fill();
		try
		{
			select(1, 1); move(1, 3);
			select(2, 6); move(2, 5);
			select(3, 1); move(3, 3);
			select(2, 5); move(2, 4);
			select(3, 0); move(3, 1);
			select(3, 7); move(2, 6);
			select(3, 1); move(3, 2);
			select(2, 6); move(2, 5);
			select(2, 0); move(5, 3);
			select(2, 5); move(3, 4);
			select(4, 1); move(4, 3);
			select(1, 6); move(1, 5);
			select(5, 0); move(2, 3);
			select(4, 0); move(4, 4);
			
			//select(3, 2); move(4, 2);
			
			//select(0, 5); move(5, 0);
			//select(1, 0); move(2, 2);
			//select(4, 7); move(2, 5);
			/*selected.set(1, 3);
			figure = board.figure(selected);
			board.removeFigure(new Coordinates(1,5));*/
			//if(select(1, 3)) move(0, 6);
		}
		catch(GameException exception)
		{
			System.err.println(exception.toString());
		}
		
		board.render();
	}

}
