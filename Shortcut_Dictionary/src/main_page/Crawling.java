package main_page;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling 
{
	public static void main(String[] args)
	{
		String URL = "http://visualstudioshortcuts.com/2013/";
		Document doc = null;
		try 
		{
			doc = Jsoup.connect(URL).get();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Elements elem = doc.select("article > dl");
		for(Element el : elem.select("dt")) // dd�� ������ ����Ű, dt�� ������ ����Ű ���
		{
			System.out.println(el.text());
		}
	}
}
