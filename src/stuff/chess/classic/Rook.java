/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stuff.chess.classic;
import stuff.Figure;
import stuff.parameters.Coordinates;
import stuff.parameters.Direction;

/**
 *
 * @author massakra
 */
public class Rook extends Figure {
	/** Initialize parameters */
	{
		super.moveDirection(Direction.straight);
		super.model.model("R ");
	}
	/** 
	 * Constructors
	 */
	public Rook()
	{
		super();
	}
	public Rook(Coordinates position)
	{
		super(position);
	}
	
	@Override
	public boolean isMoveCorrect(Coordinates movePosition) {
		return (x() == movePosition.x) || (y() == movePosition.y);
	}
	
}
