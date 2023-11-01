import java.util.*;

public abstract class MazeSolver {
    
    protected static Maze maze;
    protected static Stack<Square> path;
    protected boolean finished = false;
    
    public MazeSolver(Maze maze){
        this.maze = maze;
        path = new Stack<>();
    }

    abstract void makeEmpty();
    
    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    public boolean isSolved(){
        return (isEmpty() || finished);
    }

    public String getPath(){
        if (path.empty()){
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
            add(maze.getStart());
            return maze.getStart();
        }
        else {
            Square next = next();
            if (next.getType() == 3){
                finished = true;
                return next;
            }
            else {
                ArrayList<Square> neighbors = maze.getNeighbors(next);
                for (Square s : neighbors){
                    if (s.getType() != 1) add(s);
                }
            }
        }

    }

    public void solve(){

    }
}
