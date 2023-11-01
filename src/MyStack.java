import java.util.*;

public class MyStack implements StackADT<Object>{
    public ArrayList<Object> elements;

    public MyStack(){
        elements = new ArrayList<>();
    }


    /**
     * Add an item onto the stack
     * @param element the data item to add
     */
    public void push(Object element){
        elements.add(element);
    }
    
    /**
     * Remove the top item from the stack
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public Object pop(){
        if (!isEmpty()){
            return elements.remove(elements.size() - 1);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public Object top(){
        if (!isEmpty()){
            return elements.get(elements.size() - 1);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    public int size(){
        return elements.size();
    }
    
    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
        return elements.size() == 0;
    }

    /**
     * Clear out the data structure
     */
    public void clear(){
        while (elements.size() > 0){
            elements.remove(0);
        }
    }
}
