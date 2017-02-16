package stuff.chess.classic;

import stuff.Figure;
import stuff.parameters.Coordinates;
import stuff.parameters.Direction;
import stuff.parameters.Orientation;

/**
 *
 * @author massakra
 */
public class Pawn extends Figure {
	
	private boolean isFirstMove = true;
	
	/** Initialize parameters */
	{
		super.moveDirection(Direction.straight);
		super.model.model("P ");
	}
	
	/** 
	 * Constructors 
	 */
	public Pawn()
	{
		super();
	}
	public Pawn(Coordinates position)
	{
		super(position);
	}
	
	@Override
	public boolean isMoveCorrect(Coordinates movePosition) {
		/** Not moved */
		if(movePosition.x == this.x() && movePosition.y == this.y()) return false;
		
		int availableStep = this.isFirstMove ? 2 : 1;
		int moveStep = this.y() - movePosition.y;
		boolean isMoveHorizontal = this.x() == movePosition.x;
		boolean isStepCorrect = false;
		if(this.orientation() == Orientation.top)
		{
			isStepCorrect = moveStep < 0;
		}
		else if(this.orientation() == Orientation.bottom)
		{
			isStepCorrect = moveStep > 0;
		}
		isStepCorrect = isStepCorrect && Math.abs(moveStep) <= availableStep;
		return isMoveHorizontal && isStepCorrect;
	}
	
	@Override
	public boolean isAttackCorrect(Coordinates attackPosition) {
		/** Not moved */
		if(attackPosition.x == this.x() && attackPosition.y == this.y()) return false;
		
		int availableStep = 1;
		int attackStep = this.y() - attackPosition.y;
		boolean isMoveDiagonal = (Math.abs(this.x() - attackPosition.x) == availableStep) && (Math.abs(this.y() - attackPosition.y) == availableStep);
		boolean isStepCorrect = false;
		if(this.orientation() == Orientation.top)
		{
			isStepCorrect = attackStep < 0;
		}
		else if(this.orientation() == Orientation.bottom)
		{
			isStepCorrect = attackStep > 0;
		}
		isStepCorrect = isStepCorrect && Math.abs(attackStep) <= availableStep;
		return isMoveDiagonal && isStepCorrect;
	}
	
	@Override
	public void move(Coordinates position)
	{
		super.move(position);
		if(this.isFirstMove == true) this.isFirstMove = false;
	}
}
