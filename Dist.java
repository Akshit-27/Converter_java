import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dist extends JFrame implements ActionListener
{
	JLabel lbl_in = new JLabel("Enter Input Value:");
	JLabel lbl_KM = new JLabel("Distance in KiloMeters :");
	JLabel lbl_MT = new JLabel("Distance in Meters :");
	JLabel lbl_CM = new JLabel("Distance in CentiMeters :");
	JLabel lbl_MM = new JLabel("Distance in MiliMeters :");

	JTextField tf_in = new JTextField(15);
	JTextField tf_KM = new JTextField(15);
	JTextField tf_MT = new JTextField(15);
	JTextField tf_CM = new JTextField(15);
	JTextField tf_MM = new JTextField(15);

	JButton B_Con = new JButton("Convert");
	JButton B_Clr = new JButton("CLEAR");
	JButton B_Bck = new JButton("Back");

	JPanel NP = new JPanel();
	JPanel CP = new JPanel();
	JPanel SP = new JPanel();

	String s;

	Choice c = new Choice();

	Dist()
	{
		setSize(500,500);
		setTitle("DISTANCE CONVERTER");
		setBackground(Color.CYAN);
		setVisible(true);

		c.add("Select");
		c.add("KiloMeters");
		c.add("Meters");
		c.add("CentiMeters");
		c.add("MiliMeters");

		NP.add(lbl_in);
		NP.add(tf_in);
		NP.add(c);

		CP.setLayout(new GridLayout(5,2));

		CP.add(lbl_KM);
		CP.add(tf_KM);

		CP.add(lbl_MT);
		CP.add(tf_MT);

		CP.add(lbl_CM);
		CP.add(tf_CM);

		CP.add(lbl_MM);
		CP.add(tf_MM);

		SP.add(B_Con);
		SP.add(B_Clr);
		SP.add(B_Bck);

		add(NP,"North");
		add(CP,"Center");
		add(SP,"South");

		tf_KM.setEditable(false);
		tf_MT.setEditable(false);
		tf_CM.setEditable(false);
		tf_MM.setEditable(false);

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
			//KILO_METERS
			if(c.getSelectedItem().equals("KiloMeters"))
			{
				Double km = Double.parseDouble(tf_in.getText());
				//Double r_km= km*1000;
				Double r_mt= km*1000;
				Double r_cm= km*100000;
				Double r_mm= km*10000000;
				tf_KM.setText(""+km+"  KiloMeters");
				tf_MT.setText(""+r_mt+"  Meters");
				tf_CM.setText(""+r_cm+"  CentiMeters");
				tf_MM.setText(""+r_mm+"  MiliMeters");
			}
			//METERS
			else if(c.getSelectedItem().equals("Meters"))
			{
				Double m = Double.parseDouble(tf_in.getText());
				Double r_km= m/1000;
				//Double r_mt= m*1000;
				Double r_cm= m*100;
				Double r_mm= m*1000;
				tf_KM.setText(""+r_km+"  KiloMeters");
				tf_MT.setText(""+m+"  Meters");
				tf_CM.setText(""+r_cm+"  CentiMeters");
				tf_MM.setText(""+r_mm+"  MiliMeters");
			}
			//CENTI_METERS
			else if(c.getSelectedItem().equals("CentiMeters"))
			{
				Double cm = Double.parseDouble(tf_in.getText());
				Double r_km= cm/100000;
				Double r_mt= cm/100;
				//Double r_cm= km*100000;
				Double r_mm= cm*10;
				tf_KM.setText(""+r_km+"  KiloMeters");
				tf_MT.setText(""+r_mt+"  Meters");
				tf_CM.setText(""+cm+"  CentiMeters");
				tf_MM.setText(""+r_mm+"  MiliMeters");
			}
			//MILI_METER
			else if(c.getSelectedItem().equals("MiliMeters"))
			{
				Double mm = Double.parseDouble(tf_in.getText());
				Double r_km= mm/1000000;
				Double r_mt= mm/1000;
				Double r_cm= mm/10;
				//Double r_mm= mm*10;
				tf_KM.setText(""+r_km+"  KiloMeters");
				tf_MT.setText(""+r_mt+"  Meters");
				tf_CM.setText(""+r_cm+"  CentiMeters");
				tf_MM.setText(""+mm+"  MiliMeters");
			}
			else if(c.getSelectedItem().equals("Select"))
			{
				tf_KM.setText("Please Select Input Type");
				tf_MT.setText("Please Select Input Type");
				tf_CM.setText("Please Select Input Type");
				tf_MM.setText("Please Select Input Type");
			}
		}
		else if(e.getSource()==B_Clr)
		{
			tf_in.setText("");
			c.select("Select");
			tf_KM.setText("");
			tf_MT.setText("");
			tf_CM.setText("");
			tf_MM.setText("");
		}
		else if(e.getSource()==B_Bck)
		{
			new mainCode();
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		Dist d = new Dist();
		d.setVisible(true);
	}
}