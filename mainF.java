import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainF extends JFrame implements ActionListener
{
	JButton B_DB = new JButton("---Decimal_Binary--");
	JButton B_DO = new JButton("---Decimal_Octal--");
	JButton B_DH = new JButton("---Decimal_HexaDecimal--");
	JButton B_Bck = new JButton("---Back---");

	JLabel lbl = new JLabel("SELECT AN OPTION!");

	mainF()
	{
		setSize(500,500);
		setTitle("--MY CONVERTER FRAME--");
		setLayout(null);
		setVisible(true);

		Font f = new Font("Couirer",Font.BOLD,20);
		lbl.setFont(f);
		lbl.setForeground(new Color(0x00004d));

		lbl.setBounds(150,10,300,90);

		B_DB.setBounds (30,100,200,50);
		B_DO.setBounds (275,100,200,50);
		B_DH.setBounds (30,250,200,50);
		B_Bck.setBounds(275,250,200,50);

		add(lbl);
		add(B_DB);
		add(B_DO);
		add(B_DH);
		add(B_Bck);


		B_DB.addActionListener(this);
		B_DO.addActionListener(this);
		B_DH.addActionListener(this);
		B_Bck.addActionListener(this);

		B_DB.addMouseListener(new adpt());
		B_DO.addMouseListener(new adpt());
		B_DH.addMouseListener(new adpt());
		B_Bck.addMouseListener(new adpt());
	}

	class adpt extends MouseAdapter implements MouseListener
	{
			public void mouseEntered(MouseEvent me)
			{
				if(me.getSource()==B_DB)
				{
					B_DB.setBackground(new Color(0xffcc324));
				}
				else if(me.getSource()==B_DO)
				{
					B_DO.setBackground(new Color(0xffcc324));
				}
				else if(me.getSource()==B_DH)
				{
					B_DH.setBackground(new Color(0xffcc324));
				}
				else if(me.getSource()==B_Bck)
				{
					B_Bck.setBackground(new Color(0xffcc324));
				}
			}
			public void mouseExited(MouseEvent me)
			{
				B_DB.setBackground(null);
				B_DO.setBackground(null);
				B_DH.setBackground(null);
				B_Bck.setBackground(null);
			}
	}
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource()==B_DB)
			{
				new Dec_Bin();
				setVisible(false);
			}
		else
			if(ae.getSource()==B_DH)
			{
				new Dec_Hex();
				setVisible(false);
			}
		else

			if(ae.getSource()==B_DO)
			{
				new Dec_Oct();
				setVisible(false);
			}
		else
			if(ae.getSource()==B_Bck)
			{
				new mainCode();
				setVisible(false);
			}
	}
	public static void main(String args[])
	{
		mainF mf = new mainF();
		mf.setVisible(true);
	}
}

