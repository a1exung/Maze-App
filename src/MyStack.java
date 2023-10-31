import java.util.*;

public class MyStack implements StackADT<Object>{
    public ArrayList<Object> elements;

    public MyStack(){
        elements = new ArrayList<>();
    }

    public void push(Object element){
        elements.add(element);
    }
    
    public Object pop(){
        if (!isEmpty()){
            return elements.remove(elements.size() - 1);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public Object top(){
        if (!isEmpty()){
            return elements.get(elements.size() - 1);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public int size(){
        return elements.size();
    }
    

    public boolean isEmpty(){
        return elements.size() == 0;
    }

    public void clear(){
        while (elements.size() > 0){
            elements.remove(0);
        }
    }
}
