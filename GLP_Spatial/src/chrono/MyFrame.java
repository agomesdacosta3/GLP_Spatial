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

public class MyFrame extends JFrame {  
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
                          MyFrame frame = new MyFrame();  
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
       public MyFrame() {  
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
            
            JLabel lblPleaseChooseYour = new JLabel("Please choose the launch base...");
            lblPleaseChooseYour.setForeground(Color.WHITE);
            lblPleaseChooseYour.setHorizontalAlignment(SwingConstants.CENTER);
            lblPleaseChooseYour.setBounds(10, 28, 414, 14);
            panel.add(lblPleaseChooseYour);
            
            JButton btnCapCanaveral = new JButton("Cap Canaveral");        
            btnCapCanaveral.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		dispose();
            		MyFrame2 f=new MyFrame2();
            		f.setVisible(true);
            	}
            });
            btnCapCanaveral.setBackground(Color.BLACK);
            btnCapCanaveral.setForeground(Color.WHITE);
    		btnCapCanaveral.setBounds(10, 142, 134, 47);
    		panel.add(btnCapCanaveral);
    		
    		JButton btnParis = new JButton("Paris");
    		btnParis.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    				MyFrame2 f=new MyFrame2();
            		f.setVisible(true);
    			}
    		});
    		btnParis.setBackground(Color.BLACK);
    		btnParis.setForeground(Color.WHITE);
    		btnParis.setBounds(154, 142, 128, 47);
    		panel.add(btnParis);
    		
    		JButton btnPlenord = new JButton("North-Pôle");
    		btnPlenord.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    				MyFrame2 f=new MyFrame2();
            		f.setVisible(true);
    			}
    		});
    		btnPlenord.setBackground(Color.BLACK);
    		btnPlenord.setForeground(Color.WHITE);
    		btnPlenord.setBounds(292, 142, 132, 47);
    		panel.add(btnPlenord);
       }  
  } 