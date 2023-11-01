public class MyStackTest {
    
    static MyStack stack = new MyStack();

    public static void main(String[] args){
        
        //test size and isEmpty on a default (empty) array
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println();

        //checks to make sure that empty stack exception is handled
        //System.out.println(stack.pop());
        //System.out.println(stack.top());

        //adds 1 to the stack, checks all methods on that
        stack.push(1);
        System.out.println(stack.top());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

        System.out.println();

        //adds two elements to the stack, checks all methods off it
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.elements.size());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        stack.clear();

        //checks that the stack was successfully cleared
        System.out.println();
        System.out.println(stack.size());
    }
}
