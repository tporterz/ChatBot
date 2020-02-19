package chatbot.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class IOController
{
	public static void saveTextWithResources(ChatController app, String path, String textToSave)
	{
		String filename = path;
		LocalDateTime date = LocalDateTime.now();
		
		filename += "/" + date.getMonth() + " " + date.getDayOfWeek() + " ";
		filename += date.getHour() + "-" + date.getMinute();
		filename += " chatbot save.txt";
		File saveFile = new File(filename);
		
		try(Scanner textScanner = new Scanner(textToSave); PrintWriter saveText = new PrintWriter(saveFile))
		{
			while(textScanner.hasNext()) 
			{
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
	}
	
	public static String loadFile(ChatController app, String path)
	{
		String contents = "";
		
		try
		{
			File saveFile = new File(path);
			Scanner fileScanner = new Scanner(saveFile);
			
			while (fileScanner.hasNext())
			{
				contents += fileScanner.nextLine() + "\n";
			}
			fileScanner.close();
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
		return contents;
	}

}
