package chatbot.model;

import java.util.*;

public class Chatbot
{
	// Data Member Section
	// Declaration Section
	
	private String userName;
	
	private String chatbotName;
	
	private String [] questionsArray;
	
	private ArrayList<String> userResponseList;
	
	private ArrayList<String> chatReplyList;
	
	// Declaration Section
	// Data Member Section
	
	public Chatbot(String chatbotName)
	{
		this.chatbotName = chatbotName;
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
		String response = "You said: " + text;
		
		return response;
	}

}
