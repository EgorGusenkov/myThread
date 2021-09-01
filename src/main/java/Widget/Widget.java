package Widget;

import java.util.concurrent.Phaser;

public class Widget {
    public static void main(String[] args) {
        int numWIdget = 3;
        Phaser phaser = new Phaser(numWIdget);

        Runnable widget1 = () -> {
            for (int i = 0; i < numWIdget; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Произвели первый винтик!");
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable widget2 = () -> {
            for (int i = 0; i < numWIdget; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Произвели второй винтик!");
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable widget3 = () -> {
            for (int i = 0; i < numWIdget; i++) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Произвели третий винтик!");
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable factory = () -> {
            //
        };

        new Thread(widget1).start();
        new Thread(widget2).start();
        new Thread(widget3).start();
        new Thread(factory).start();
    }
}
