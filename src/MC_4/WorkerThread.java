package MC_4;

public class WorkerThread implements Runnable {
    private String taskName;

    public WorkerThread(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"- Executing: "+taskName);
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName()+"- Completed: "+taskName);
    }
}
