import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProducerConsumerSim {
    public static void main(String[] args) {
        int producerCount = 5, consumerCount = 12;
        List<Producer> producers = IntStream.range(0, producerCount)
                .mapToObj(i -> new Producer(Inventory.inventory(10), i)).collect(Collectors.toList());
        List<Consumer> consumers = IntStream.range(0, consumerCount)
                .mapToObj(i -> new Consumer(Inventory.inventory(10), i)).collect(Collectors.toList());

        producers.stream().forEach(prod -> prod.start());
        consumers.stream().forEach(cons -> cons.start());

    }
}
