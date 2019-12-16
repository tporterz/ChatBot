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
		view = new Popup();
	
	}
	
	public void start()
	{
		System.out.println("Hello world!");
	}

}
