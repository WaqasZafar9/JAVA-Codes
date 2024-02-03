
class SharedBuffer {
    private int[] buffer;
    private int size;
    private int count;

    public SharedBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.count = 0;
    }

    public synchronized void produce(int item) {
        while (count == size) {
            try {
                wait(); // Buffer is full, wait for the consumer to consume
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        buffer[count] = item;
        count++;
        System.out.println("Produced: " + item);
        notify(); // Notify the consumer that an item is available
    }

    public synchronized int consume() {
        while (count == 0) {
            try {
                wait(); // Buffer is empty, wait for the producer to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int item = buffer[count - 1];
        count--;
        System.out.println("Consumed: " + item);
        notify(); // Notify the producer that space is available in the buffer
        return item;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(1000); // Simulate production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int item = buffer.consume();
            try {
                Thread.sleep(1000); // Simulate consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(2);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
