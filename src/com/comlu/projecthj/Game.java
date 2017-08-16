package com.comlu.projecthj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.comlu.projecthj.window.Window;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static int MAJOR_VERSION = 1, BUILD_VERSION = 1, MINOR_VERSION = 0;

	private static String BUILD = "Alpha";
	private static String NAME = "Wizard Game";

	private static String TITLE = NAME + " " + BUILD + "_" + MAJOR_VERSION + "." + BUILD_VERSION + "." + MINOR_VERSION;

	private boolean isRunning = false;
	private Thread thread;

	private static int width = 960, height = width / 16 * 9;
	
	public Game() {
		new Window(width, height, TITLE, this);
		start();
	}

	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 100000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				System.out.println("isRunning" + isRunning+ " : " + frames);
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}

	public void render() {
		int numBuffers = 3;
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(numBuffers);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		g.dispose();
		bs.show();
	}

	public void tick() {

	}

	public static void main(String[] args) {
		new Game();
	}
}
