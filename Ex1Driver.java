import javax.swing.JFrame;


public class Ex1Driver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Dicer Roller");
		Ex1 demo = new Ex1();

		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
