import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class first extends JFrame implements ActionListener
{
	JLabel lbl_in = new JLabel("ENTER YOUR NAME");
	JTextField  tf_in = new JTextField(20);
	JLabel lbl_out = new JLabel("");
	JLabel l = new JLabel();
	JButton  B_P = new JButton("Print");
	JButton  B_N = new JButton("Next>>");
	JPanel NP = new JPanel();
	JPanel CP = new JPanel();
	JPanel SP = new JPanel();


	first()
	{
		setSize(500,500);
		setTitle("Welcome To My Convertor");
		setVisible(true);

		NP.add(lbl_in);
		NP.add(tf_in);

		CP.add(lbl_out);
		CP.add(l);

		SP.add(B_P);
		SP.add(B_N);

		add(NP,"North");
		add(CP,"Center");
		add(SP,"South");

		B_P.addActionListener(this);
		B_N.addActionListener(this);

		B_P.addMouseListener(new adpt());
		B_N.addMouseListener(new adpt());
	}

			class adpt extends MouseAdapter implements MouseListener
			{
				public void mouseEntered(MouseEvent me)
				{
				 if(me.getSource()==B_P)
				 {
					 B_P.setBackground(new Color(0xccccb3));
				 }
				else if(me.getSource()==B_N)
				{
					B_N.setBackground(new Color(0xccccb3));
				}
			}
			public void mouseExited(MouseEvent me)
			{
				B_P.setBackground(null);
				B_N.setBackground(null);
			}
		}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==B_P){
			lbl_out.setFont(new Font("Couirer",Font.BOLD,20));
			lbl_out.setText("Welcome    "+tf_in.getText());
			l.setText("\n \t \n \t \t \t \t \t \t \t \t \t Click Next To Proced");
		}
		else if(ae.getSource()==B_N){
			new mainCode();
			setVisible(false);}
	}
	public static void main(String args[])
	{
		first f = new first();
	}
}
