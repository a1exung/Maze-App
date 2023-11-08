public class MazeSolverQueue extends MazeSolver
{
    static MyQueue worklist;

    public MazeSolverQueue(Maze maze)
    {
        super(maze);

        makeEmpty();
        add(maze.getStart());
        maze.getStart().setPrevious(null);
    }

    public void makeEmpty()
    {
        worklist = new MyQueue();
    }

    public boolean isEmpty()
    {
        return worklist.isEmpty();
    }

    public void add(Square sq)
    {
        boolean isPresent = false;
        isPresent = worklist.contains(sq);
        if (!isPresent && !sq.isExplored()) worklist.enqueue(sq);
    }

    public Square next()
    {
        return (Square) worklist.dequeue();
    }
}
