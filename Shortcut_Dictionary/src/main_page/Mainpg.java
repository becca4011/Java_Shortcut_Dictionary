package main_page;

import javax.swing.*;
import java.awt.*;

public class Mainpg extends JFrame
{
	public Mainpg()
	{
		setTitle("Shortcut Dictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 500));
		
		c.add(new JButton("����Ű ����"));
		c.add(new JButton("����Ű ã��"));
		
		setSize(1100, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Mainpg();
	}
}
