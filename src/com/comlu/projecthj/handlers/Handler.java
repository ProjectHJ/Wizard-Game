package com.comlu.projecthj.handlers;

import java.awt.Graphics;
import java.util.LinkedList;

import com.comlu.projecthj.game.GameObject;

public class Handler {
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
		
	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			GameObject tempObj = objects.get(i);

			tempObj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject tempObj = objects.get(i);
			
			tempObj.render(g);
		}
	}
	
	public void addObject(GameObject tempObj) {
		objects.add(tempObj);
		System.out.println("Adding Objects : " + objects.size());
	}
	
	public void remObject(GameObject tempObj) {
		objects.remove(tempObj);
		System.out.println("Removing Objects : " + objects.size());
	}
}
