import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.PrintWriter;
import java.io.File;

public class Vote
{
	private JPanel panel;
	private JButton button;
	private JTextField text1;
  private JTextField text2;
	private JLabel label;
    int casenum = 0;

	public Vote()
	{

		panel = new JPanel();
		button = new JButton("Vote!");
		text1 = new JTextField(3);//3 cols, not 20 chars
    text2 = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter your first and last name.");

		//Load the listener
		button.addActionListener(buttonListener());
     //menu
     JMenuBar menuBar; //The entire bar
 		JMenu menu, submenu; //A single drop-down menu
 		JMenuItem menuItem; //A single item in a menu

 		//Create the menu bar.
 		menuBar = new JMenuBar();

 		//Build the first menu.
 		menu = new JMenu("Candidates");
 		menu.setMnemonic(KeyEvent.VK_A); //Allows for hotkey access, Alt+a
 		menuBar.add(menu); //Add to menu bar
    JMenuItem item1 = new JMenuItem("Mr. Crabs"); menu.add(item1);
    JMenuItem item2 = new JMenuItem("Spongebob"); menu.add(item2);
    JMenuItem item3 = new JMenuItem("Squidward"); menu.add(item3);
    JMenuItem item4 = new JMenuItem("Patrick"); menu.add(item4);



    item1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           casenum =1;
        }
   });
   item2.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          casenum =2;
       }
  });
  item3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         casenum =3;
      }
 });
 item4.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        casenum =4;
     }
});




		//load the panel
    panel.add(label);
    panel.add(text1);
    panel.add(text2);
    panel.add(menuBar);
		panel.add(button);


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
      //  String input = text.getText();
        double temp =0;
        String newText = "";

          try {
            String firstname = text1.getText();
            String lastname = text2.getText();


            String filename = lastname + "_"+firstname+"_ballot.txt";

            File f = new File(filename);
            if(f.exists() && !f.isDirectory())
            {
              String message = "You have already voted";
              label.setText(message);
              System.out.println(message);

            }
            else{
            switch(casenum){
              case 1: //Mr. Crabs
                      try
                      {
                        PrintWriter writer = new PrintWriter(filename, "UTF-8");
                        writer.println("Mr. Crabs");
                        writer.close();
                      }
                      catch (Exception f1)
                      {
                          System.out.println("there was a problem ");
                      }

                      break;
              case 2: //Spongebob
                      try
                      {
                        PrintWriter writer = new PrintWriter(filename, "UTF-8");
                        writer.println("Spongebob");
                        writer.close();
                      }
                      catch (Exception f2)
                      {
                          System.out.println("there was a problem ");
                      }
                     break;
              case 3://Squidward
                    try
                    {
                      PrintWriter writer = new PrintWriter(filename, "UTF-8");
                      writer.println("Squidward");
                      writer.close();
                    }
                    catch (Exception f3)
                    {
                        System.out.println("there was a problem ");
                    }
                    break;
              case 4: //Patrick
                      try
                      {
                        PrintWriter writer = new PrintWriter(filename, "UTF-8");
                        writer.println("Patrick");
                        writer.close();
                      }
                      catch (Exception f4)
                      {
                          System.out.println("there was a problem ");
                      }
                     break;



            }
          }
          

          }
          catch (NumberFormatException c) {
          //error
            String errortext = "Error! Input is not a number.";
            label.setText(errortext);
    				System.out.println(errortext);
         }

			}

		};

		return listener;
	}
}
