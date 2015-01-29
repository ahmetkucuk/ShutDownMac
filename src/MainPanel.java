import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;

public class MainPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public static final String textAreaInitial = "Write time to shut down(min)";
		private JTextArea textArea = new JTextArea(textAreaInitial);
		private JTextField textField = new JTextField("", 20);
		private JButton button = new JButton("Start");
		private static final String SHUT_DOWN_COMMAND = "osascript -e 'tell application \"System Events\" to shut down'";
		private static final String[] SHUT_DOWN_SUDO_COMMANDS = new String[] {"sudo", "-S", "shutdown -h now"};
		private static final String[] SHUT_DOWN_COMMANDS = new String[] {"osascript", "-e", "tell application \"System Events\" to shut down"};
		private int timeCounter = 0;
		private CommandExecuter commandExecuter = new CommandExecuter();
		
		public MainPanel() {
			add(textArea);
			add(textField);
			add(button);
			button.addMouseListener(adapter);
			
		}
		
		MouseAdapter adapter = new MouseInputAdapter() {
			
			private boolean isStart = true;
			private Thread shutDownThread;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(isStart) {
					if(!testInput(textField.getText())) {
						JOptionPane.showMessageDialog(null, "Only Integer value can be entered.", "Invalid Input.", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						return;
					}
					textField.setVisible(false);
					button.setText("Cancel");

					timeCounter = Integer.parseInt(textField.getText()) * 60;

					textArea.setText(timeCounter+"");
					timer.start();
				} else {

					textField.setVisible(true);
					button.setText("Start");
					textArea.setText(textAreaInitial);
					
					timer.stop();
				}
				isStart = !isStart;
				System.out.println("Clicked");
			}
		};
		
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				timeCounter -= 1;
				textArea.setText(timeCounter+"");
				if(timeCounter <= 0) {
					commandExecuter.executeCommand(SHUT_DOWN_COMMANDS);
					System.exit(0);
				}
			}
		});
		
		private boolean testInput(String text) {
		      try {
		         Integer.parseInt(text);
		         return true;
		      } catch (NumberFormatException e) {
		         return false;
		      }
		   }
	}
