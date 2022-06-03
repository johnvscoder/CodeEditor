package com.codeeditor.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

public class MainWindow extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu;
	private JMenuItem fileMenuExit, fileMenuNew, fileMenuOpen,
	fileMenuSave, fileMenuSaveAs;
	private JMenuItem editMenuUndo, editMenuRedo, editMenuCut, editMenuCopy, editMenuPaste,
	editMenuFind, editMenuFindReplace;
	private JScrollPane workAreaScroll;
	private JTextPane workArea;
	
	public MainWindow() {
		setTitle("Code Editor");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initGUI();
		initListener();
		
		setVisible(true);
	}
	
	private void initGUI() {
		menuBar = new JMenuBar();
		
		//File menu
		fileMenu = new JMenu("File");
		
		fileMenuNew  = new JMenuItem("New");
		fileMenu.add(fileMenuNew);
		
		fileMenuOpen = new JMenuItem("Open");
		fileMenu.add(fileMenuOpen);
		
		fileMenuSave = new JMenuItem("Save");
		fileMenu.add(fileMenuSave);
		
		fileMenuSaveAs = new JMenuItem("Save as");
		fileMenu.add(fileMenuSaveAs);
		
		fileMenuExit = new JMenuItem("Exit");
		fileMenu.add(fileMenuExit);
		
		menuBar.add(fileMenu);
		//End of file menu
		
		//Edit menu
		editMenu = new JMenu("Edit");
		
		editMenuUndo = new JMenuItem("Undo");
		editMenu.add(editMenuUndo);
		
		editMenuRedo = new JMenuItem("Redo");
		editMenu.add(editMenuRedo);
		
		editMenu.add(new JSeparator());
		
		editMenuCut = new JMenuItem("Cut");
		editMenu.add(editMenuCut);
		
		editMenuCopy = new JMenuItem("Copy");
		editMenu.add(editMenuCopy);
		
		editMenuPaste = new JMenuItem("Paste");
		editMenu.add(editMenuPaste);
		
		editMenu.add(new JSeparator());
		
		editMenuFind = new JMenuItem("Find");
		editMenu.add(editMenuFind);
		
		editMenuFindReplace = new JMenuItem("Find/replace");
		editMenu.add(editMenuFindReplace);
		
		menuBar.add(editMenu);
		//End of edit menu
		
		setJMenuBar(menuBar);
		
		//Work area
		workArea = new JTextPane();
		workAreaScroll = new JScrollPane(workArea);
		
		add(workAreaScroll);
	}
	
	private void initListener() {
		fileMenuSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int response = fileChooser.showSaveDialog(MainWindow.this);
				if(response == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try(FileWriter fileWriter = new FileWriter(file)) {
						String workAreaContent = workArea.getText();
						fileWriter.write(workAreaContent);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	

}
