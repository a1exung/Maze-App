public class MyQueueTest 
{
    public static void main(String[] args)
    {
        MyQueue q = new MyQueue();
        q.enqueue("Alex");
        q.enqueue("Anay");
        q.enqueue("Apte");

        System.out.println(q.dequeue());
        System.out.println(q.front());
        System.out.println(q.dequeue());
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        q.clear();
        System.out.println(q.dequeue());
    }
}
