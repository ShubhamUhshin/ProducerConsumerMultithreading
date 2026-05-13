Problem Statement
    We have a bucket of size 10. We want to publish suspect model.
    There are multiple publishers and consumers.
    Take a bucket, create publishers and consumers.
    Should be atomic.

Class Design
    Suspect Model Class:
        Create id for unique suspect model id
    Bucket Class:
        This class will have the bucket, capacity
        publish() and consume()

    Publisher Class:
        Use Suspect Model Object
        Create a function createPublisher() -> It will publish data to the bucket if bucket is not full,
        otherwise it will wait for the bucket to have capacity.
    Consumer Class:
        Use Suspect Model Object
        Create a function createConsumer() -> It will consume the data from the bucket if bucket is not
        empty, if it is empty it will wait for the bucket to have some data.

    Create a controller class for publisher which would implement runnable class, creating multiple threads
    Create a controller class for consumer which would implement runnable class, creating multiple threads


Application
    This is used in almost all kinds of real world problems for backend/distributed systems:
        1. Kafka Consumers & Producers
        2. Order Processing Systems
        3. Notification Systems
        4. Thread Pools / ExecutorService
        5. Logging Systems

What problem does this solve?
    Decoupling:
        Producer doesn’t care:
            who consumes
            when consumed

    Concurrency:
        Multiple publishers and consumers work simultaneously.

    Throughput Improvement:
        Parallel processing.


Why synchronization/atomicity needed?
    Because multiple threads access SAME bucket.
    Without synchronization:
        - race conditions
        - corrupted data
        - duplicate/removal issues