package edu.buffalo.cse.irf14.index;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDictionary extends Thread
{
	ArrayList<String> documentDictionary=null;
	File file_docDictionary=null;
	
	public WriteDictionary(ArrayList<String> docDictionary,File file_docDictionary)
	{
		this.documentDictionary = docDictionary;
		this.file_docDictionary=file_docDictionary;
	}
	
	public void run()
	{
		
		StringBuilder docDictionaryData=new StringBuilder();
		try 
		{
			BufferedWriter docDictonaryWriter=new BufferedWriter(new FileWriter(file_docDictionary));
			int index=0;
			for(;index<documentDictionary.size()-1;index++)
			{
				docDictionaryData.append(documentDictionary.get(index)); 
				docDictionaryData.append(Delimiters.delimDictionary);
				docDictionaryData.append(index+1);
				docDictionaryData.append("\n");
			}
			docDictionaryData.append(documentDictionary.get(index));
			docDictionaryData.append(Delimiters.delimDictionary );
			docDictionaryData.append(index+1);
			
			docDictonaryWriter.write(docDictionaryData.toString());
			docDictonaryWriter.flush();
			docDictonaryWriter.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
