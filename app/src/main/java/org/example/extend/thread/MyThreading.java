package org.example.extend.thread;

public class MyThreading {

    public static void main(String[] args) {
        Thread t1 = new MyThread(5);
        Thread t2 = new MyThread(3);

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }


    static class MyThread extends Thread{

        private final int secondsToWait;

        public MyThread(int secondsToWait) {
            super();
            this.secondsToWait = secondsToWait;
        }

        @Override
        public void run() {
            for(int i=0;i<secondsToWait;i++){
                System.out.println("Thread:"+Thread.currentThread().getName()+" waiting for "+ secondsToWait + ", " +( secondsToWait-i)+" remaining");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
