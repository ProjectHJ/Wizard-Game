package com.comlu.projecthj.handlers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.comlu.projecthj.game.GameObject;
import com.comlu.projecthj.id.ID;

public class KeyInput extends KeyAdapter {

	Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(true);
					// System.out.println("isUp: " + handler.isUp());
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(true);
					// System.out.println("isDown: " + handler.isDown());
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(true);
					// System.out.println("isLeft: " + handler.isLeft());
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(true);
					// System.out.println("isRight: " + handler.isRight());
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);

			if (tempObj.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(false);
					// System.out.println("isUp: " + handler.isUp());
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(false);
					// System.out.println("isDown: " + handler.isDown());
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(false);
					// System.out.println("isLeft: " + handler.isLeft());
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(false);
					// System.out.println("isRight: " + handler.isRight());
				}
			}
		}
	}

}
