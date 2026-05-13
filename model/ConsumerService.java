package model;

import java.util.List;

public class ConsumerService {

    private final Bucket bucket;

    public ConsumerService (Bucket bucket){
        this.bucket = bucket;
    }

    public SuspectModel consume() throws InterruptedException {
        synchronized (bucket){
            while (bucket.getBucketItems().isEmpty()){
                bucket.wait();
            }

            SuspectModel consumedData = bucket.getBucketItems().get(0);
            bucket.getBucketItems().removeFirst();
            System.out.println("Consumed "+consumedData+" from the bucket");
            bucket.notifyAll();

            return consumedData;
        }
    }


}
