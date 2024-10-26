package MC_5;

public class AlternateOddEven {
    private final int limit;
    private volatile int number =1;

    public AlternateOddEven(int limit){
        this.limit = limit;
    }

    public void printOdd(){
        synchronized (this){
            while(number<=limit){
                if(number%2==0){
                    try{
                        wait();
                    } catch (InterruptedException e){
                        System.out.println("Excetion "+e);
                    }
                }
                if(number<=limit){
                    System.out.println("Odd Thread: "+number);
                    number++;
                    notify();
                }
            }
        }
    }

    public void printEven(){
        synchronized (this){
            while(number<=limit){
                if(number%2!=0){
                    try{
                        wait();
                    } catch (InterruptedException e){
                        System.out.println("Exception "+e);
                    }
                }
                if(number<=limit){
                    System.out.println("Even Thread: "+number);
                    number++;
                    notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        AlternateOddEven printer = new AlternateOddEven(10);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();

    }
}
