package com.comlu.projecthj.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.comlu.projecthj.game.GameObject;
import com.comlu.projecthj.id.ID;

public class Box extends GameObject {

	public Box(int x, int y, ID id) {
		super(x, y, id);
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
