package controller;

import model.ConsumerService;
import model.SuspectModel;

public class Consumer implements Runnable{

    private ConsumerService consumer;

    public Consumer(ConsumerService consumer){
        this.consumer = consumer;
    }


    @Override
    public void run() {

        try {
            while (true) {
                consumer.consume();
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
