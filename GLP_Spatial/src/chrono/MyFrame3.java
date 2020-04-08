package chrono;  

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;  

public class MyFrame3 extends JFrame {  
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int valchoice;
     
       /**  
        * Create the frame.  
        */
       
       public MyFrame3(int valchoice) {
    	   this.valchoice = valchoice;
    	   init();
       }
       
       private void init() { 
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
           setBounds(100, 100, 450, 300);  
           contentPane = new JPanel() {  
                 
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
            
            JRadioButton rdbtnkm1 = new JRadioButton("200 km");
            rdbtnkm1.setForeground(Color.WHITE);
            rdbtnkm1.setBackground(Color.BLACK);
            rdbtnkm1.setBounds(175, 71, 71, 23);
            panel.add(rdbtnkm1);
            rdbtnkm1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
    				valchoice += 100 ;
    			}
    		});

            JRadioButton rdbtnkm2 = new JRadioButton("400km");
            rdbtnkm2.setForeground(Color.WHITE);
            rdbtnkm2.setBackground(Color.BLACK);
            rdbtnkm2.setBounds(248, 71, 71, 23);
            panel.add(rdbtnkm2);
            rdbtnkm2.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				valchoice += 200 ;
    			}
    		});
            
            JLabel lblPropulsionPower = new JLabel("Propulsion Power :");
            lblPropulsionPower.setForeground(Color.WHITE);
            lblPropulsionPower.setBounds(10, 111, 163, 14);
            panel.add(lblPropulsionPower);
            
            JRadioButton rdbtnkm3 = new JRadioButton("5000 kN");
            rdbtnkm3.setForeground(Color.WHITE);
            rdbtnkm3.setBackground(Color.BLACK);
            rdbtnkm3.setBounds(125, 107, 71, 23);
            panel.add(rdbtnkm3);
            rdbtnkm3.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				valchoice += 1000 ;
    			}
    		});
            
            JRadioButton rdbtnkm4 = new JRadioButton("7500 kN");
            rdbtnkm4.setForeground(Color.WHITE);
            rdbtnkm4.setBackground(Color.BLACK);
            rdbtnkm4.setBounds(198, 107, 71, 23);
            panel.add(rdbtnkm4);
            rdbtnkm4.setVisible(true);
            rdbtnkm4.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				valchoice += 2000 ;
    			}
    		});
            
            JLabel lblWeightoftherocket = new JLabel("Weight of the rocket :");
            lblWeightoftherocket.setForeground(Color.WHITE);
            lblWeightoftherocket.setBounds(10, 147, 163, 14);
            panel.add(lblWeightoftherocket);
                    
            JRadioButton rdbtnt1 = new JRadioButton("500T");
            rdbtnt1.setForeground(Color.WHITE);
            rdbtnt1.setBackground(Color.BLACK);
            rdbtnt1.setBounds(137, 143, 71, 23);
            panel.add(rdbtnt1);
            rdbtnt1.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				valchoice += 10000 ;
    			}
    		});
            
            JRadioButton rdbtnt2 = new JRadioButton("750T");
            rdbtnt2.setBackground(Color.BLACK);
            rdbtnt2.setForeground(Color.WHITE);
            rdbtnt2.setBounds(210, 143, 71, 23);
            panel.add(rdbtnt2);
            rdbtnt2.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				valchoice += 20000 ;
    			}
    		});
            
            ButtonGroup groupe1 = new ButtonGroup();
            groupe1.add(rdbtnkm1);
            groupe1.add(rdbtnkm2);
            
            ButtonGroup groupe2 = new ButtonGroup();
            groupe2.add(rdbtnkm3);
            groupe2.add(rdbtnkm4);
            
            ButtonGroup groupe3 = new ButtonGroup();
            groupe3.add(rdbtnt1);
            groupe3.add(rdbtnt2);
            
            JButton btnRocketLaunch = new JButton("Rocket Launch");
            btnRocketLaunch.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    				if ((21111 <= valchoice) && (valchoice <= 21223)) {
    					ChronometerWrongGUI cw = new ChronometerWrongGUI("Launch failed",valchoice);
                		cw.setVisible(true);
    				}
    				else {
    					ChronometerGUI c = new ChronometerGUI("Succesful launch",valchoice);
                		c.setVisible(true);
    				}
    			}
    		});
            btnRocketLaunch.setBackground(Color.BLACK);
            btnRocketLaunch.setForeground(Color.WHITE);
            btnRocketLaunch.setBounds(124, 203, 174, 37);
            panel.add(btnRocketLaunch);
            
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