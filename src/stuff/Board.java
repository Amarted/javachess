package stuff;

import stuff.parameters.Coordinates;
import stuff.parameters.Direction;

/**
 *
 * @author massakra
 */
public abstract class Board {

	private int width;
	private int height;
	protected Figure[][] board;

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		this.board = new Figure[this.height][this.width];
	}

	/**
	 * Get figure in coordinates
	 */
	public Figure figure(Coordinates figurePosition) {
		return this.board[figurePosition.x][figurePosition.y];
	}

	/**
	 * Set figure in coordinates
	 */
	public void setFigure(Figure figure, Coordinates figurePosition) {
		this.board[figurePosition.x][figurePosition.y] = figure;
	}

	/**
	 * Set figure in coordinates
	 */
	public void removeFigure(Coordinates figurePosition) {
		this.board[figurePosition.x][figurePosition.y] = null;
	}

	/**
	 * Get width
	 */
	public int width() {
		return this.width;
	}

	/**
	 * Get height
	 */
	public int height() {
		return this.width;
	}

	/**
	 * Check for obstacles on move direction
	 */
	public boolean isObstacles(Direction moveDirection, Coordinates from, Coordinates to) {
		int start = 0;
		int end = 0;
		Coordinates cellCoordinates = new Coordinates();
		switch (moveDirection) {
			case straight:
				if (from.x == to.x) {
					cellCoordinates.x = from.x;
					start = Math.min(from.y, to.y);
					end = Math.max(from.y, to.y);
					/**
					 * Horizontal direction
					 */
					for (int y = start + 1; y < end; ++y) {
						cellCoordinates.y = y;
						if (this.figure(cellCoordinates) != null) {
							return true;
						}
					}
				} else {
					cellCoordinates.y = from.y;
					start = Math.min(from.x, to.x);
					end = Math.max(from.x, to.x);
					/**
					 * Vertical direction
					 */
					for (int x = start + 1; x < end; ++x) {
						cellCoordinates.x = x;
						if (this.figure(cellCoordinates) != null) {
							return true;
						}
					}
				}
				break;

			case diagonal:
				int startY = Math.min(from.y, to.y);
				int endY = Math.max(from.y, to.y);
				int startX = Math.min(from.x, to.x);
				int endX = Math.max(from.x, to.x);
				for (int y = from.y, x = from.x; y != to.y && x != to.x;) {
					if (from.y < to.y) {
						y++;
					} else {
						y--;
					}
					if (from.x < to.x) {
						x++;
					} else {
						x--;
					}
					cellCoordinates.y = y;
					cellCoordinates.x = x;
					if (this.figure(cellCoordinates) != null) {
						return true;
					}
				}
				break;
			case all:
				if (from.x == to.x || from.y == to.y) {
					return isObstacles(Direction.straight, from, to);
				} else {
					return isObstacles(Direction.diagonal, from, to);
				}
		}

		return false;
	}

	/**
	 * Fill board by figures
	 */
	abstract public void fill();

	/**
	 * Render the board with its figures
	 */
	public void render() {
		System.out.println("     0     1     2     3     4     5     6     7  ");
		System.out.println("  -------------------------------------------------");
		for (int y = 0; y < this.height(); y++) {
			System.out.print(y + " ");
			for (int x = 0; x < this.width(); x++) {
				Coordinates position = new Coordinates(x, y);
				if (this.figure(position) != null) {
					System.out.print("| ");
					this.figure(position).render();
					System.out.print(" ");
				} else {
					System.out.print("|     ");
				}
			}
			System.out.println("|");
			System.out.println("  -------------------------------------------------");
		}
	}

	/**
	 * Move figure on board
	 */
	abstract public boolean move(Figure figure, Coordinates movePosition);
}
