package com.comlu.projecthj;

import java.awt.Canvas;

import com.comlu.projecthj.window.Window;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 6674382819211038206L;
	public Game() { new Window(1000, 563, "Wizard Game", this); }
	public void run() {	}
	public static void main(String[] args) { }
}
