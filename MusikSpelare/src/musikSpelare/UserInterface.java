package musikSpelare;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface extends JFrame implements ActionListener{
	private Label testLable;
	private TextField testTextField;
	private Button testButton;
	private Choice testChoise;

	public UserInterface(){
		JFrame frame = new JFrame();
		frame.setTitle("Musik Spelare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setResizable(false);
		frame.setVisible(true);

		Container c = frame.getContentPane();
		c.setBackground(Color.gray);

		JPanel panel = new JPanel(new GridLayout(0, 2)); //2 kolumner och hur många rader som behövs
	}
}
