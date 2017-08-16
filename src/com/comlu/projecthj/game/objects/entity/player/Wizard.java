package com.comlu.projecthj.game.objects.entity.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.comlu.projecthj.game.GameObject;
import com.comlu.projecthj.handlers.Handler;
import com.comlu.projecthj.id.ID;

public class Wizard extends GameObject {

	Handler handler;
	
	public Wizard(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += vX;
		y += vY;
		
		if (handler.isUp()) vY = -1f;
		else if (!handler.isDown()) vY = 0;
		
		if (handler.isDown()) vY = 1f;
		else if (!handler.isUp()) vY = 0;
		
		if (handler.isRight()) vX = 1f;
		else if (!handler.isLeft()) vX = 0;
		
		if (handler.isLeft()) vX = -1f;
		else if (!handler.isRight()) vX = 0;

	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
