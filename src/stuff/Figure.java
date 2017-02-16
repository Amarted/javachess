package stuff;

import stuff.parameters.Orientation;
import stuff.parameters.Coordinates;
import stuff.parameters.Color;
import interfaces.Moveable;
import stuff.parameters.Appearance;
import stuff.parameters.Direction;
/**
 *
 * @author massakra
 */
public abstract class Figure implements Moveable {

	private Coordinates coordinates = new Coordinates();
	protected Appearance model = new Appearance();
	private Color color;
	private Orientation orientation;
	private Direction moveDirection;
	private boolean ignoreObstacle = false;
	
	public Figure() { };
	public Figure(Coordinates position) {
		this.x(position.x); this.y(position.y);
	};
	
	/** Get x coordinate */
	public int x() { return this.coordinates.x; }
	/** Get y coordinate */
	public int y() { return this.coordinates.y; }	
	/** Set x coordinate */
	public void x(int x) { this.coordinates.x = x; }
	/** Set y coordinate */
	public void y(int y) { this.coordinates.y = y; }
	/** Is figure ignoring obstacle? */
	public boolean ignoreObstacle() { return this.ignoreObstacle; }
	/** Move figure to coordinates */
	public void move(Coordinates position) {
		if(this.isMoveCorrect(position)) { this.x(position.x); this.y(position.y); }
	}
	/** Attack figure on coordinates */
	public void attack(Coordinates position) {
		if(this.isAttackCorrect(position)) {
			this.x(position.x); this.y(position.y);
		} else {
			System.out.println("Figure can not attack to this cell!");
		}
	}
	/** Move rules. Check is move is available */
	public abstract boolean isMoveCorrect(Coordinates movePosition);
	/** Attack rules. Check is move is available */
	public boolean isAttackCorrect(Coordinates attackPosition)
	{
		return this.isMoveCorrect(attackPosition);
	}	
	/** Get color */
	public Color color() { return this.color; }
	/** Set color */
	public void color(Color color) { this.color = color; }
	/** Get color */
	public Direction moveDirection() { return this.moveDirection; }
	/** Set color */
	public void moveDirection(Direction moveDirection) { this.moveDirection = moveDirection; }
	/** Get orientation */
	public Orientation orientation() { return this.orientation; }
	/** Set orientation */
	public void orientation(Orientation orientation) { this.orientation = orientation; }
	
	/** Render figure */
	public void render() {
		if(this.color() == Color.white) {
			System.out.print("w");
		} else {
			System.out.print("b");
		}
		this.model.render();
	}
}
