package main_page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Shortcut_Dictionary extends JFrame
{
	static List<String> sc = new ArrayList<String>();
	JLabel shortcut_lb = new JLabel();
	JLabel page_lb = new JLabel();
	private int cnt = 0;
	
	public Shortcut_Dictionary()
	{
		try
		{
			File read = new File("shortcut/shortcut.txt");
			FileReader fr = new FileReader(read);
			BufferedReader br = new BufferedReader(fr);
			
			String s;
			// ���Ͽ��� �� �پ� �о�� list�� ����
			while((s = br.readLine()) != null)
			{
				sc.add(s);
			}
			
			if(fr != null) fr.close();
			if(br != null) br.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		setTitle("Shortcut Dictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(null);
		
		shortcut_lb = new JLabel(sc.get(0));
		shortcut_lb.setSize(300, 30);
		shortcut_lb.setFont(new Font("Calibri", Font.PLAIN, 30));
		shortcut_lb.setLocation(10, 70);
		c.add(shortcut_lb);
		
		page_lb = new JLabel(Integer.toString(cnt + 1));
		page_lb.setSize(50, 30);
		page_lb.setFont(new Font("Calibri", Font.PLAIN, 30));
		page_lb.setLocation(10, 30);
		c.add(page_lb);
		
		JButton prev_btn = new JButton("< Prev");
		prev_btn.setSize(200, 40);
		prev_btn.setFont(new Font("Calibri", Font.PLAIN, 30));
		prev_btn.setLocation(150, 450);
		prev_btn.addActionListener(new PrevBtnAction());
		c.add(prev_btn);
		
		JButton next_btn = new JButton("Next >");
		next_btn.setSize(200, 40);
		next_btn.setFont(new Font("Calibri", Font.PLAIN, 30));
		next_btn.setLocation(750, 450);
		next_btn.addActionListener(new NextBtnAction());
		c.add(next_btn);
		
		setSize(1100, 700);
		setResizable(false);
		setVisible(true);
	}
	
	private class PrevBtnAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();
			
			if (cnt == 0)
				cnt = sc.size(); // cnt�� 0�� ��, ����Ʈ�� ũ�⸦ cnt�� ��
			
			shortcut_lb.setText(sc.get(--cnt)); // index�� cnt-1�� ����Ű�� ����
			page_lb.setText(Integer.toString(cnt + 1));
		}
	}
	
	private class NextBtnAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();
			
			if (++cnt == sc.size()) // cnt 1 ����
				cnt = 0; // cnt�� 1�� ������Ų ���� ����Ʈ�� ũ��� ���� ��� cnt�� 0���� ��
			
			shortcut_lb.setText(sc.get(cnt)); // index�� cnt�� ����Ű�� ����
			page_lb.setText(Integer.toString(cnt + 1));
		}
	}
	
	public static void main(String[] args) 
	{
		
	}
}
