package com.comlu.projecthj.game.objects.camera;

import com.comlu.projecthj.game.Game;
import com.comlu.projecthj.game.GameObject;

public class Camera {

	Game game;

	private float x, y;

	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject object) {
		x += ((object.getX() - x) - ((960) / 2) + 48) * 0.05f;
		y += ((object.getY() - y) - ((540) / 2) + 32) * 0.05f;

		if (x <= 0)
			x = 0;
		if (x >= 960 - 90)
			x = 960 - 90;
		if (y <= 0)
			y = 0;
		if (y >= 540 - 155)
			y = 540 - 155;
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
