package DeadlockEmulator;

public class DeadlockEmulator {
    public static Object sync1 = new Object();
    public static Object sync2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (sync1) {
                System.out.println("Thread 1: Holding lock 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2");

                synchronized (sync2) {
                    System.out.println("Thread 1: Holding lock 1 & 2");
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (sync2) {
                System.out.println("Thread 2: Holding lock 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 2: Waiting for lock 1");

                synchronized (sync1) {
                    System.out.println("Thread 2: Holding lock 1 & 2");
                }
            }
        }
    }
}
