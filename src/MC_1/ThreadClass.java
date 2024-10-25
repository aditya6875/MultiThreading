package MC_1;

public class ThreadClass extends Thread {
    @Override
    public void run() {
        for(int i = 0; i <50;i++){
            System.out.println("Extending Thread: "+i);
        }
        try{
            System.out.println("Implementing Thread");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
