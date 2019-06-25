package com.company.Interview;

/**
 * 要求先打印5个"hello"，后打印5个"world"
 */

public class ThreadTestAnswer {

    private int i = 0;

    /**
     * As in the one argument version, interrupts and spurious wakeups are
     * possible, and this method should always be used in a loop:
     * <pre>
     *     synchronized (obj) {
     *         while (&lt;condition does not hold&gt;)
     *             obj.wait();
     *         ... // Perform action appropriate to condition
     *     }
     * </pre>
     * This method should only be called by a thread that is the owner
     * of this object's monitor. See the {@code notify} method for a
     * description of the ways in which a thread can become the owner of
     * a monitor.
     */

    /**
     * <p>
     * This method should only be called by a thread that is the owner
     * of this object's monitor. A thread becomes the owner of the
     * object's monitor in one of three ways:
     * <ul>
     * <li>By executing a synchronized instance method of that object.
     * <li>By executing the body of a {@code synchronized} statement
     *     that synchronizes on the object.
     * <li>For objects of type {@code Class,} by executing a
     *     synchronized static method of that class.
     * </ul>
     * <p>
     */

    private Runnable runnable = () -> {
        int index = 0;
        synchronized (ThreadTestAnswer.this) {
            System.out.println("hello");
            i++;
            System.out.println(Thread.currentThread().getId());
            if (i == 5) {
                ThreadTestAnswer.this.notifyAll();
            } else {
                try {
                    ThreadTestAnswer.this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getId());
            System.out.println("world");
        }
    };

    public void test() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
