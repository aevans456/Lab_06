import javax.swing.JFrame;


public class VoteDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting System");
		Vote demo = new Vote();



		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
