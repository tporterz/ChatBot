package chatbot.controller;

import chatbot.view.Popup;
import chatbot.model.Chatbot;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ChatController
{
	private Popup view;
	private Chatbot myBot;
	
	public ChatController()
	{
		myBot = new Chatbot("Silly Chat Bot");
		view = new Popup();
	
	}
	
	public void start()
	{
		interactWithChatbot();
	}
	
	private void interactWithChatbot()
	{
		String response = view.askQuestion("Welcome to the Chatbot!");
		
		while (!response.equals("quit"))
		{
			response = myBot.processText(response);
			response = view.askQuestion(response);
		}
	}

}
