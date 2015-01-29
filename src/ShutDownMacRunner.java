import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;


public class ShutDownMacRunner {
	
	
	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();

	    // Exit app when frame is closed.
	    mainFrame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent ev) {
	        System.exit(0);
	      }
	    });

	    mainFrame.add(new MainPanel());
	    mainFrame.setSize(320, 240);
	    mainFrame.setVisible(true);
		
	}
	
		
		
	
}
