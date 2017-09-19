package com.comlu.projecthj.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cube extends Enemy {

	public Cube(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	public void tick() {

	}

	public void render(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawString(hp + "/" + maxHP, x - 3, y + 44);
		// g.drawString((x) + "/" + (y), x + 32, y + 16);

		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 32, 32);

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public Rectangle getBoundsBig() {
		return new Rectangle(x - 16, y - 16, 64, 64);
	}

}
