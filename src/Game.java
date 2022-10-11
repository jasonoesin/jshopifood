import data.Data;
import threads.InputUtilities;
import threads.OutputUtilities;
import threads.TimerRunnable;

public class Game  {
	Thread inp,out,timerThread;
	InputUtilities iut;
	OutputUtilities outil;
	
	public Game() {
		init();
	}
	
	public void init() {
		timerThread = new Thread(new TimerRunnable());
		timerThread.start();
		
		iut = new InputUtilities();
		outil = new OutputUtilities();
		
		inp = new Thread(iut);
		inp.start();
		
		out = new Thread(outil);
		out.start();
	}
}
