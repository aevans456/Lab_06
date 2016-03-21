import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

public class Ex1
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;

	public Ex1()
	{
		panel = new JPanel();
		button = new JButton("ROLL");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a dice number");

		//Load the listener
		button.addActionListener(buttonListener());

		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}

	public Component getContent()
	{
		return (panel);
	}

	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				int number = Integer.parseInt(input);
				Random rand = new Random();
        int randomnumber = rand.nextInt(number)+1;
				String newText = "Random number: " + randomnumber;//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
			}
		};

		return listener;
	}
}
