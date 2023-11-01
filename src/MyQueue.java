import java.util.*;

public class MyQueue implements QueueADT
{
    private Node first;

    public MyQueue()
    {
        this.first = null;
    }

    public void enqueue(Object item)
    {
        Node newItem = new Node();
        newItem.data = item;

        if(first == null)
        {
            first = newItem;
        }
        else
        {
            Node current = first;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    public Object dequeue() throws NoSuchElementException
    {
        if(first != null)
        {
            Node returned = first;
            first = first.next;
            return returned.data;
        }
        else
            throw new NoSuchElementException();
    }

    public Object front() throws NoSuchElementException
    {
        if(first != null)
            return first.data;
        else
            throw new NoSuchElementException();
    }

    public int size()
    {
        Node current = first;
        int count = 1;
        while(current.next != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void clear()
    {
        first = null;
    }

    static class Node
    {
        public Object data;
        public Node next;
    }
}
