import java.util.*;

public class MyQueue implements QueueADT
{
    private Node first;

    // Implements a Queue as a series of nodes. The default sets the first node to null.
    public MyQueue()
    {
        this.first = null;
    }

    /**
     * Add an item to the queue
     * @param Object item that is added to the queue.
     */
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

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
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

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Object front() throws NoSuchElementException
    {
        if(first != null)
            return first.data;
        else
            throw new NoSuchElementException();
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
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

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Clear out the data structure
     */
    public void clear()
    {
        first = null;
    }

    /**
     * Checks if a node in a series of nodes contains an object as its data
     * @param the item that is being compares
     * @return true if the queue contains the item, false if not.
     */
    public boolean contains(Object o){
        if (first == null) return false;
        else {
            Node current = first;
            while (current == null){
                if (current.data == o) return true;
                current = current.next;
            }
        }
        return false;
    }

    // Nested Node Class
    static class Node
    {
        public Object data;
        public Node next;
    }
}
