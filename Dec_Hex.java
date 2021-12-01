import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dec_Hex extends JFrame implements ActionListener
{
	JLabel lbl_from = new JLabel("ENTER DECIMAL NUMBER ");
	JLabel lbl_to = new JLabel("CONVERTED HEX NUMBER IS: ");

	JTextField tf_f = new JTextField(25);
	JTextField tf_t = new JTextField(25);

	JButton B_Con = new JButton("Convert");
	JButton B_Clr = new JButton("Clear");
	JButton B_Bck = new JButton("Back");

	JPanel NP = new JPanel();
	JPanel CP = new JPanel();
	JPanel SP = new JPanel();


	Dec_Hex()
	{
		setSize(500,500);
		setTitle("DECIMAL TO HEXA_DECIMAL");
		setVisible(true);


		NP.add(lbl_from);
		NP.add(tf_f);

		CP.add(lbl_to);
		CP.add(tf_t);
		tf_t.setEditable(false);

		SP.add(B_Con,"South");
		SP.add(B_Clr,"South");
		SP.add(B_Bck,"South");

		add(NP,"North");
		add(CP,"Center");
		add(SP,"South");

		B_Con.addActionListener(this);
		B_Clr.addActionListener(this);
		B_Bck.addActionListener(this);

		B_Con.addMouseListener(new adpt());
		B_Clr.addMouseListener(new adpt());
		B_Bck.addMouseListener(new adpt());
	}
	class adpt extends MouseAdapter implements MouseListener
	{
		public void mouseEntered(MouseEvent me)
		{
			if(me.getSource()==B_Con)
			 {
				 B_Con.setBackground(new Color(0xffcc324));
			 }
			else if(me.getSource()==B_Clr)
			{
				B_Clr.setBackground(new Color(0xffcc324));
			}
			else if(me.getSource()==B_Bck)
			{
				B_Bck.setBackground(new Color(0xffcc324));
			}
		}
		public void mouseExited(MouseEvent me)
		{
			B_Con.setBackground(null);
			B_Clr.setBackground(null);
			B_Bck.setBackground(null);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==B_Con)
		{
			int num= Integer.parseInt(tf_f.getText());
			String str = Integer.toHexString(num);
			tf_t.setText(str);
		}

		else if (e.getSource()==B_Clr)
		{
			tf_t.setText("");
			tf_f.setText("");
		}
		else if(e.getSource()==B_Bck)
		{
			new mainF();
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		Dec_Hex dh = new Dec_Hex();

	}
}


