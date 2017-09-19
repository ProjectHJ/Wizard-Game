package com.comlu.projecthj.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.illnation.parser.DOMParser;

public class Enemy extends GameObject {

	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int maxHP = 100;
	int hp = maxHP;
	int arg01 = 1;

	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += vX;
		y += vY;

		choose = r.nextInt(10);

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Wall || tempObj.getId() == ID.Wall_Connected_Right
					|| tempObj.getId() == ID.Wall_Connected_Up) {
				if (getBoundsBig().intersects(tempObj.getBounds())) {
					x += (vX * 2) * -1;
					y += (vY * 2) * -1;
					vX *= -1;
					vY *= -1;
				} else if (choose == 0) {
					vX = r.nextInt(arg01 - -arg01) + -arg01;
					vY = r.nextInt(arg01 - -arg01) + -arg01;
				}
			}

			if (tempObj.getId() == ID.Bullet) {
				if (getBoundsBig().intersects(tempObj.getBounds())) {
					hp -= 50;
					handler.remObject(tempObj);
				}
			}
		}

		if (hp <= 0) {
			handler.remObject(this);
		}

	}

	public void render(Graphics g) {

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public Rectangle getBoundsBig() {
		return new Rectangle(x - 16, y - 16, 64, 64);
	}
}
