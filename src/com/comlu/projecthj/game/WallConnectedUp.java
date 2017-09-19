package com.comlu.projecthj.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class WallConnectedUp extends GameObject {
	
	public WallConnectedUp(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(new Color(50, 50, 50));
		g.fillRect(x, y, 32, 32);
		g.setColor(new Color(100, 100, 100));
		g.fillRect(x + 4, y + 4, 24, 24);
		g.setColor(new Color(115, 115, 115));
		g.fillRect(x + 7, y, 18, 32);
		g.setColor(new Color(125, 125, 125));
		g.fillRect(x + 8, y + 8, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
