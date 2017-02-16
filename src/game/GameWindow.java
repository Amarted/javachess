/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * Game main window class
 * @author DemnArctis
 */
public class GameWindow extends JFrame {
	
	boolean _initialized;
	int _width;
	int _height;
	
	public GameWindow( int width, int height) {
		_width = width;
		_height = height;
		_initialized = false;
	}
	
	public void initialize() {
		setTitle("Chess");
		setSize(new Dimension(_width, _height));
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);		
	}
}
