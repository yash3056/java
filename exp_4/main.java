import java.util.LinkedList;

public class main{
   public static void main(String[] args) throws InterruptedException{
       // Create a new instance of the PC class
       final PC pc = new PC();

       // Create two threads: one for production and one for consumption
       Thread t1 = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   // Start the production process
                   pc.produce();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });

       Thread t2 = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   // Start the consumption process
                   pc.consume();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });

       // Start both threads
       t1.start();
       t2.start();

       // Wait for both threads to complete
       t1.join();
       t2.join();
   }

   // Inner class to manage the Producer-Consumer pattern
   public static class PC{
       // Use a LinkedList to store produced values
       LinkedList<Integer> list = new LinkedList<>();

       // Capacity of the storage
       final int capacity = 2;

       // Method for the producer to generate values
       public void produce() throws InterruptedException{
           int value = 0;
           while (true) {
               synchronized (this) {
                   // Wait if the storage is full
                   while (list.size() == capacity) {
                       wait();
                   }

                   // Announce the production and add the value to the list
                   System.out.println("Producer produced-" + value);
                   list.add(value++);

                   // Notify the consumer that a value has been added
                   notify();
                   Thread.sleep(1000);
               }
           }
       }

       // Method for the consumer to retrieve and process values
       public void consume() throws InterruptedException{
           while (true) {
               synchronized (this) {
                   // Wait if the storage is empty
                   while (list.size() == 0) {
                       wait();
                   }

                   // Get the value and announce the consumption
                   int val = list.removeFirst();
                   System.out.println("Consumer consumed-" + val);

                   // Notify the producer that a value has been removed
                   notify();
                   Thread.sleep(1000);
               }
           }
       }
   }
}