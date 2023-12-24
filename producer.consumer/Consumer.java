import java.util.Random;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Consumer(Inventory inventory, int id) {
        super("Consumer-thread-" + id);
        this.inventory = inventory;
    }

    @Override
    public void run() {
        Semaphore prodSemaphore = this.inventory.getpSemaphore();
        Semaphore conSemaphore = this.inventory.getcSemaphore();
        try {
            while (true) {
                conSemaphore.acquire();
                this.inventory.getItemLock().lock();
                this.inventory.consumeItem();
                this.inventory.getItemLock().unlock();
                prodSemaphore.release();
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
