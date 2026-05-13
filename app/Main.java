package app;

import controller.Consumer;
import controller.Publisher;
import model.Bucket;
import model.ConsumerService;
import model.PublisherService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Producer Consumer Service");

        Bucket bucket = new Bucket(10);

        PublisherService publisherService = new PublisherService(bucket);

        ConsumerService consumerService = new ConsumerService(bucket);

        // Multiple Publishers
        for (int i=1; i <= 5; i++){
            new Thread(new Publisher(publisherService), "Publisher-" +i).start();
        }

        //Multiple Consumers
        for (int i=1; i <= 5; i++){
            new Thread(new Consumer(consumerService), "Consumer-"+i).start();
        }


    }
}
