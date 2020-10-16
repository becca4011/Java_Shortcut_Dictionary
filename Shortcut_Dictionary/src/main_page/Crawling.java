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
		
		Elements elem = doc.select("dl");
		for(Element el : elem.select("dd")) // dd를 넣으면 단축키, dt를 넣으면 단축키 기능
		{
			System.out.println(el.text());
		}
	}
}
