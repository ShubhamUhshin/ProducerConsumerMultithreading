package controller;

import model.Bucket;
import model.PublisherService;
import model.SuspectModel;

public class Publisher implements Runnable {

    private final PublisherService publisher;

    private static int counter = 1;

    public Publisher(PublisherService publisher) {
        this.publisher = publisher;
    }


    @Override
    public void run() {

        try{
            while (true){
                SuspectModel model;

                synchronized (Publisher.class){
                    model = new SuspectModel(counter++);
                }

                publisher.publishData (model);
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
