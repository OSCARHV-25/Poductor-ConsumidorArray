package productorconsumidor;

public class AppProductorConsumidor {

    public static void main(String[] args) {
        Buffer buffer =new Buffer(5);

        Thread productor =new Thread(new Productor(buffer));
        Thread consumidor =new Thread(new Consumidor(buffer));

        productor.start();
        consumidor.start();
    }
}
