package MC_3;

public class ThreadSafeSingletonPattern {
    // It is like class variables with volatile that ensures visibility of changes to
    // variables across threads
    private static volatile ThreadSafeSingletonPattern instance;

    // declaring private constructor to prevent outside initialization
    private ThreadSafeSingletonPattern(){}

    public static ThreadSafeSingletonPattern getInstance(){
        if(instance == null){ //  first check (without locking)
            synchronized (ThreadSafeSingletonPattern.class) {
                // lock only when the instance is null
                if(instance == null){ // Second check (with locking)
                    instance = new ThreadSafeSingletonPattern(); // Lazy initialization
                }
            }
        }
        return instance;
    }



}
