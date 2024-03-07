package structuralPatterns.singletonPattern;

public class Singleton {

	private static volatile Singleton singletonInstance = null;
	public String filename = null;

	private Singleton(String file_name) {

		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.filename = file_name;
	}

	public static Singleton getInstance(String file_name) {
		if (singletonInstance == null) {
			singletonInstance = new Singleton(file_name);
		}
		return singletonInstance;
	}

	public static Singleton getSyncedInstance(String file_name) {
		Singleton localSingleton = singletonInstance;
		if (localSingleton != null) {
			return localSingleton;
		}
		synchronized (Singleton.class) {
			if (singletonInstance == null) {
				singletonInstance = new Singleton(file_name);
			}
		}
		

		return singletonInstance;
	}
}
