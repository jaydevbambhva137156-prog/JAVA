class PriorityTask implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("Executing -> Name: " + current.getName() + " | Priority: " + current.getPriority());
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Create Runnable tasks
        PriorityTask task = new PriorityTask();

        // Create threads
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        // Setting Thread Names
        t1.setName("Low-Priority-Thread");
        t2.setName("Normal-Priority-Thread");
        t3.setName("High-Priority-Thread");

        // Setting Thread Priorities using standard constants
        t1.setPriority(Thread.MIN_PRIORITY);  // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t3.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        // Display initial configurations
        System.out.println("=== Thread Configurations ===");
        System.out.println(t1.getName() + " priority: " + t1.getPriority());
        System.out.println(t2.getName() + " priority: " + t2.getPriority());
        System.out.println(t3.getName() + " priority: " + t3.getPriority());
        System.out.println("\n=== Starting Threads ===");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}