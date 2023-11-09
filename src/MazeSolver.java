import java.util.*;

public abstract class MazeSolver {
    
    protected static Maze maze;
    protected static Stack<Square> path;
    protected boolean finished = false, last = false;
    
    public MazeSolver(Maze maze){
        this.maze = maze;
        path = new Stack<>();
    }

    abstract void makeEmpty();
    
    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public boolean isSolved(){
        return finished;
    }

    public String getPath(){
        if (isEmpty() && !last){
            return "There is no solution path";
        } else {

            Square current = maze.getFinish();
            String path = "[" + current.getRow() + ", " + current.getCol() + "]";


            //StringBuilder sb = new StringBuilder();
            while (current.getPrevious() != null) {
                current = current.getPrevious();
                current.onPath();
                //sb.append("[" + sq.getRow() + ", " + sq.getCol() + "]\n");
                path = "[" + current.getRow() + ", " + current.getCol() + "] " + path;
            }
            //String toReturn = new String(sb);
            return "The solution path is: " + path;
        }
    }

    public Square step(){
        if (isEmpty()){
            finished = true;
            return null;
            
        }
        else {
            Square next = next();

            if (next.getType() == 3){
                finished = true;
                last = true;
                return next;
            }
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
     * 
     */
    public void solve(){
        while (!isSolved()){
            step();
        }
    }
}
