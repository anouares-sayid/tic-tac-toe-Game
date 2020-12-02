
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOcode extends JFrame implements ActionListener {
	
	
	
	private int clicked=0;
	private String winner=" ";
	private int  Xwin=0 ;
	private int  Owin=0;
    private String choix;
   	private JButton [] [] btn =  new JButton[3] [3];
	private JButton btn1 = new JButton();
	private JButton btn2= new JButton();
	private JButton btn3= new JButton();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p6 = new JPanel();
	private JPanel p7 = new JPanel();
	private JPanel p5 = new JPanel();
	private JPanel p8 = new JPanel();
	private JPanel p9 = new JPanel();
	private JPanel p10 = new JPanel();
	private JMenuBar Bar1 = new JMenuBar();
	private JMenu menu1 = new JMenu("menu");
	private JMenuItem item1 = new JMenuItem("Restart");
	private JMenuItem item2 = new JMenuItem("Reset");
	private JMenuItem item3 = new JMenuItem("Exit");
	private GridLayout g1 = new GridLayout(1,3);
	private JRadioButton r1 = new JRadioButton();
	private JRadioButton r2 = new JRadioButton();
	private JLabel labelx = new JLabel("Player X");
	private JLabel labelo = new JLabel("Player O");
	private JLabel result = new JLabel("Result  :");
	private JLabel resx = new JLabel("                    Player X \n "+Xwin+"      ");
	private JLabel reso = new JLabel("         Player O \n "+Owin+"      ");
	private ButtonGroup  btngr = new ButtonGroup();
	
	public  XOcode() {
		r1.setSelected(true);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		Bar1.add(menu1);
		btngr.add(r1);
		btngr.add(r2);
		p1.setLayout(new GridLayout(3,3));
		 p2.setLayout(new GridLayout(3,1));
		 p4.setLayout(new GridLayout(2,1));
		 p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		 p10.setLayout(new FlowLayout(FlowLayout.CENTER));
		 p5.setLayout(new BoxLayout(p5,BoxLayout.Y_AXIS));
		 p6.setLayout(new BoxLayout(p6,BoxLayout.Y_AXIS));
		 p7.setLayout(new GridLayout(1,1));
		 p2.add(btn1);
		 p2.add(btn2);
			p2.add(btn3);
			btn1.setText("Restart");
			btn1.setBackground(Color.GREEN);
			btn1.addActionListener(this);
			btn2.setText("Reset");
			btn2.setBackground(Color.orange);
			btn2.addActionListener(this);
			btn3.setBackground(Color.red);
			btn3.setForeground(Color.WHITE);
			btn2.setForeground(Color.WHITE);
			btn1.setForeground(Color.WHITE);
			btn3.setText("Exit");
			btn3.addActionListener(this);
			item1.addActionListener(this);
			item2.addActionListener(this);
			item3.addActionListener(this);
			p4.setBackground(null);
			p5.setBackground(null);
			p8.add(r1);
			r1.addActionListener(this);
			r2.addActionListener(this);
			p8.add(labelx);
			p9.add(r2);
			p9.add(labelo);
			p5.add(p8);
			p5.add(p9);
			p6.setBackground(null);
			   for (int i =0 ; i<3 ;i++) {
				   for(int j =0 ; j<3 ;j++) {
					   btn[i] [j] = new JButton ();
					   btn[i][j].setText(" ");
					   btn[i][j].setFont(new Font("Arial",Font.PLAIN,40));
					   btn[i][j].setBackground(Color.WHITE);
					   
					  btn[i][j].addActionListener(this);
					  p1.add(btn[i][j]);
				   }
			   }
	p3.setLayout(g1);
	p6.add(result);
	p6.add(p10);
	p10.add(resx);
	p10.add(reso);
	p3.add(p1);
	p3.add(p6);
	p4.add(p5);
	p4.add(p2);
	p3.add(p4);
	this.add(p3);
	this.setJMenuBar(Bar1);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
	
		this.setVisible(true);
		setBounds(400,400,900,400);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(r1.isSelected()) {
			choix="X";
			
		}else
		if(r2.isSelected()) {
			choix="O";
			
		}
		// choose  who will start first
		 for(int i=0; i<3 ; i++) {
				
			 for(int j =0 ; j<3 ;j++) {
		if(e.getSource() == btn[i][j]) {
			clicked=clicked+1;
			btn[i][j].setForeground(Color.red);
			btn[i][j].setText(choix);
			btn[i][j].setEnabled(false);
			if(r2.isSelected()) {
			
				r1.setSelected(true);
				r2.setSelected(false);
			} else if(r1.isSelected()){
				r2.setSelected(true);
				r1.setSelected(false);
			}
		
			testwin(); }
		
			 }
		 }
	
		/// restart button
		 if(( (e.getSource() == btn1 || e.getSource() == item1 ) && clicked==9) ||((e.getSource() == btn1 || e.getSource() == item1 ) && winner!=" " )) {
			 winner=" ";
			   for (int i =0 ; i<3 ;i++) {
				   for(int j =0 ; j<3 ;j++) {
					   btn[i][j].setBackground(Color.WHITE);
					  btn[i][j].setEnabled(true);
					  btn[i][j].setText(" ");
					  r1.setSelected(true);
					  clicked =0;
					  
				   }
			   }
		 }
		///  reset button
		 if(e.getSource() == btn2 || e.getSource() == item2 ) {
			 winner=" ";
			   for (int i =0 ; i<3 ;i++) {
				   for(int j =0 ; j<3 ;j++) {
					   btn[i][j].setBackground(Color.WHITE);
					  btn[i][j].setEnabled(true);
					  btn[i][j].setText(" ");
					  r1.setSelected(true);
					  clicked =0;
					  
				   }
			   }
		 }
		 if(e.getSource() == btn3 || e.getSource() == item3 ) {
		System.exit(0);
		 }
		 
	}
	
	
	
	public void testwin() {
		   
		   for(int i=0; i<3 ; i++) {
			  
		                   /// Check Lines
					 if(btn[i][0].getText().equals(btn[i][1].getText())  &&  btn[i][0].getText().equals(btn[i][2].getText()) && btn[i][0].getText()!=" " ){
						 winner=btn[i][0].getText();
						 btn[i][0].setBackground(Color.GREEN);
								 btn[i][1].setBackground(Color.GREEN);
										 btn[i][2].setBackground(Color.GREEN);
										 btn[i][0].setForeground(Color.WHITE);
												 btn[i][1].setForeground(Color.WHITE);
														 btn[i][2].setForeground(Color.WHITE);
										
						}else
							/// Check Columns
					 if(btn[0][i].getText().equals(btn[1][i].getText())  &&  btn[0][i].getText().equals(btn[2][i].getText()) && btn[0][i].getText()!=" " ){
						 winner=btn[0][i].getText();

						 btn[0][i].setBackground(Color.GREEN);
								 btn[1][i].setBackground(Color.GREEN);
										 btn[2][i].setBackground(Color.GREEN);

										 btn[0][i].setForeground(Color.WHITE);
												 btn[1][i].setForeground(Color.WHITE);
														 btn[2][i].setForeground(Color.WHITE);
						}else
							/// Check Left Diagonal
					 if(btn[0][0].getText().equals(btn[1][1].getText())  &&  btn[0][0].getText().equals(btn[2][2].getText()) && btn[0][0].getText()!=" " ){
						 winner=btn[0][0].getText();

						 btn[0][0].setBackground(Color.green);
								 btn[1][1].setBackground(Color.green);
										 btn[2][2].setBackground(Color.green);

										 btn[0][0].setForeground(Color.WHITE);
												 btn[1][1].setForeground(Color.WHITE);
														 btn[2][2].setForeground(Color.WHITE);
						}else
							/// Check Right Diagonal
					 if(btn[0][2].getText().equals(btn[1][1].getText())  &&  btn[0][2].getText().equals(btn[2][0].getText()) && btn[0][2].getText()!=" " ){
						 
						 winner=btn[0][2].getText();

						 btn[0][2].setBackground(Color.GREEN);
								 btn[1][1].setBackground(Color.GREEN);
										 btn[2][0].setBackground(Color.GREEN);
										 btn[0][2].setForeground(Color.WHITE);
												 btn[1][1].setForeground(Color.WHITE);
														 btn[2][0].setForeground(Color.WHITE);
						}
					
					 
		
				 }
		   ///check for draw
		   if(clicked==9 && winner==" " ) {

				 JOptionPane.showMessageDialog(null," YOU BOTH ARE  LOOSERS !!!");
			}
		 ///check winner
		   if(winner!=" ") {
				 
				 JOptionPane.showMessageDialog(null,"The winner is    " + winner + "     !!!");
				   for (int i =0 ; i<3 ;i++) {
					   for(int j =0 ; j<3 ;j++) {
						 
						  btn[i][j].setEnabled(false);
					   }
				   }
				   //show result 
				   if(winner=="O") {
					   Owin=Owin+1;
					   reso.setText("                    Player O \n "+Owin+"      ");
				   }else {
					   Xwin=Xwin+1;
					   resx.setText("         Player X \n "+Xwin+"      ");
				   }
			 }
		
		   
	   }

	
}
