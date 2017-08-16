package com.comlu.projecthj.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.comlu.projecthj.game.GameObject;

public class Box extends GameObject {

	public Box(int x, int y) {
		super(x, y);
	}

	public void tick() {	
		x += vX;
		y += vY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
	}

	public Rectangle getBounds() {
		return null;
	}

}
