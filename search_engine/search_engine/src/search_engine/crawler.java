package search_engine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;



public class crawler {
	
	
	

	
	
	static String finder(String s) 
	{
		String ss=s;
	try {
		
		 Document doc = Jsoup.connect(s).get();
		// s=doc.html();
		 Elements linksOnPage = doc.select("a[href]");
		 for (Element page : linksOnPage) {
			 
					 	ss=ss+ " "+page.attr("abs:href");
				 }
		
        
		}
		catch(Exception e)
		{
			
			
		}
		return ss;

	}

	static void htmlToText(String[] s)
	{
		try {
		String ss;
		for(int i=0;i<100;i++)
		{
		 Document doc = Jsoup.connect(s[i]).get();
		 ss=doc.text();
		 System.out.println(s[i]);
		 BufferedWriter out = new BufferedWriter( 
                 new FileWriter(i+".txt", true)); 
          out.write(s[i]+" "+ss); 
          out.close(); 
		
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

		 public static void main(String [] s)
	 {
		 
		 String ss=finder("http://www.uwindsor.ca/");
		 String asd=ss;
		 String qw="http://www.uwindsor.ca/";
		 //System.out.println(ss);
		 int i=1;
		 
		 
			 String[] w=ss.split(" ");
			 for(int ee=0;ee<20;ee++)
			 {
				 
				
				 if(!qw.contains(w[ee]))
				 {	
					System.out.println(i);
					i++;
					 qw=qw+" "+w[ee];
					 ss=ss+" "+finder(w[ee]);
				 }
			 }
		 String[] sa=ss.split(" ");
		 String[] ret=new String[100];
		 for(int p=0;p<100;p++) {
			ret[p]=sa[p];
		 }
		 htmlToText(ret);
		 
	 }

}
