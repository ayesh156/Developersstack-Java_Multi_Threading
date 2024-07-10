import java.util.concurrent.atomic.AtomicInteger;

class Increment{
    AtomicInteger i = new AtomicInteger();
    void incrementValue(){
       i.incrementAndGet();
    }
}

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Increment increment = new Increment();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++){
                increment.incrementValue();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++){
                increment.incrementValue();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(increment.i);
    }
}

//---------------------------------------------------------------------


