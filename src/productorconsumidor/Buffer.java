package productorconsumidor;

public class Buffer {
    private int[] buffer;
    private int contador = 0;
    private int tamanio;
    public int in = 0;
    public int out = 0;


    public Buffer(int tamanio) {
        this.tamanio = tamanio;
        buffer = new int[tamanio];
    }

    public synchronized void producir(int item)  throws InterruptedException {

        while (contador == tamanio){
            wait();
        }
        buffer[in] = item; //insertamos el item en poscision in
        System.out.println( "Producido: " + item );
        in = (in + 1) % tamanio;  //movemos de manera circular
        contador++;
        notifyAll();

    }

    public synchronized int consumidor() throws InterruptedException {
        while (contador == 0){
            wait();
        }
        int item = buffer[out]; // lo consume lo del out
        System.out.println( "Consumido: " + item );
        out = (out + 1) % tamanio;
        contador--;
        notifyAll();
        return item;

    }
}