package com.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagValidationRegex{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        String regexPatern = "(<[^>]*>)";
       Pattern stringPatern  = Pattern.compile(regexPatern);
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
              int pos = 0;
              Matcher m = stringPatern.matcher(line);
              String previousHTMLTag = null;
              int previousTagPos = -1;
              boolean didFind = false;
              while(m.find())
              {    
                  String htmlTag = line.substring(m.start(),m.end());
                  if(htmlTag.charAt(1) != '/')
                  {
                    previousHTMLTag = htmlTag;
                       previousTagPos = m.end();
                  }else if(htmlTag.charAt(1) == '/' && previousHTMLTag != null){
                      if(previousHTMLTag.substring(1).equals(htmlTag.substring(2))&&previousHTMLTag.length()>2 && m.start()>previousTagPos+1){
                        System.out.println(line.substring(previousTagPos,m.start()));
                          didFind = true;
                      }
                    previousHTMLTag = null;
                  }
                  
              }
              System.out.print(didFind?"":"None\n");
			
			testCases--;
		}
	}
}




