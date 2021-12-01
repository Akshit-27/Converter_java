import java.awt.*;
import java.util.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

class mainCode extends JFrame implements ActionListener
{
	JButton Dist = new JButton("--Distance--");
	JButton Temp = new JButton("--Temprature--");
	JButton ComS = new JButton("--Computer_Size--");
	JButton Bin = new JButton("--Binay Convertor--");
	JButton Exit = new JButton("--Exit--");



	JLabel lbl = new JLabel("SELECT AN DESIRED OPTION!");



	mainCode()
	{
		setSize(500,500);
		setTitle("MAIN_FRAME");
		setVisible(true);
		setBackground(new Color(0xFFFFFF));

		setLayout(null);

		Font f = new Font("Couirer",Font.BOLD,20);
		lbl.setFont(f);
		lbl.setForeground(new Color(0x00004d));

		lbl.setBounds(105,10,300,90);

		Dist.setBounds (30,100,200,50);

		Temp.setBounds (275,100,200,50);

		ComS.setBounds (30,250,200,50);

		Bin.setBounds(275,250,200,50);

		Exit.setBounds(140,400,200,50);

		add(lbl);
		add(Dist);
		add(Temp);
		add(ComS);
		add(Bin);
		add(Exit);
		//add(p,BorderLayout.NORTH);


		Dist.addActionListener(this);
		Temp.addActionListener(this);
		ComS.addActionListener(this);
		Bin.addActionListener(this);
		Exit.addActionListener(this);


		Dist.addMouseListener(new adpt());
		Temp.addMouseListener(new adpt());
		ComS.addMouseListener(new adpt());
		Bin.addMouseListener(new adpt());
		Exit.addMouseListener(new adpt());
	}

			class adpt extends MouseAdapter implements MouseListener
			{
				public void mouseEntered(MouseEvent me)
				{
				 if(me.getSource()==Dist)
				 {
					 Dist.setBackground(new Color(0xffcc324));
				 }
				 else if(me.getSource()==Temp)
				{
					Temp.setBackground(new Color(0xffcc324));
				}
				else if(me.getSource()==ComS)
				{
					ComS.setBackground(new Color(0xffcc324));
				}
				else if(me.getSource()==Bin)
				{
					Bin.setBackground(new Color(0xffcc324));
				}
				else if (me.getSource()== Exit)
				{
					Exit.setBackground(new Color(0xffcc324));
				}
			}
			public void mouseExited(MouseEvent me)
			{
				Dist.setBackground(null);
				Temp.setBackground(null);
				ComS.setBackground(null);
				Bin.setBackground(null);
				Exit.setBackground(null);
			}
		}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Temp)
		{
				new temp();
				setVisible(false);
		}
		else if(e.getSource()==Dist)
		{
				new Dist();
				setVisible(false);
		}
		else if(e.getSource()==ComS)
		{
				new Comp();
				setVisible(false);
		}
		else if(e.getSource()==Bin)
		{
			new mainF();
			setVisible(false);
		}
		else if(e.getSource()==Exit)
		{
			int i=JOptionPane.showConfirmDialog(rootPane,"Are You Sure You Want to Exit?","WARNING MESSAGE!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.ERROR_MESSAGE);
			if(i==0)
			System.exit(0);

		}
	}

	public static void main(String args[])
	{
		mainCode c = new mainCode();
		c.setVisible(true);
	}
}
