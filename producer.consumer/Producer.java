import java.util.Random;
import java.util.concurrent.Semaphore;

public class Producer extends Thread {

    private final Inventory inventory;

    public Producer(Inventory inventory, int id) {
        super("Procuer-thread-" + id);
        this.inventory = inventory;
    }

    @Override
    public void run() {
        Semaphore prodSemaphore = this.inventory.getpSemaphore();
        Semaphore conSemaphore = this.inventory.getcSemaphore();
        try {
            while (true) {
                prodSemaphore.acquire();
                this.inventory.getItemLock().lock();
                this.inventory.addItem("item" + "-" + new Random().nextInt());
                this.inventory.getItemLock().unlock();
                conSemaphore.release();
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
