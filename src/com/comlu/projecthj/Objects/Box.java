package com.comlu.projecthj.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.comlu.projecthj.GameObject;

public class Box extends GameObject {

	public Box(int x, int y) {
		super(x, y);
	}

	public void tick() {	
		x += vX;
		y += vY;
		System.out.println("Ticking");
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
		System.out.println("Rendering");
	}

	public Rectangle getBounds() {
		return null;
	}

}
