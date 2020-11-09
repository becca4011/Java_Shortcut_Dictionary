package main_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mainpg extends JFrame
{
	public Mainpg()
	{
		setTitle("Shortcut Guide");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(null);
		
		JButton dict = new JButton("Dictionary");
		dict.setSize(200, 40);
		dict.setFont(new Font("Calibri", Font.PLAIN, 30));
		dict.setLocation(150, 450);
		dict.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Dictionary ��ư�� ������ Shortcut_Dictionary ���������� �Ѿ���� ��
				new Shortcut_Dictionary();
				setVisible(false);
			}
		});
		c.add(dict);
		
		JButton search = new JButton("Search");
		search.setSize(200, 40);
		search.setFont(new Font("Calibri", Font.PLAIN, 30));
		search.setLocation(700, 450);
		c.add(search);
		
		setSize(1100, 700);
		setResizable(false); // ũ�� ���� �Ұ����ϵ��� ��
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Mainpg();
	}
}
