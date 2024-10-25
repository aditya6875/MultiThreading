package MC_1;

public class MainThreadRunnable {
    public static void main(String[] args) {
        ThreadClass myThread = new ThreadClass();
        myThread.start();

        Thread runnableThread = new Thread(new RunnableInterface());
        runnableThread.start();
        try{
            myThread.join();
            runnableThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main Thread finished");
    }
}
