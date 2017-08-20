package com.comlu.projecthj.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject {

	Handler handler;

	public Wizard(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += vX;
		y += vY;

		collision();

		if (handler.isUp())
			vY = -1f;
		else if (!handler.isDown())
			vY = 0;

		if (handler.isDown())
			vY = 1f;
		else if (!handler.isUp())
			vY = 0;

		if (handler.isRight())
			vX = 1f;
		else if (!handler.isLeft())
			vX = 0;

		if (handler.isLeft())
			vX = -1f;
		else if (!handler.isRight())
			vX = 0;

		if (handler.isLeft() && handler.isRight())
			vX = 0;
		if (handler.isUp() && handler.isDown())
			vY = 0;
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Wall || tempObj.getId() == ID.Wall_Connected_Right
					|| tempObj.getId() == ID.Wall_Connected_Up) {
				if (getBounds().intersects(tempObj.getBounds())) {
					x += vX * -1;
					y += vY * -1;
				}
			}
		}
	}

	public void render(Graphics g) {
		/**
		 * g.setColor(Color.BLUE); g.fillRect((int) (x), (int) (y), 32, 32);
		 * g.setColor(new Color(100, 100, 245)); g.drawRect(x, y, 32, 32);
		 * g.drawRect(x + 1, y + 1, 30, 30);
		 **/

		g.setColor(new Color(255, 174, 124));
		g.fillRect(x + 8, y, 20, 32);
		g.setColor(Color.BLACK);
		g.fillRect(x + 11, y + 4, 5, 5);
		g.fillRect(x + 20, y + 4, 5, 5);
		g.fillRect(x + 10, y + 12, 16, 3);
		g.setColor(Color.RED.darker());
		g.fillRect(x + 8, y + 20, 20, 20);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 0, 0);
	}

}
