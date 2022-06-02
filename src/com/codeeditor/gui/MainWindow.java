package com.codeeditor.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem fileMenuExit;
	
	public MainWindow() {
		setTitle("Code Editor");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initGUI();
		
		setVisible(true);
	}
	
	public void initGUI() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenuExit = new JMenuItem("Exit");
		fileMenu.add(fileMenuExit);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

}
