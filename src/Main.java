
import java.util.Scanner;

import data.Data;
import threads.InputUtilities;
import threads.OutputUtilities;
import utils.FileUtilities;

public class Main {
	Scanner in = new Scanner(System.in);
	
	public void logo() {
		
		while(true) {
			for(int i = 0; i < 50 ;i++)
				System.out.println("");
			
			System.out.println("\t    ___  ________  ___  ___  ________  ________  ___  ________ ________  ________  ________     \r\n" + 
					"\t   |\\  \\|\\   ____\\|\\  \\|\\  \\|\\   __  \\|\\   __  \\|\\  \\|\\  _____\\\\   __  \\|\\   __  \\|\\   ___ \\    \r\n" + 
					"\t   \\ \\  \\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\ \\  \\__/\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\   \r\n" + 
					"\t __ \\ \\  \\ \\_____  \\ \\   __  \\ \\  \\\\\\  \\ \\   ____\\ \\  \\ \\   __\\\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\  \r\n" + 
					"\t|\\  \\\\_\\  \\|____|\\  \\ \\  \\ \\  \\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\ \\  \\_| \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ \r\n" + 
					"\t\\ \\________\\____\\_\\  \\ \\__\\ \\__\\ \\_______\\ \\__\\    \\ \\__\\ \\__\\   \\ \\_______\\ \\_______\\ \\_______\\\r\n" + 
					"\t \\|________|\\_________\\|__|\\|__|\\|_______|\\|__|     \\|__|\\|__|    \\|_______|\\|_______|\\|_______|\r\n" + 
					"\t           \\|_________|                                                                         \r\n" + 
					"\t                                                                                                \r\n" + 
					"\t                                                                                                ");
			
			System.out.println("\t[S] Start Game\t\t[Q] Quit");
			System.out.println("");
			System.out.print("\t>> ");
			
			String temp = in.nextLine();
			
			if (temp.equalsIgnoreCase("S")) {
				return;
			}else if (temp.equalsIgnoreCase("Q")){
				//quit();
				OutputUtilities.exitLogo();
			}
			
		}
	}

	public Main() {
		FileUtilities.GetData();
		
		logo();
		
		new Game();
	}

	public static void main(String[] args) {
		new Main();
	}
}
