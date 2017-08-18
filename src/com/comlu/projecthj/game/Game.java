package com.comlu.projecthj.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static int MAJOR_VERSION = 1, BUILD_VERSION = 1, MINOR_VERSION = 0, FRAMES = 0;

	private static String BUILD = "Alpha";
	private static String NAME = "Wizard Game";

	private static String TITLE = NAME + " " + BUILD + "_" + MAJOR_VERSION + "." + MINOR_VERSION + "." + BUILD_VERSION;

	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	private Camera camera;

	private BufferedImage level = null;

	public static float width = 960, height = width / 16 * 9;

	public Game() {
		new Window((int) width, (int) height, TITLE, this);
		start();

		handler = new Handler();
		camera = new Camera(0, 0);
		this.addKeyListener(new KeyInput(handler));

		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/levels/level_1.png");

		handler.loadLevel(level);
	}

	public void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
				System.out.println("Frames: " + frames + " Running: " + isRunning);
				FRAMES = frames;
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
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (int) width, (int) height);

		g2d.translate(-camera.getX(), -camera.getY());

		handler.render(g);

		g2d.translate(camera.getX(), camera.getY());

		g.dispose();
		bs.show();
	}

	public void tick() {
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player) {
				camera.tick(handler.object.get(i));
			}
		}

		handler.tick();
	}

	public static void main(String[] args) {
		new Game();
	}
}
