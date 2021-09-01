package Interruption;

public class Interruption {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        thread1.start();
        Thread.sleep(1000);
        thread1.interrupt();
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println("Ждем");
            }
        }
    }
}

