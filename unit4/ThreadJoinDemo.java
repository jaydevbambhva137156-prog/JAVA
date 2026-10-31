class LoopTask implements Runnable {
    private String taskName;

    public LoopTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Iteration: " + i);
            try {
                Thread.sleep(400); // Simulate work inside loop
            } catch (InterruptedException e) {
                System.out.println(taskName + " was interrupted.");
            }
        }
        System.out.println(">>> " + taskName + " finished execution.");
    }
}

public class ThreadJoinDemo {
    public static void main(String[] args) {
        // Create two threads running loop tasks
        Thread t1 = new Thread(new LoopTask("Thread-1"));
        Thread t2 = new Thread(new LoopTask("Thread-2"));

        System.out.println("Starting Thread-1 and Thread-2...");
        t1.start();
        t2.start();

        try {
            // Main thread waits for t1 and t2 to complete
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nBoth threads have completed their loops. Main thread resumes and terminates.");
    }
}