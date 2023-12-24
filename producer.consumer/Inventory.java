import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    private Queue<String> items;
    private int capacity;
    private static Inventory inventory = null;
    private final Semaphore pSemaphore, cSemaphore;
    private final Lock itemLock;

    public Lock getItemLock() {
        return itemLock;
    }

    public Semaphore getpSemaphore() {
        return pSemaphore;
    }

    public Semaphore getcSemaphore() {
        return cSemaphore;
    }

    public Queue<String> getItems() {
        return items;
    }

    public boolean addItem(String itemToBeAdded) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        System.out.println("Product " + itemToBeAdded + " produced by Thread " + Thread.currentThread().getName());
        this.items.add(itemToBeAdded);
        return true;
    }

    public String consumeItem() {
        String item = items.poll();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        System.out.println("Product " + item + " consumed by Thread " + Thread.currentThread().getName());
        return item;
    }

    private Inventory(Queue<String> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
        this.pSemaphore = new Semaphore(this.capacity);
        this.cSemaphore = new Semaphore(0);
        this.itemLock = new ReentrantLock();
    }

    public static synchronized Inventory inventory(int capacity) {
        if (inventory == null)
            inventory = new Inventory(new LinkedList<>(), capacity);
        return inventory;

    }
}
