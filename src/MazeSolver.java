import java.util.*;

public abstract class MazeSolver {
    
    protected static Maze maze;
    protected static Stack<Square> path;
    protected boolean finished = false;
    
    public MazeSolver(Maze maze){
        this.maze = maze;
        path = new Stack<>();
        path.push(maze.getStart());
    }

    abstract void makeEmpty();
    
    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public boolean isSolved(){
        return finished;
    }

    public String getPath(){
        if (isEmpty()){
            return "There is no solution path";
        } else {

            Square current = maze.getFinish();

            do {
                path.push(current);
                current = current.getPrevious();
            } while (!current.equals(maze.getStart()));

            StringBuilder sb = new StringBuilder();
            while (!path.empty()) {
               sb.append("[" + path.pop().getRow() + ", " + path.pop().getCol() + "]\n");
            }
            String toReturn = new String(sb);
            return toReturn;
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
                
            }
            else {
                ArrayList<Square> neighbors = maze.getNeighbors(next);
                
                for (Square s : neighbors){
                    if (s.getType() != 1) {
                        add(s);
                        s.setPrevious(next);
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
