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
        if (path.peek().getType() != 3){
            return "There is no solution path";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Square s : path){
               sb.append("[" + s.getRow() + ", " + s.getCol() + "]\n");
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
            while (!path.peek().equals(next.getPrevious())){
                path.pop();

            }
            
            path.push(next);

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
