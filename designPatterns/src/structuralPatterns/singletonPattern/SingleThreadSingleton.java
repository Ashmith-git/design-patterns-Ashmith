package structuralPatterns.singletonPattern;

import java.util.logging.Logger;

public class SingleThreadSingleton {
	public static final Logger log = Logger.getLogger("SingleThreadSingleton");

	public static void main(String args[]) {
//		Singleton s1=Singleton.getInstance("SCIA");
//		Singleton s2=Singleton.getInstance("DCA");

//		log.info(s1.filename);
//		log.info(s2.filename);
//		log.info(s1.filename);
		

		Thread sciaThread=new Thread(new ThreadSCIA());
		Thread dcaThread=new Thread(new ThreadDCA());
		
		sciaThread.start();
		dcaThread.start();
		

	}

	static class ThreadSCIA implements Runnable {
		@Override
		public void run() {
			Singleton singleton = Singleton.getInstance("SCIA");
			log.info(singleton.filename);
		}

	}

	static class ThreadDCA implements Runnable {
		@Override
		public void run() {
			Singleton singleton = Singleton.getInstance("DCA");
			log.info(singleton.filename);
		}

	}
}
