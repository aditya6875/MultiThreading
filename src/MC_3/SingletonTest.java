package MC_3;

public class SingletonTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            ThreadSafeSingletonPattern instance1 = ThreadSafeSingletonPattern.getInstance();
            System.out.println("Instance1: " + instance1.hashCode());
        });

        Thread thread2 = new Thread(()->{
            ThreadSafeSingletonPattern instance2 = ThreadSafeSingletonPattern.getInstance();
            System.out.println("Instance2: " + instance2.hashCode());
        });

        Thread thread3 = new Thread(()->{
            ThreadSafeSingletonPattern instance3 = ThreadSafeSingletonPattern.getInstance();
            System.out.println("Instance3: " + instance3.hashCode());
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
