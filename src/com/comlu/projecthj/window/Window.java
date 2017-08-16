package com.comlu.projecthj.window;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.comlu.projecthj.Game;

@SuppressWarnings("unused")
public class Window {
	public Window(int width, int height, String title, Game game) { 
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
	}
}
