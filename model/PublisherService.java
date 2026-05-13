package model;

import java.util.ArrayList;

public class PublisherService {

    private Bucket bucket;

    public PublisherService (Bucket bucket){
        this.bucket = bucket;
    }

    public void publishData(SuspectModel model) throws InterruptedException {

        synchronized (bucket){
            while (bucket.getBucketItems().size() == bucket.getCapacity()){
                bucket.wait();
            }

            bucket.getBucketItems().add(model);

            System.out.println("Published "+model+" to bucket");
            bucket.notifyAll();
        }
    }
}
