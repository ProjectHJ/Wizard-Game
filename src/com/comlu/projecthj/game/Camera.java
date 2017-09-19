package com.comlu.projecthj.game;

public class Camera {

	Game game;

	private float x, y;

	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject object) {
		int cx = 390;
		int cy = 500;

		x += (((object.getX() - x) - ((960) / 2) + 48) * 0.02f);
		y += (((object.getY() - y) - ((540) / 2) + 32) * 0.02f);

		/**
		 * if (x <= 0) x = 0; if (x >= cx) x = cx; if (y <= 0) y = 0; if (y >=
		 * cy) y = cy;
		 **/
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
