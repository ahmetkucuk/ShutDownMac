import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CommandExecuter {
	
	public String executeSudoCommand(String[] commands, String password) {
		String s = null;
		
		try {
			
			Process p = Runtime.getRuntime().exec(commands);
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			BufferedWriter stdOutput = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			
			stdOutput.write(password + "\n");
			stdOutput.flush();
			stdOutput.close();
			
			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
			
			
			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
			
			
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
		}
		return s;

	}
	
		public String executeCommand(String[] cmd) {
			
			String s = null;
			
			try {
				
				Process p = Runtime.getRuntime().exec(cmd);
				
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));				
				
				// read the output from the command
				System.out.println("Here is the standard output of the command:\n");
				while ((s = stdInput.readLine()) != null) {
					System.out.println(s);
				}
				
				// read any errors from the attempted command
				System.out.println("Here is the standard error of the command (if any):\n");
				while ((s = stdError.readLine()) != null) {
					System.out.println(s);
				}
				
			} catch (IOException e) {
				System.out.println("exception happened - here's what I know: ");
				e.printStackTrace();
			}
			return s;
		}
	}
	
