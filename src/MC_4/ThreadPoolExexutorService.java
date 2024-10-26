package MC_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExexutorService {
    public static void main(String[] args) {

        // create a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit multiple task to the thread pool
        for(int i=0;i<10;i++){
            Runnable task  = new WorkerThread("Task "+i);
            executorService.submit(task);
        }
        // shutting the down the executor service
        executorService.shutdown();

        // Confirm all the tasks are completed
        while(!executorService.isTerminated()){
            System.out.println("wating for all tasks to complete");
        }
        System.out.println("All tasks completed");
    }
}


