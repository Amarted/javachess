/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

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
public class GameTest {
	Pawn whitePawn;
	Pawn blackPawn;
	public GameTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		whitePawn = new Pawn(new Coordinates(1, 1));
		whitePawn.orientation(Orientation.top);
		whitePawn.color(Color.white);
		blackPawn= new Pawn(new Coordinates(2, 2));
		blackPawn.orientation(Orientation.bottom);
		blackPawn.color(Color.black);
	}
	
	@After
	public void tearDown() {
		whitePawn = null;
		blackPawn = null;
	}

	@Test
	public void attackEnemy() {
		
	}
	
	@Test
	public void attackFriendly() {
		
	}
	
	@Test
	public void moveQueue() {
		
	}
	
	@Test
	public void boardEnd() {
		
	}
	
	@Test
	public void obstacle() {
		
	}
	
	@Test
	public void obstacleIgnoring() {
		
	}

	/**
	 * Test of select method, of class Game.
	 */
	@Test
	public void testSelect() throws Exception {
		System.out.println("select");
		int x = 0;
		int y = 0;
		boolean expResult = false;
		boolean result = Game.select(x, y);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of move method, of class Game.
	 */
	@Test
	public void testMove() {
		System.out.println("move");
		int x = 0;
		int y = 0;
		Game.move(x, y);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of main method, of class Game.
	 */
	@Test
	public void testMain() {
		System.out.println("main");
		String[] args = null;
		Game.main(args);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
