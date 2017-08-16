package com.comlu.projecthj.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.comlu.projecthj.handlers.Handler;

public class KeyInput extends KeyAdapter {
	
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void KeyPressed(KeyEvent e) {
		
	}
	
	public void KeyReleased(KeyEvent e) {
		
	}

}
