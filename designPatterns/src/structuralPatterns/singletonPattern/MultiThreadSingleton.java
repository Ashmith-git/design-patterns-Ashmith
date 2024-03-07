package structuralPatterns.singletonPattern;

import java.util.logging.Logger;

public class MultiThreadSingleton {
	public static final Logger log = Logger.getLogger("MultiThreadSingleton");

	public static void main(String args[]) {
		Thread sciaThread = new Thread(new ThreadSCIA());
		Thread dcaThread = new Thread(new ThreadDCA());

		sciaThread.start();
		dcaThread.start();
	}

	static class ThreadSCIA implements Runnable {
		@Override
		public void run() {
			Singleton singleton = Singleton.getSyncedInstance("SCIA");
			log.info(singleton.filename);
		}

	}

	static class ThreadDCA implements Runnable {
		@Override
		public void run() {
			Singleton singleton = Singleton.getSyncedInstance("DCA");
			log.info(singleton.filename);
		}

	}
}
