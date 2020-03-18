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
import javax.swing.JRadioButton;
import javax.swing.JSlider;  

public class MyFrame3 extends JFrame {  
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
                          MyFrame3 frame = new MyFrame3();  
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
       public MyFrame3() {  
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
            
            JLabel lblSettings = new JLabel("Rocket Settings :");
            lblSettings.setForeground(Color.WHITE);
            lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
            lblSettings.setBounds(10, 28, 414, 14);
            panel.add(lblSettings);
            
            JLabel lblVitess = new JLabel("Moving speed of the Rocket :");
            lblVitess.setForeground(Color.WHITE);
            lblVitess.setBounds(10, 75, 163, 14);
            panel.add(lblVitess);
            
            JRadioButton rdbtnKm = new JRadioButton("200 km");
            rdbtnKm.setForeground(Color.WHITE);
            rdbtnKm.setBackground(Color.BLACK);
            rdbtnKm.setBounds(175, 71, 71, 23);
            panel.add(rdbtnKm);
            
            JRadioButton rdbtnkm = new JRadioButton("400km");
            rdbtnkm.setForeground(Color.WHITE);
            rdbtnkm.setBackground(Color.BLACK);
            rdbtnkm.setBounds(248, 71, 71, 23);
            panel.add(rdbtnkm);
            
            JLabel lblPropulsionPower = new JLabel("Propulsion Power :");
            lblPropulsionPower.setForeground(Color.WHITE);
            lblPropulsionPower.setBounds(10, 111, 163, 14);
            panel.add(lblPropulsionPower);
            
            JSlider slider = new JSlider();
            slider.setBackground(Color.BLACK);
            slider.setBounds(119, 100, 200, 36);
            panel.add(slider);
            
            JLabel lblWeightoftherocket = new JLabel("Weight of the rocket :");
            lblWeightoftherocket.setForeground(Color.WHITE);
            lblWeightoftherocket.setBounds(10, 147, 163, 14);
            panel.add(lblWeightoftherocket);
                    
            JRadioButton rdbtnt = new JRadioButton("5T");
            rdbtnt.setForeground(Color.WHITE);
            rdbtnt.setBackground(Color.BLACK);
            rdbtnt.setBounds(137, 143, 71, 23);
            panel.add(rdbtnt);
            
            JRadioButton rdbtnt_1 = new JRadioButton("10T");
            rdbtnt_1.setBackground(Color.BLACK);
            rdbtnt_1.setForeground(Color.WHITE);
            rdbtnt_1.setBounds(210, 143, 71, 23);
            panel.add(rdbtnt_1);
            
            JButton btnRocketLaunch = new JButton("Rocket Launch");
            btnRocketLaunch.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    				new ChronometerGUI("Launch");
    			}
    		});
            btnRocketLaunch.setBackground(Color.BLACK);
            btnRocketLaunch.setForeground(Color.WHITE);
            btnRocketLaunch.setBounds(124, 203, 174, 37);
            panel.add(btnRocketLaunch);
       }  
  } 