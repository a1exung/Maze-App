import java.util.*;

public abstract class MazeSolver {

    // Creates a maze variable, a path variable as a general worklist, and booleans for whether the worklist is finished or if the element is the last.
    // The four variables are protected so they can be accessed by the MazeSolverQueue and MazeSolverStack classes.
    protected static Maze maze;
    protected static Stack<Square> path;
    protected boolean finished = false, last = false;

    // Initializes the maze and the path.
    public MazeSolver(Maze maze){
        this.maze = maze;
        path = new Stack<>();
    }

    /*
    * ALL FOUR METHODS ARE ABSTRACT SO THEY CAN BE IMPLEMENTED IN MAZESOLVERQUEUE AND MAZESOLVERSTACK.
    */
    abstract void makeEmpty();
    
    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    // Checks if the algorithm has solved the maze
    // This method is used to determine if there is an exit path or not.
    public boolean isSolved(){
        return finished;
    }

    // Gets the path to the end of the maze.
    public String getPath(){
        // If the maze worklist isn't empty and if the next coordinate isn't the exit, then there is no solution path.
        if (isEmpty() && !last){
            return "There is no solution path";
        } else {
            /*
            * Since the worklist is a stack, we must add coordinates backwards so they are popped in order. Therefore, we add the finish first.
            * Adds more elements to the worklist as long as the previous isn't null (if it is, it's the first element.
            * Prints out the order by popping backwards.
            */
            Square current = maze.getFinish();
            String path = "[" + current.getRow() + ", " + current.getCol() + "]";

            while (current.getPrevious() != null) {
                current = current.getPrevious();
                current.onPath();
                path = "[" + current.getRow() + ", " + current.getCol() + "] " + path;
            }
            return "The solution path is: " + path;
        }
    }

    // Performs each individual step
    public Square step(){
        // Calls on the isEmpty method. If worklist empty, then the puzzle is solved and no square returned.
        if (isEmpty()){
            finished = true;
            return null;
            
        }
        else {
            Square next = next();

            // Checks if the next square is the exit, returns it if it is.
            if (next.getType() == 3){
                finished = true;
                last = true;
                return next;
            }
            // Adds the neighbors of each square, checks to make sure that they're either empty spaces or the exit to be added.
            // Only elements that aren't already in the worklist are added.
            else {
                ArrayList<Square> neighbors = maze.getNeighbors(next);
                
                for (Square s : neighbors){
                    if (s.getType() == 0 || s.getType() == 3) {
                        add(s);
                        if (!s.inList){
                            s.setPrevious(next);
                        }
                        s.enlist();
                    }
                }    

                next.explore();
                  
            }
            
            return next;

        }
    }

    /**
     * If the puzzle isn't solved, we keep calling step.
     */
    public void solve(){
        while (!isSolved()){
            step();
        }
    }
}
