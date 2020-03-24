package chrono;  

import java.awt.BorderLayout;
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants; 

public class MyFrame2 extends JFrame {  
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;  
        
       /**  
        * Create the frame.  
        */  
	
       public MyFrame2(int valchoice) {  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setBounds(100, 100, 450, 300);  
            contentPane = new JPanel() {  
                 /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) {  
                      Image img = Toolkit.getDefaultToolkit().getImage(  
                                MyFrame.class.getResource("/pictures/bg.jpg"));  
                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
                 }  
            };  
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
            contentPane.setLayout(new BorderLayout(0, 0));  
            setContentPane(contentPane);  
            
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0,0,0,0));
            panel.setBorder(null);
            contentPane.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);
            
            JLabel lblPleaseChooseYour = new JLabel("Which simulation do you want to purchase ? ");
            lblPleaseChooseYour.setForeground(Color.WHITE);
            lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);
            lblPleaseChooseYour.setBounds(10, 70, 414, 14);
            panel.add(lblPleaseChooseYour);
            
            JButton btnTerre = new JButton("Terre");
            btnTerre.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				int newvalchoice = valchoice ;
            		newvalchoice += 10 ;
    				dispose();
    				MyFrame3 f=new MyFrame3(newvalchoice);
            		f.setVisible(true);
    			}
    		});
            btnTerre.setBackground(Color.BLACK);
            btnTerre.setForeground(Color.WHITE);
    		btnTerre.setBounds(77, 142, 134, 47);
    		panel.add(btnTerre);
    		
    		JButton btnMars = new JButton("Mars");
    		btnMars.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				int newvalchoice = valchoice ;
            		newvalchoice += 20 ;
    				dispose();
    				MyFrame3 f=new MyFrame3(newvalchoice);
            		f.setVisible(true);
    			}
    		});
    		btnMars.setBackground(Color.BLACK);
    		btnMars.setForeground(Color.WHITE);
    		btnMars.setBounds(221, 142, 128, 47);
    		panel.add(btnMars);
    		
    		JButton restart = new JButton("Restart choice");
    		restart.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    				MyFrame f=new MyFrame();
            		f.setVisible(true);
    			}
    		});
    		restart.setBackground(Color.BLACK);
    		restart.setForeground(Color.WHITE);
    		restart.setBounds(5,5, 120, 40);
    		panel.add(restart);
       }  
  } 