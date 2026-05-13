package model;

import java.util.ArrayList;
import java.util.List;

public class Bucket {

    private List<SuspectModel> bucketItems = new ArrayList<>();
    private final int capacity;

    public Bucket (int capacity){
        this.capacity = capacity;
    }

    public List<SuspectModel> getBucketItems (){
        return bucketItems;
    }

    public int getCapacity (){
        return capacity;
    }
}
