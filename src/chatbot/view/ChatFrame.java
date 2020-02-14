package chatbot.view;

import javax.swing.JFrame;
import chatbot.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController app;
	private ChatPanel panel;
	
	public ChatFrame(ChatController app)
	{
		super();
		this.app = app;
		this.panel = new ChatPanel(this.app);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Chatbot");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}





