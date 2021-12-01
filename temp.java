import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class temp extends JFrame implements ActionListener
{
	JLabel lbl_FROM = new JLabel("ENTER INPUT VALUE : ");
	JLabel lbl_TO= new JLabel("THE CONVERTED VALUE IS : ");

	JTextField tf_F = new JTextField(15);
	JTextField tf_T = new JTextField(15);

	JButton B_fc = new JButton("Fahrenheit To Celsius");
	JButton B_cf = new JButton("Celsius To Fahrenheit ");
	JButton B_clr =  new JButton("CLEAR");
	JButton B_bck = new JButton("Back");

	JPanel NP = new JPanel();
	JPanel CP = new JPanel();
	JPanel SP = new JPanel();

	temp()
	{
		setSize(500,500);
		setTitle("TEMPRATURE CONVERTER");
		setVisible(true);
		setBackground(Color.RED);

		NP.add(lbl_FROM);
		NP.add(tf_F);


		CP.add(lbl_TO);
		CP.add(tf_T,"Center");

		SP.add(B_fc);
		SP.add(B_cf);
		SP.add(B_clr);
		SP.add(B_bck);

		add(NP,"North");
		add(CP,"Center");
		add(SP,"South");
		tf_T.setEditable(false);

		B_fc.addActionListener(this);
		B_cf.addActionListener(this);
		B_clr.addActionListener(this);
		B_bck.addActionListener(this);

		B_cf.addMouseListener(new adpt());
		B_fc.addMouseListener(new adpt());
		B_clr.addMouseListener(new adpt());
		B_bck.addMouseListener(new adpt());
	}

			class adpt extends MouseAdapter implements MouseListener
			{
					public void mouseEntered(MouseEvent me)
					{

						 if(me.getSource()==B_cf)
						 {
							 B_cf.setBackground(new Color(0xffcc324));
						 }
						 else if(me.getSource()==B_fc)
						{
							B_fc.setBackground(new Color(0xffcc324));
						}
						else if(me.getSource()==B_clr)
						{
							B_clr.setBackground(new Color(0xffcc324));
						}
						else if(me.getSource()==B_bck)
						{
							B_bck.setBackground(new Color(0xffcc324));
						}
					}
					public void mouseExited(MouseEvent me)
					{
						B_fc.setBackground(null);
						B_cf.setBackground(null);
						B_clr.setBackground(null);
						B_bck.setBackground(null);
					}
			}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==B_fc)
			{
				int x=Integer.parseInt(tf_F.getText());
				int r=((x-32)*5);
				r=r/9;
				tf_T.setText(""+r);
			}
		else
			if(e.getSource()==B_cf)
			{
				Double x=Double.parseDouble(tf_F.getText());
				Double r=(x*9/5)+32;
				tf_T.setText(""+r);
			}
		else
			if(e.getSource()==B_clr)
			{
				tf_F.setText("");
				tf_T.setText("");
			}
		else if(e.getSource()==B_bck)
		{
			new mainCode();
			setVisible(false);
		}
	}

	public static void main(String args[])
	{
		temp t = new temp();
		t.setVisible(true);
	}
}

