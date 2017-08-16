package com.comlu.projecthj;

import java.awt.Canvas;

import com.comlu.projecthj.window.Window;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public Game() { 
		new Window(800, 600, "Wizard Game", this); 
	}
	
	public void run() {	
		
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
