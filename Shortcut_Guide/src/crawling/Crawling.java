package crawling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling 
{
	public static void main(String[] args) 
	{
		try 
		{
			// ũ�Ѹ�
			String URL = "http://visualstudioshortcuts.com/2013/";
			Document doc = null;
			
			// ���������
			FileOutputStream fos = new FileOutputStream(new File("shortcut/shortcut.txt"));
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			try 
			{
				doc = Jsoup.connect(URL).get();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Elements elem = doc.select("dl");
			for(Element el : elem.select("dd")) // dd�� ������ ����Ű, dt�� ������ ����Ű ���
			{
				bw.write(el.text()); // shortcut.txt ���Ͽ� ũ�Ѹ��� ����Ű�� ����
				bw.newLine();
			}
			
			bw.close();
			osw.close();
			fos.close();
		} 
		catch (Exception e) 
		{
			e.getStackTrace();
		}
	}
}
