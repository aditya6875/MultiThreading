package MC_2;

public class WaitSleepThread extends Thread {
    private final Object lock = new Object();
    @Override
    public void run() {
            System.out.println("Wait sleep thread implementation");

    }
    public void waitingThread() throws InterruptedException {
        synchronized (lock){
            System.out.println("Thread " + Thread.currentThread().getName() + " is waiting.");
            lock.wait(); // Causes the current thread to wait
            System.out.println("Thread " + Thread.currentThread().getName() + " resumed after wait.");
        }

    }

    public void notifyWaitingThread() {
        synchronized (lock) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is notifying waiting thread.");
            lock.notify(); // Wakes up one waiting thread
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new WaitSleepThread();
        sleepThread.start();
        System.out.println("Sleep thread started");
        sleepThread.sleep(5000);
        System.out.println("Awake thread and now i will print");

        WaitSleepThread waitThread = new WaitSleepThread();
        waitThread.start();

        new Thread(()->{
            try{
                waitThread.waitingThread();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }).start();

        Thread.sleep(5000);
        waitThread.notifyWaitingThread();


    }
}
