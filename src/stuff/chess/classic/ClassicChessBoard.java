package stuff.chess.classic;

import stuff.Board;
import stuff.Figure;
import stuff.parameters.Color;
import stuff.parameters.Coordinates;
import stuff.parameters.Orientation;

/**
 *
 * @author massakra
 */
public class ClassicChessBoard extends Board {
	public ClassicChessBoard() { super(8, 8); }
	
	@Override
	public void fill() {
		Coordinates position = new Coordinates();
		Color color = Color.white;
		Orientation orient = Orientation.top;
		/**
		 * Fill white people on bottom 
		 */
		position.y = 1;
		/** Pawns */
		for(position.x = 0; position.x < 8; position.x++) {
			Pawn pawn = new Pawn(position);
			pawn.color(color);
			pawn.orientation(orient);
			super.setFigure(pawn, position);
		}
		position.y = 0;
		/** Rooks */
		int[] rooksXPositions = {0, 7};
		for(int i = 0; i < 2; i++)
		{
			position.x = rooksXPositions[i];
			Rook rook = new Rook(position);
			rook.color(color);
			rook.orientation(orient);
			super.setFigure(rook, position);
		}
		/** Bishops */
		int[] bishopsXPositions = {2, 5};
		for(int i = 0; i < 2; i++)
		{
			position.x = bishopsXPositions[i];
			Bishop bishop = new Bishop(position);
			bishop.color(color);
			bishop.orientation(orient);
			super.setFigure(bishop, position);
		}
		/** Knights */
		int[] knightsXPositions = {1, 6};
		for(int i = 0; i < 2; i++)
		{
			position.x = knightsXPositions[i];
			Knight knight = new Knight(position);
			knight.color(color);
			knight.orientation(orient);
			super.setFigure(knight, position);
		}
		/** King */
		position.x = 3;
		King king = new King(position);
		king.color(color);
		king.orientation(orient);
		super.setFigure(king, position);
		/** Queen */
		position.x = 4;
		Queen queen = new Queen(position);
		queen.color(color);
		queen.orientation(orient);
		super.setFigure(queen, position);
		
			
		/** 
		 * Fill black people on top
		 */
		color = Color.black;
		orient = Orientation.bottom;
		position.y = 6;
		/** Pawns */
		for(position.x = 0; position.x < 8; position.x++) {
			Pawn pawn = new Pawn(position);
			pawn.color(color);
			pawn.orientation(orient);
			super.setFigure(pawn, position);
		}
		position.y = 7;
		/** Rooks */
		for(int i = 0; i < 2; i++)
		{
			position.x = rooksXPositions[i];
			Rook rook = new Rook(position);
			rook.color(color);
			rook.orientation(orient);
			super.setFigure(rook, position);
		}
		/** Bishops */
		for(int i = 0; i < 2; i++)
		{
			position.x = bishopsXPositions[i];
			Bishop bishop = new Bishop(position);
			bishop.color(color);
			bishop.orientation(orient);
			super.setFigure(bishop, position);
		}
		/** Knights */
		for(int i = 0; i < 2; i++)
		{
			position.x = knightsXPositions[i];
			Knight knight = new Knight(position);
			knight.color(color);
			knight.orientation(orient);
			super.setFigure(knight, position);
		}
		/** King */
		position.x = 3;
		King king2 = new King(position);
		king2.color(color);
		king2.orientation(orient);
		super.setFigure(king2, position);
		/** Queen */
		position.x = 4;
		Queen queen2 = new Queen(position);
		queen2.color(color);
		queen2.orientation(orient);
		super.setFigure(queen2, position);
		
	}
	
	@Override
	public boolean move(Figure figure, Coordinates toPosition)
	{
		Coordinates fromPosition = new Coordinates(figure.x(), figure.y());
		
		/**
		 * Is this move or attack.
		 * 
		 * If on this coordinates no figure than it is move.
		 * Else it is attack.
		 */
		Figure figureOnMovePosition = super.figure(toPosition);
		if(figureOnMovePosition == null)
		{
			/** Move */
			if(figure.isMoveCorrect(toPosition))
			{
				if( ! figure.ignoreObstacle())
				{
					if(super.isObstacles(figure.moveDirection(), fromPosition, toPosition))
					{
						System.out.println("Figure " + figure.x() + "," + figure.y() + " can not move to this cell " + toPosition.x + "," + toPosition.y + " becouse of obstacle");
						return false;
					}
				}
				super.removeFigure(fromPosition);
				figure.move(toPosition);
				super.setFigure(figure, toPosition);
			}
			else
			{
				System.out.println("Figure " + figure.x() + "," + figure.y() + " can not move to this cell " + toPosition.x + "," + toPosition.y);
				return false;
			}
		}
		else if(figureOnMovePosition.color() != figure.color())
		{
			/** Attack */
			if(figure.isAttackCorrect(toPosition))
			{
				if( ! figure.ignoreObstacle())
				{
					Coordinates from = new Coordinates(figure.x(), figure.y());
					if(super.isObstacles(figure.moveDirection(), from, toPosition))
					{
						System.out.println("Figure " + figure.x() + "," + figure.y() + " can not attack this cell " + toPosition.x + "," + toPosition.y + " becouse of obstacle");
						return false;
					}
				}
				super.removeFigure(fromPosition);
				figure.attack(toPosition);
				super.setFigure(figure, toPosition);
			} 
			else 
			{
				System.out.println("Figure " + figure.x() + "," + figure.y() + " can not attack this cell " + toPosition.x + "," + toPosition.y);
				return false;
			}
		}
		else
		{
			System.out.println("Figure " + figure.x() + "," + figure.y() + " can not attack friendly figure " + toPosition.x + "," + toPosition.y);
			return false;
		}
		return true;
	}
}
