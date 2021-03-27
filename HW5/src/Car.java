import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdlFinish;
    private CountDownLatch cdlReady;
    private CyclicBarrier cbStart;
    private Lock lock;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed,
               CountDownLatch cdlFinish,
               CountDownLatch cdlReady,
               CyclicBarrier cbStart,
               Lock lock) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdlFinish = cdlFinish;
        this.cdlReady = cdlReady;
        this.cbStart = cbStart;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlReady.countDown();
            cbStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdlFinish.countDown();
        if (lock.tryLock()) {
            System.out.println(this.name + " WIN");
        }
    }
}