package productorconsumidor;

public class Consumidor implements Runnable{

    private Buffer buffer;


    public Consumidor(Buffer buffer) {
        this.buffer = buffer;

    }


    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                buffer.consumidor();
                Thread.sleep(1000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }

        }

    }
}
