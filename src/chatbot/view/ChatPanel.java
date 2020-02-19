package chatbot.view;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import chatbot.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController app;
	
	private SpringLayout appLayout;
	private JButton chatButton;
	private JTextField chatField;
	private JScrollPane chatPane;
	private JTextArea chatArea;
	
	public ChatPanel(ChatController app)
	{
		super();
		this.app = app;
		this.appLayout = new SpringLayout();
		this.chatButton = new JButton("Click to chat");
		this.chatField = new JTextField("", 50);
		this.chatPane = new JScrollPane();
		this.chatArea = new JTextArea(20, 50);
		setupChatArea();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatArea()
	{
		chatPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatArea.setWrapStyleWord(true);
		chatPane.setViewportView(chatArea);
		chatArea.setEnabled(false);
		chatArea.setLineWrap(true);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.GREEN);
		this.add(chatPane);
		this.add(chatField);
		this.add(chatButton);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 494, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 449, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatField, -6, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatField, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatPane, -8, SpringLayout.NORTH, chatField);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				updateScreen();
			} 
		});
		
		chatField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent enterPress)
			{
				updateScreen();
			}
		});		
	}
	
	private void updateScreen()
	{
		String userText = chatField.getText();
		chatField.setText("");
		String result = app.interactWithChatbot(userText);
		chatArea.append(result);
		chatArea.setCaretPosition(chatArea.getSelectionEnd());
	}

}

