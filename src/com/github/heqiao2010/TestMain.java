package com.github.heqiao2010;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMain {
	static GeofencingDialog dialog = null;
	
	public static void main(String args[]){
		JFrame frame = new JFrame();  
        JPanel panel = new JPanel(); 
        JButton button = new JButton("地圖");
        button.setSize(200, 30);
        button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(null == dialog){
					dialog = new GeofencingDialog();
				}
				dialog.setVisible(true);
				dialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.out.println("半径：" + dialog.getRadiusStr());
						System.out.println("经纬度：" + dialog.getLocationStr());
					}
				});

			}
        });
        panel.setLayout(new GridLayout()); 
        panel.add(button);
        frame.setTitle("地圖測試");
        frame.add(panel);  
        frame.setSize(200,200);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
