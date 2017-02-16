package stuff.parameters;

/**
 *
 * @author massakra
 */
public class Coordinates 
{
	public int x;
	public int y;
	public Coordinates() { 
		this.x = 0; this.y = 0; 
	};
	public Coordinates(int x, int y) { 
		this.set(x, y); 
	}
	public void set(int x, int y)
	{
		this.x = x; this.y = y; 
	}
}
