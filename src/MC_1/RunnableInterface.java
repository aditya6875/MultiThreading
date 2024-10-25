package MC_1;

public class RunnableInterface implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<50;i++){
            System.out.println("Impelementing Runnbale: "+i);
        }
    }
}
