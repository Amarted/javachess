/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stuff;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import stuff.chess.classic.Pawn;
import stuff.parameters.Color;
import stuff.parameters.Coordinates;
import stuff.parameters.Orientation;

/**
 *
 * @author massakra
 */
public class PawnTest {
	
	Pawn pawn;
	public PawnTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		pawn = new Pawn(new Coordinates(1, 1));
		pawn.orientation(Orientation.top);
	}
	
	@After
	public void tearDown() {
		pawn = null;
	}
	@Test 
	public void startCoordinates() {
		assertEquals(1, pawn.x());
		assertEquals(1, pawn.y());
	}
	
	@Test
	public void moveFollow() {
		pawn.move(new Coordinates(1, 2));
		assertEquals(1, pawn.x());
		assertEquals(2, pawn.y());
	}
	
	@Test
	public void moveDiagonalWrong() {
		pawn.move(new Coordinates(2, 2));
		assertEquals(1, pawn.x());
		assertEquals(1, pawn.y());
	}
	
	@Test
	public void moveBackWrong() {
		pawn.move(new Coordinates(1, 0));
		assertEquals(1, pawn.x());
		assertEquals(1, pawn.y());
	}
	
	@Test
	public void moveTwoCellOnlyAtFirstTime() {
		/** Two cell at first time */
		pawn.move(new Coordinates(1, 3));
		assertEquals(1, pawn.x());
		assertEquals(3, pawn.y());
		/** Two cell one more time */
		pawn.move(new Coordinates(1, 5));
		assertEquals(1, pawn.x());
		assertEquals(3, pawn.y());
	}
	
	@Test
	public void attack() {
		pawn.attack(new Coordinates(0, 2));
		assertEquals(0, pawn.x());
		assertEquals(2, pawn.y());
	}
	
	@Test
	public void attackBackWrong() {
		pawn.attack(new Coordinates(2, 0));
		assertEquals(1, pawn.x());
		assertEquals(1, pawn.y());
	}
	
}
