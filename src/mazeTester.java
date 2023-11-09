import java.util.ArrayList;
import java.io.*;

public class mazeTester {
    static Maze m = new Maze();

    public static void main(String[] args){

        //test the loading of the maze
        try{
            System.out.println(loadMazeError());
            System.out.println(loadMazeTest());
        } catch (Exception e){}

        System.out.println();

        //test the getNeighbors for a corner square
        ArrayList<Square> neighborsTest = new ArrayList<>();
        neighborsTest = getNeighborsCorners();

        //print to check
        for (Square s : neighborsTest){
            System.out.print(s);
        }

        //test the getNeighbors for an edge square
        System.out.println();
        neighborsTest = getNeighborsEdge();

        //print to check
        for (Square s : neighborsTest){
            System.out.print(s);
        }

        //test the getNeighbors for a center square
        System.out.println();
        neighborsTest = getNeighborsMiddle();

        //print to check
        for (Square s : neighborsTest){
            System.out.print(s);
        }

        //test print the maze
        System.out.println();
        System.out.println(toStringTest());

        //check to ensure getStart returns the correct square
        System.out.println();
        System.out.println(getStartTest());

        //check to ensure getFinish returns the correct square
        System.out.println();
        System.out.println(getFinishTest());

    }

    static private boolean loadMazeError() throws IOException{
        return m.loadMaze("notafile");
    }

    static private boolean loadMazeTest() throws IOException{
        return m.loadMaze("src//maze-2");
    }

    static private ArrayList<Square> getNeighborsCorners(){
        return m.getNeighbors(m.maze[0][0]);
    }

    static private ArrayList<Square> getNeighborsEdge(){
        return m.getNeighbors(m.maze[5][0]);
    }

    static private ArrayList<Square> getNeighborsMiddle(){
        return m.getNeighbors(m.maze[1][1]);
    }

    static private String toStringTest(){
        return m.toString();
    }

    static private Square getStartTest(){
        return m.getStart();
    }

    static private Square getFinishTest(){
        return m.getFinish();
    }
}
