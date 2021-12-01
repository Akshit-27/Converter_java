import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Comp extends JFrame implements ActionListener
{
	JLabel lb_in = new JLabel("ENTER INPUT VALUE:");

	JLabel lb_TB = new JLabel("SIZE IN TB IS:");
	JLabel lb_GB = new JLabel("SIZE IN GB IS:");
	JLabel lb_MB = new JLabel("SIZE IN MB IS:");
	JLabel lb_KB = new JLabel("SIZE IN KB IS:");
	JLabel lb_B = new JLabel("SIZE IN B IS:");

	Choice jb = new Choice();

	JTextField tf_in = new JTextField(25);

	JTextField tf_TB = new JTextField(25);
	JTextField tf_GB = new JTextField(25);
	JTextField tf_MB = new JTextField(25);
	JTextField tf_KB = new JTextField(25);
	JTextField tf_B = new JTextField(25);

	JButton B_Con = new JButton("Convert");
	JButton B_Clr = new JButton("Clear");
	JButton B_Bck = new JButton("Back");

	JPanel NP = new JPanel();
	JPanel CP = new JPanel();
	JPanel SP = new JPanel();

	String str = new String();


	Comp()
	{
		setSize(600,500);
		setTitle("File Size Converter");
		setVisible(true);

		jb.addItem("Select");
		jb.addItem("TeraByte");
		jb.addItem("GigaByte");
		jb.addItem("MegaByte");
		jb.addItem("KiloByte");
		jb.addItem("Byte");

		NP.add(lb_in);
		NP.add(tf_in);
		NP.add(jb);

		CP.setLayout(new GridLayout(5,2));

		CP.add(lb_TB);
		CP.add(tf_TB);

		CP.add(lb_GB);
		CP.add(tf_GB);

		CP.add(lb_MB);
		CP.add(tf_MB);

		CP.add(lb_KB);
		CP.add(tf_KB);

		CP.add(lb_B);
		CP.add(tf_B);

		tf_TB.setEditable(false);
		tf_GB.setEditable(false);
		tf_MB.setEditable(false);
		tf_KB.setEditable(false);
		tf_B.setEditable(false);

		SP.add(B_Con);
		SP.add(B_Clr);
		SP.add(B_Bck);

		add(NP,"North");
		add(CP,"Center");
		add(SP,"South");

		B_Con.addActionListener(this);
		B_Clr.addActionListener(this);
		B_Bck.addActionListener(this);


		str=jb.getSelectedItem();

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
			//TERA_BYTES
			if(jb.getSelectedItem().equals("TeraByte"))
			{
				Double tb = Double.parseDouble(tf_in.getText());

				Double r_gb= tb*1024;
				Double r_mb= r_gb*1024;
				Double r_kb= r_mb*1024;
				Double r_b = r_kb*1024;

				tf_TB.setText(""+tb+"  TeraBytes");
				tf_GB.setText(""+r_gb+"  GigaBytes");
				tf_MB.setText(""+r_mb+"  MegaBytes");
				tf_KB.setText(""+r_kb+"  KiloBytes");
				tf_B.setText(""+r_b+"  Bytes");
			}
			//GIGA_BYTES

			else if(jb.getSelectedItem().equals("GigaByte"))
			{
				Double gb = Double.parseDouble(tf_in.getText());
				Double r_tb = gb/1024;
				Double r_gb =gb;
				Double r_mb =r_gb*1024;
				Double r_kb = r_mb*1024;
				Double r_b = r_kb*1024;

				tf_TB.setText(""+r_tb+"  TeraByte");
				tf_GB.setText(""+r_gb+"  GigaByte");
				tf_MB.setText(""+r_mb+"  MegaByte");
				tf_KB.setText(""+r_kb+"  KiloByte");
				tf_B.setText(""+r_b+"	Bytes");

			}

			//MEGA_BYTES

			else if(jb.getSelectedItem().equals("MegaByte"))
			{
				Double mb = Double.parseDouble(tf_in.getText());
				Double r_tb= mb/1000000;
				Double r_gb= mb/1000;
				Double r_mb= mb;
				Double r_kb= mb*1024;
				Double r_b = r_kb*1024;

				tf_TB.setText(""+r_tb+"  TeraByte");
				tf_GB.setText(""+r_gb+"  GigaByte");
				tf_MB.setText(""+r_mb+"  MegaByte");
				tf_KB.setText(""+r_kb+"  KiloByte");
				tf_B.setText(""+r_b+"	Bytes");
			}

			//KILO_BYTE

			else if(jb.getSelectedItem().equals("KiloByte"))
			{
				Double kb = Double.parseDouble(tf_in.getText());
				Double r_tb= kb/1e+9;
				Double r_gb= kb/1000000;
				Double r_mb= kb/1000;
				Double r_kb= kb;
				Double r_b = r_kb*1024;

				tf_TB.setText(""+r_tb+"  TeraByte");
				tf_GB.setText(""+r_gb+"  GigaByte");
				tf_MB.setText(""+r_mb+"  MegaByte");
				tf_KB.setText(""+r_kb+"  KiloByte");
				tf_B.setText(""+r_b+"	Bytes");
			}
			//BYTE

			else if(jb.getSelectedItem().equals("Byte"))
			{
				Double b = Double.parseDouble(tf_in.getText());
				Double r_tb= b/1e+12;
				Double r_gb= b/1e+9;
				Double r_mb= b/1e+6;
				Double r_kb= b/1000;
				Double r_b = b;

				tf_TB.setText(""+r_tb+"  TeraByte");
				tf_GB.setText(""+r_gb+"  GigaByte");
				tf_MB.setText(""+r_mb+"  MegaByte");
				tf_KB.setText(""+r_kb+"  KiloByte");
				tf_B.setText(""+r_b+"	Bytes");
			}

			else if(jb.getSelectedItem().equals("Select"))
			{
				tf_TB.setText("Please Select Input Type");
				tf_GB.setText("Please Select Input Type");
				tf_MB.setText("Please Select Input Type");
				tf_KB.setText("Please Select Input Type");
				tf_B.setText("Please Select Input Type");
			}
		}

		if(e.getSource()==B_Clr)
		{
			tf_in.setText("");
			tf_TB.setText("");
			tf_GB.setText("");
			tf_MB.setText("");
			tf_KB.setText("");
			tf_B.setText("");
		}
		else if(e.getSource()==B_Bck)
		{
			new mainCode();
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		Comp obj = new Comp();
	}
}