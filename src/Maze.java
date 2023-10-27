import java.util.*;
import java.io.*;

public class Maze {

    private int numRows, numCols;
    public Square[][] maze;
    
    public Maze()
    {
        numRows = 0;
        numCols = 0;
    }

    public boolean loadMaze(String fname) throws IOException
    {
        // Account for Errors, otherwise this works
       Scanner sc = new Scanner(new File(fname));
       numRows = sc.nextInt();
       numCols = sc.nextInt();
       maze = new Square[numRows][numCols];
       for(int i = 0; i < numRows; i++)
       {
        for(int j = 0; j < numCols; j++)
        {
            maze[i][j] = new Square(i,j,sc.nextInt());
        }
       }
       return true;
    }

    ArrayList<Square> getNeighbors(Square sq)
    {
        ArrayList<Square> neighbors = new ArrayList<>();
        if(sq.getRow()-1 > 0 && maze[sq.getRow()-1][sq.getCol()] != null)
        {
            neighbors.add(maze[sq.getRow()-1][sq.getCol()]);
        }
        if(sq.getCol()+1 < numCols && maze[sq.getRow()][sq.getCol()+1] != null)
        {
            neighbors.add(maze[sq.getRow()][sq.getCol()+1]);
        }
        if(sq.getRow()+1 < numRows && maze[sq.getRow()+1][sq.getCol()] != null)
        {
            neighbors.add(maze[sq.getRow()+1][sq.getCol()]);
        }
        if(sq.getCol()-1 > 0 && maze[sq.getRow()][sq.getCol()-1] != null)
        {
            neighbors.add(maze[sq.getRow()][sq.getCol()-1]);
        }
        return neighbors;
    }

    public Square getStart()
    {
        Square start = null;
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numCols; j++)
            {
                if(maze[i][j].getType() == 2)
                    start = maze[i][j];
            }
        }
        return start;
    }

    public Square getFinish()
    {
        Square end = null;
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numCols; j++)
            {
                if(maze[i][j].getType() == 3)
                    end = maze[i][j];
            }
        }
        return end;
    }

    public void reset()
    {

    }

    public String toString(){}

}
