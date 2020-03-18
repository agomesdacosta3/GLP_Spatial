package chrono;  

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;  
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
        * Launch the application.  
        */  
       public static void main(String[] args) {  
           EventQueue.invokeLater(new Runnable() {  
                public void run() {  
                     try {  
                          MyFrame2 frame = new MyFrame2();  
                          frame.setVisible(true);  
                     } catch (Exception e) {  
                           e.printStackTrace();  
                      }  
                 }  
            });  
       }  
       /**  
        * Create the frame.  
        */  
       public MyFrame2() {  
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
            lblPleaseChooseYour.setBounds(10, 28, 414, 14);
            panel.add(lblPleaseChooseYour);
            
            JButton btnTerre = new JButton("Terre");
            btnTerre.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    				MyFrame3 f=new MyFrame3();
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
    				dispose();
    				MyFrame3 f=new MyFrame3();
            		f.setVisible(true);
    			}
    		});
    		btnMars.setBackground(Color.BLACK);
    		btnMars.setForeground(Color.WHITE);
    		btnMars.setBounds(221, 142, 128, 47);
    		panel.add(btnMars);
       }  
  } 