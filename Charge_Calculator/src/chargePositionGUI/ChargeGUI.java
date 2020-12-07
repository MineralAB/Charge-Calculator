package chargePositionGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

public class ChargeGUI {

	private JFrame frame;
	
	private void initialize (Container pane){
		
	    SpringLayout springLayout = new SpringLayout();
	    JButton button1;
	    JTextField txtField1, txtField2, txtField3;
	    JLabel label1, label2, label3;
	    JPanel panel1, panel2, panel3, panel4, subPanel1, subPanel2, subPanel3;
	    JSplitPane splitPanel1, splitPanel2, splitPanel3;;
	    
	    pane.setLayout(new BorderLayout());

	    	label1 = new JLabel("OuterCircleRadius");
	    	label2 = new JLabel ("InnerCircleMinimumRadius");
	    	label3 = new JLabel ("InnerCircleMaximumRadius");
	    	
	    	txtField1 = new JTextField(20);
	    	txtField2 = new JTextField(20);
	    	txtField3 = new JTextField(20);
	    	
	    	subPanel1 = new JPanel();
	    	subPanel1.setLayout(springLayout);
	    	subPanel1.setBackground(Color.GRAY);
	    	subPanel1.add(label1);
            subPanel1.add(txtField1);
            springLayout.putConstraint(SpringLayout.WEST, label1, 10,SpringLayout.WEST, subPanel1);
            springLayout.putConstraint(SpringLayout.NORTH, label1, 10,SpringLayout.NORTH, subPanel1);
            springLayout.putConstraint(SpringLayout.WEST, txtField1, 10,SpringLayout.EAST, label1);  
            springLayout.putConstraint(SpringLayout.NORTH, txtField1, 0,SpringLayout.NORTH, label1);  
            
	    	subPanel2 = new JPanel();
	    	subPanel2.setLayout(springLayout);
	    	subPanel2.setBackground(Color.LIGHT_GRAY);
            subPanel2.add(label2);
            subPanel2.add(txtField2);
            springLayout.putConstraint(SpringLayout.WEST, label2, 10,SpringLayout.WEST, subPanel2);
            springLayout.putConstraint(SpringLayout.NORTH, label2, 10,SpringLayout.NORTH, subPanel2);
            springLayout.putConstraint(SpringLayout.WEST, txtField2, 10,SpringLayout.EAST, label2);  
            springLayout.putConstraint(SpringLayout.NORTH, txtField2, 0,SpringLayout.NORTH, label2);
 
	    	subPanel3 = new JPanel();
	    	subPanel3.setLayout(springLayout);
	    	subPanel3.setBackground(Color.GRAY);
            subPanel3.add(label3);
            subPanel3.add(txtField3);
            springLayout.putConstraint(SpringLayout.WEST, label3, 10,SpringLayout.WEST, subPanel3);
            springLayout.putConstraint(SpringLayout.NORTH, label3, 10,SpringLayout.NORTH, subPanel3);
            springLayout.putConstraint(SpringLayout.WEST, txtField3, 10,SpringLayout.EAST, label3);  
            springLayout.putConstraint(SpringLayout.NORTH, txtField3, 0,SpringLayout.NORTH, label3);  
 
	    	button1 = new JButton ("CALCULATE");
	    	button1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent calculatePressed) {
	    			System.out.println("pressed");
	    			System.out.println(txtField1.getText());
	    			System.out.println(txtField2.getText());
	    			System.out.println(txtField3.getText());
	    		}
	    	});
	    	
		    panel1 = new JPanel();
		    panel1.setLayout(new GridLayout(4,0));
	    	panel1.add(subPanel1);
	    	panel1.add(subPanel2);
	    	panel1.add(subPanel3);
	    	panel1.add(button1);
	        panel1.setPreferredSize(new Dimension(350, 150));
		    panel1.setMinimumSize(new Dimension(350, 150));
		    panel1.setMaximumSize(new Dimension(350, 150));

		    panel2 = new JPanel();
		    panel2.setBackground(Color.GRAY);
		    
		    panel3 = new JPanel();
		    panel3.setBackground(Color.WHITE);
		    
		    panel4 = new JPanel();
		    panel4.setBackground(Color.DARK_GRAY);
		    
		    splitPanel1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
		    splitPanel1.setEnabled(false);    	
		    	
		    splitPanel2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPanel1, panel3);
		    splitPanel2.setEnabled(false);
	
		    splitPanel3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPanel2, panel4);
		    splitPanel3.setResizeWeight(0.8);
		    splitPanel3.setEnabled(false);
    
	    pane.add(splitPanel3, BorderLayout.CENTER);
	}

	public ChargeGUI(){
		JFrame frame = new JFrame("Charge Calculation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
		frame.setVisible(true);
		initialize(frame.getContentPane());
	}
	
	public static void chargeGUILaunch() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    ChargeGUI window = new ChargeGUI();
                	window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

