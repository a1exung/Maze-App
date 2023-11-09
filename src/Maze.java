import java.util.*;
import java.io.*;

public class Maze {

    //declare instance variables
    private int numRows, numCols;
    public Square[][] maze;

    //default the Maze to have zero columns and rows
    public Maze()
    {
        numRows = 0;
        numCols = 0;
    }

    /**
     * @param String file name
     * @return boolean success of maze load
     */
    public boolean loadMaze(String fname)
    {
    
        //try catch to find any file loading errors   
       try{ 
            Scanner sc = new Scanner(new File(fname));
            numRows = sc.nextInt();
            numCols = sc.nextInt();
            maze = new Square[numRows][numCols];

           //nested for loop to populate the Maze array
            for(int i = 0; i < numRows; i++)
            {
                for(int j = 0; j < numCols; j++)
                {
                    maze[i][j] = new Square(i,j,sc.nextInt());
                }
            }
            return true;
        } catch (Exception e) {
           //print error message if file is not loaded
            System.out.println("File could not be read");
            return false;
        }
    }

    /**
     * @return ArrayList each of the squares neighbors
     */
    public ArrayList<Square> getNeighbors(Square sq)
    {
        ArrayList<Square> neighbors = new ArrayList<>();
        //add the above
        if(sq.getRow()-1 >= 0 && maze[sq.getRow()-1][sq.getCol()] != null)
        {
            neighbors.add(maze[sq.getRow()-1][sq.getCol()]);
        }
        //add the right
        if(sq.getCol()+1 < numCols && maze[sq.getRow()][sq.getCol()+1] != null)
        {
            neighbors.add(maze[sq.getRow()][sq.getCol()+1]);
        }
        //add the below
        if(sq.getRow()+1 < numRows && maze[sq.getRow()+1][sq.getCol()] != null)
        {
            neighbors.add(maze[sq.getRow()+1][sq.getCol()]);
        }
        //add the left
        if(sq.getCol()-1 >= 0 && maze[sq.getRow()][sq.getCol()-1] != null)
        {
            neighbors.add(maze[sq.getRow()][sq.getCol()-1]);
        }
        
        return neighbors;
    }

    /**
     * @return Square the maze's start square
     */
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

    /**
     * @return Square the maze's exit square
     */
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

    /**
     * reset all Squares in the maze
     */
    public void reset()
    {
        for (Square[] mazes : maze){
            for (Square s : mazes){
                s.reset();
            }
        }
    }

    /**
     * print out each square in the maze
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for( int i=0; i < maze.length; i++ )
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                sb.append(maze[i][j]);
            }

            sb.append("\n");
        }
        String s = new String(sb);
        return s;
    }

}
