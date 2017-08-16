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
	
	public void KeyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			
			if (tempObj.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) handler.setUp(true);
				if (key == KeyEvent.VK_S) handler.setDown(true);
				if (key == KeyEvent.VK_A) handler.setLeft(true);
				if (key == KeyEvent.VK_D) handler.setRight(true);
			}
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			
			if (tempObj.getId() == ID.Player) {
				if (key == KeyEvent.VK_W) handler.setUp(false);
				if (key == KeyEvent.VK_S) handler.setDown(false);
				if (key == KeyEvent.VK_A) handler.setLeft(false);
				if (key == KeyEvent.VK_D) handler.setRight(false);
			}
		}
	}

}
