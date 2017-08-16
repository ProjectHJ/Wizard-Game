package com.comlu.projecthj.game.objects.entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.comlu.projecthj.game.GameObject;
import com.comlu.projecthj.id.ID;

public class Wizard extends GameObject {

	public Wizard(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += vX;
		y += vY;
		
	}

	public void render(Graphics g) {
		
	}

	public Rectangle getBounds() {
		return null;
	}

}
