public class MazeSolverQueue extends MazeSolver
{
    static MyQueue worklist; // Iniitializes the worklist as a Queue

    public MazeSolverQueue(Maze maze)
    {
        super(maze); // Uses the parent constructor to inherit all methods

        makeEmpty(); // Initially make the list empty.
        add(maze.getStart()); // Adds the start.
        maze.getStart().setPrevious(null); // Sets the previous of the start to null.
    }

    // Makes the worklist empty.
    public void makeEmpty()
    {
        worklist = new MyQueue(); 
    }

    // Checks if the worklist is empty.
    public boolean isEmpty()
    {
        return worklist.isEmpty();
    }

    // checks if the worklist already contains the square. If it doesn't and if the square isn't explored, add it to the worklist.
    public void add(Square sq)
    {
        boolean isPresent = false;
        isPresent = worklist.contains(sq);
        if (!isPresent && !sq.isExplored()) worklist.enqueue(sq);
    }

    // removes a square off the queue and returns it.
    public Square next()
    {
        return (Square) worklist.dequeue();
    }
}
