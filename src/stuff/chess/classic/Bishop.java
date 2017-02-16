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
public class Bishop extends Figure {
	/** Initialize parameters */
	{
		super.moveDirection(Direction.diagonal);
		super.model.model("B ");
	}
	/** 
	 * Constructors
	 */
	public Bishop()
	{
		super();
	}
	public Bishop(Coordinates position)
	{
		super(position);
	}
	
	@Override
	public boolean isMoveCorrect(Coordinates movePosition) {
		return Math.abs(x()-movePosition.x) == Math.abs(y()-movePosition.y);
	}
	
}
