import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABC {

    private static final Object KEY = new Object();
    private static final int ITERATION = 5;
    private static volatile char curChar = 'A';

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                for (int i = 0; i < ITERATION; i++) {
                    synchronized (KEY) {
                        while (curChar != 'A') {
                            KEY.wait();
                        }
                        System.out.println("A");
                        curChar = 'B';
                        KEY.notifyAll();
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        executorService.submit(() -> {
            try {
                for (int i = 0; i < ITERATION; i++) {
                    synchronized (KEY) {
                        while (curChar != 'B') {
                            KEY.wait();
                        }
                        System.out.println("B");
                        curChar = 'C';
                        KEY.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        executorService.submit(() -> {
            try {
                for (int i = 0; i < ITERATION; i++) {
                    synchronized (KEY) {
                        while (curChar != 'C') {
                            KEY.wait();
                        }
                        System.out.println("C");
                        curChar = 'A';
                        KEY.notifyAll();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }
}

