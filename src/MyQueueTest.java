public class MyQueueTest 
{
    public static void main(String[] args)
    {
        MyQueue q = new MyQueue();
        
        // Tests adding different objects to the queue.
        q.enqueue("Alex");
        q.enqueue("Anay");
        q.enqueue("Apte");

        // Checks to make sure dequeue works and both removes and returns the object.
        System.out.println(q.dequeue());

        // Checks to make sure that front just returns the front element
        System.out.println(q.front());
        System.out.println(q.dequeue());

        // Checks to see if the size method returns the size of queue
        System.out.println(q.size());

        // Checks to see if the isEmpty method works and returns if queue is empty
        System.out.println(q.isEmpty());

        // Clears the queue.
        q.clear();
        System.out.println(q.dequeue());
    }
}
