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
public class Knight extends Figure  {
	/** Initialize parameters */
	{
		super.moveDirection(Direction.straight);
		super.model.model("Kn");
	}
	/** 
	 * Constructors
	 */
	public Knight()
	{
		super();
	}
	public Knight(Coordinates position)
	{
		super(position);
	}
	
	@Override
	public boolean isMoveCorrect(Coordinates movePosition) {
		if(Math.abs(x()-movePosition.x) == 1) {
			if(Math.abs(y()-movePosition.y) == 2) {
				return true;
			}
		} else if(Math.abs(y()-movePosition.y) == 1) {
			if(Math.abs(x()-movePosition.x) == 2) {
				return true;
			}
		}
		return false;
	}
	
}
