package com.comlu.projecthj.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private boolean up = false, down = false, right = false, left = false;
		
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObj = object.get(i);

			tempObj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObj = object.get(i);
			
			tempObj.render(g);
		}
	}
	
	public void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();

		for (int xx = 0; xx < w; xx++) {
			for (int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int RED = (pixel >> 16) & 0xff;
				int GREEN = (pixel >> 8) & 0xff;
				int BLUE = (pixel) & 0xff;

				switch (RED) {
				case 255:
					addObject(new Wall(xx * 32, yy * 32, ID.Wall));
					break;
				case 190:
					addObject(new WallConnectedRight(xx * 32, yy * 32, ID.Wall_Connected_Right));
					break;
				case 128:
					addObject(new WallConnectedUp(xx * 32, yy * 32, ID.Wall_Connected_Up));
					break;
				}

				switch (GREEN) {

				}

				switch (BLUE) {
				case 255:
					addObject(new Wizard(xx * 32, yy * 32, ID.Player, this));
				}
			}
		}
	}
	
	public void addObject(GameObject tempObj) {
		object.add(tempObj);
		System.out.println("Adding Objects : " + object.size());
	}
	
	public void remObject(GameObject tempObj) {
		object.remove(tempObj);
		System.out.println("Removing Objects : " + object.size());
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
}
