package com.biz.grade.exec;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PrintWriterEx_01 {
	
	public static void main(String[] args) {
		
		String fileName ="src/com/biz/grade/exec/date/test.txt";
		FileWriter fileWriter =null;
		
		PrintWriter pWriter =null;
		
		
			try {
				fileWriter=new FileWriter(fileName,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pWriter =new PrintWriter(fileWriter);
				
				Date date=new Date();
				
				pWriter.println("대한민국만세"+date.toString());
				pWriter.close();
				
			}
			
		
	}

}
