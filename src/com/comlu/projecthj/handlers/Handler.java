package com.comlu.projecthj.handlers;

import java.awt.Graphics;
import java.util.LinkedList;

import com.comlu.projecthj.game.GameObject;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private boolean up = false, down = false, right = false, left = false;
		
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObj = object.get(i);

			tempObj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObj = object.get(i);
			
			tempObj.render(g);
		}
	}
	
	public void addObject(GameObject tempObj) {
		object.add(tempObj);
		System.out.println("Adding Objects : " + object.size());
	}
	
	public void remObject(GameObject tempObj) {
		object.remove(tempObj);
		System.out.println("Removing Objects : " + object.size());
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
}
