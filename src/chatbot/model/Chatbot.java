package chatbot.model;

import java.util.*;

public class Chatbot
{
	// Data Member Section
	// Declaration Section
	
	private String userName;
	
	private String chatbotName;
	
	private String [] questionsArray;
	
	private boolean [] questionsAnswered;
	
	private ArrayList<String> userResponseList;
	
	private ArrayList<String> chatReplyList;
	
	// Declaration Section
	// Data Member Section
	
	public Chatbot(String chatbotName)
	{
		this.chatbotName = chatbotName;
		this.questionsAnswered = new boolean [10];
		this.questionsArray = new String [10];
		this.userResponseList = new ArrayList<String>();
		this.chatReplyList = new ArrayList<String>();
		this.userName = "";
		setupQuestions();
	}
	
	
	private void setupQuestions()
	{
		this.questionsArray[0] = "What is your name?";
		this.questionsArray[1] = "What isn't your name?";
		this.questionsArray[2] = "Is that your name?";
		this.questionsArray[3] = "Why is that your name?";
		this.questionsArray[4] = "How is that your name?";
		this.questionsArray[5] = "How is your name?";
		this.questionsArray[6] = "Where is your name?";
		this.questionsArray[7] = "Where isn't your name?";
		this.questionsArray[8] = "When is your name?";
		this.questionsArray[9] = "When isn't your name?";
	}
	
	public String processText(String text)
	{
		userResponseList.add(text);
		if (!exitChecker(text))
		{
			String response = "You said: " + text;
		
			int randomQuestionIndex = (int) (Math.random() * questionsArray.length);
			
			if (checkQuestions())
			{
				questionsAnswered = new boolean[questionsAnswered.length];
			}
			
			while (questionsAnswered[randomQuestionIndex])
			{
				randomQuestionIndex = (int) (Math.random() * questionsArray.length);
			}
			
			
			response += "\n" + questionsArray[randomQuestionIndex] + "\n";
			
			questionsAnswered[randomQuestionIndex] = true;
		
			return response;
		}
		
		return "Goodbye!";
	}
	
	private boolean checkQuestions()
	{
		boolean answeredAll = false;
		
		for (boolean answered : questionsAnswered)
		{
			if (answered && answeredAll)
			{
				return true;
			}
		}
		return answeredAll;
	}

	private boolean exitChecker(String words)
	{
		boolean isValid = false;
		
		if (words.equalsIgnoreCase("quit"))
		{
			isValid = true;
		} 
		
		return isValid;
	}
	
	private boolean checkTooMuchOrder(String userInput)
	{
		boolean isOrdered = true;
		String orderedString = "1234567890qwertyuiopasdfghjklzxcvbnmabcdefghijklmnopqrstuvwxyz";
		
		for (int index = 0; index < orderedString.length() - 3; index++)
		{
			String match = orderedString.substring(index, index + 3);
			
			if (userInput.indexOf(match) > -1)
			{
				return false;
			}
		}
		
		for (int index = orderedString.length() - 1; index >= 2; index--)
		{
			String match = orderedString.substring(index - 2, index + 1);
			
			if (userInput.contains(match))
			{
				return false;
			}
		}
		
		return isOrdered;
	}
}
