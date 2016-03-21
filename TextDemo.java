import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TextDemo
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
    int casenum = 0;

	public TextDemo()
	{

    //JFrame frame = new JFrame("Temperature Converter");
		panel = new JPanel();
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");

		//Load the listener
		button.addActionListener(buttonListener());
     //menu
     JMenuBar menuBar; //The entire bar
 		JMenu menu, submenu; //A single drop-down menu
 		JMenuItem menuItem; //A single item in a menu

 		//Create the menu bar.
 		menuBar = new JMenuBar();

 		//Build the first menu.
 		menu = new JMenu("Conversion options");
 		menu.setMnemonic(KeyEvent.VK_A); //Allows for hotkey access, Alt+a
 		menuBar.add(menu); //Add to menu bar
 	//	String[] options = {"F to C","F to K","C to K","C to F","K to F","K to C"};
    JMenuItem item1 = new JMenuItem("F to C"); menu.add(item1);
    JMenuItem item2 = new JMenuItem("F to K"); menu.add(item2);
    JMenuItem item3 = new JMenuItem("C to K"); menu.add(item3);
    JMenuItem item4 = new JMenuItem("C to F"); menu.add(item4);
    JMenuItem item5 = new JMenuItem("K to F"); menu.add(item5);
    JMenuItem item6 = new JMenuItem("K to C"); menu.add(item6);



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
item5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       casenum =5;
    }
});
item6.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       casenum =6;
    }
});



		//load the panel
    panel.add(menuBar);
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
      //  String input = text.getText();
        double temp =0;
        String newText = "";
          try {
            temp = Double.parseDouble(text.getText());


            switch(casenum){
              case 1: //F to C
                      double tempInC = (temp-32)*(5.0/9.0); //convert F to C
              				newText = "Temp in C: " + String.format("%.2f",tempInC);
                      break;
              case 2: //F to K
                      double tempinK = (temp + 459.67)*5/9;
                      newText = "Temp in K: " + String.format("%.2f",tempinK);
                     break;
              case 3://C to K
                    double tempinK2 = temp + 273.15;
                    newText = "Temp in K: " + String.format("%.2f",tempinK2);
                    break;
              case 4: //C to F
                    double tempinF = temp*9/5+32;
                    newText = "Temp in F: " + String.format("%.2f",tempinF);
                     break;
              case 5: //K to F
                      double tempinF2 = temp - 273.15;
                      newText = "Temp in K: " + String.format("%.2f",tempinF2);
                    break;
              case 6: //K to C
                    double tempinC2 = temp*9/5-459.67;
                    newText = "Temp in F: " + String.format("%.2f",tempinC2);
                    break;



            }
            label.setText(newText);
            System.out.println(newText);

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
