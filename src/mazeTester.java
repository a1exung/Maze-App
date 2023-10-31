import java.util.ArrayList;
import java.io.*;

public class mazeTester {
    static Maze m = new Maze();

    public static void main(String[] args){

        try{
            System.out.println(loadMazeError());
            System.out.println(loadMazeTest());
        } catch (Exception e){}

        System.out.println();

        ArrayList<Square> neighborsTest = new ArrayList<>();
        neighborsTest = getNeighborsCorners();

        for (Square s : neighborsTest){
            System.out.print(s);
        }

        System.out.println();
        neighborsTest = getNeighborsEdge();

        for (Square s : neighborsTest){
            System.out.print(s);
        }

        System.out.println();
        neighborsTest = getNeighborsMiddle();

        for (Square s : neighborsTest){
            System.out.print(s);
        }

        System.out.println();
        System.out.println(toStringTest());

        System.out.println();
        System.out.println(getStartTest());

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
        return m.getNeighbors(m.maze[0][1]);
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
