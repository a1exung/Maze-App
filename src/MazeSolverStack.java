import java.util.*;

public class MazeSolverStack extends MazeSolver {
    
    static MyStack worklist;

    public MazeSolverStack(Maze maze){
        super(maze);

        makeEmpty();
        add(maze.getStart());
        maze.getStart().setPrevious(null);
    }

    public void makeEmpty(){
        worklist = new MyStack();
    }
    
    public boolean isEmpty(){
        return worklist.isEmpty();
    }

    public void add(Square sq){
        worklist.push(sq);
    }

    public Square next(){
        return (Square) worklist.pop();
    }

}
