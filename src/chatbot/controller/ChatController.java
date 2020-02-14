package chatbot.controller;

import chatbot.view.Popup;
import chatbot.view.ChatFrame;
import chatbot.model.Chatbot;

public class ChatController
{
	private Popup view;
	private Chatbot myBot;
	private ChatFrame frame;
	
	public ChatController()
	{
		myBot = new Chatbot("Silly Chat Bot");
		view = new Popup();
		frame = new ChatFrame(this);
	}
	
	public void start()
	{
		view.displayMessage("Welcome to the new chatbot!");
	}
	
	public String interactWithChatbot(String textInput)
	{
		String output = "";
		
		output = myBot.processText(textInput);
		
		return output;
	}
	
	

}
