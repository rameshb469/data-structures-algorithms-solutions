package ds;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton(){}

    public static synchronized  Singleton getInstance(){
        if (singleton == null) {
            return new Singleton();
        }
        return singleton;
    }
}
