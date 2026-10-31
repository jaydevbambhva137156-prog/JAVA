// Step 1: Create a class that extends Thread
class MyThread extends Thread {

    // Step 2: Override the run() method to define the thread's task
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread executing: Count " + i);
            try {
                // Pause thread execution for 500 milliseconds
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class ThreadClassDemo {
    public static void main(String[] args) {
        // Step 3: Instantiate the thread object
        MyThread thread1 = new MyThread();

        // Step 4: Call start() to initiate execution (calls run() internally)
        System.out.println("Starting Child Thread...");
        thread1.start();

        // Main thread tasks running concurrently
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread executing: Count " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted: " + e.getMessage());
            }
        }
    }
}