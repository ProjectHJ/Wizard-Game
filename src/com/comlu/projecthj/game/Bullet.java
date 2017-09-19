package com.comlu.projecthj.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Handler handler;

	public int SPEED = 12;

	public Bullet(int x, int y, ID id, Handler handler, int mx, int my) {
		super(x, y, id);
		this.handler = handler;

		vX = (mx - x) / SPEED;
		vY = (my - y) / SPEED;
	}

	public void tick() {
		x += vX;
		y += vY;

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Wall || tempObj.getId() == ID.Wall_Connected_Right
					|| tempObj.getId() == ID.Wall_Connected_Up || tempObj.getId() == ID.Enemy) {
				if (getBounds().intersects(tempObj.getBounds())) {
					handler.remObject(this);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 8, 8);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
