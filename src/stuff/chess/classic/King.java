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
public class King  extends Figure {
	/** Initialize parameters */
	{
		super.moveDirection(Direction.straight);
		super.model.model("K ");
	}
	/** 
	 * Constructors
	 */
	public King()
	{
		super();
	}
	public King(Coordinates position)
	{
		super(position);
	}

	@Override
	public boolean isMoveCorrect(Coordinates movePosition) {
		
		return (Math.abs(x()-movePosition.x) <= 1) && (Math.abs(y()-movePosition.y) <= 1);
	}
	
}
