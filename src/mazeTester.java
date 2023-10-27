import java.util.ArrayList;

public class mazeTester {
    static Maze maze = new Maze();

    public static void main(String[] args){
        System.out.println(loadMazeError());
        System.out.println(loadMazeTest());

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

    static private boolean loadMazeError(){
        return maze.loadMaze("notafile");
    }

    static private boolean loadMazeTest(){
        return maze.loadMaze("src//maze-2");
    }

    static private ArrayList<Square> getNeighborsCorners(){
        return maze.getSquares(maze.squares[0][0]);
    }

    static private ArrayList<Square> getNeighborsEdge(){
        return maze.getSquares(maze.squares[0][1]);
    }

    static private ArrayList<Square> getNeighborsMiddle(){
        return maze.getSquares(maze.squares[1][1]);
    }

    static private String toStringTest(){
        return maze.toString();
    }

    static private Square getStartTest(){
        return maze.getStart();
    }

    static private Square getFinishTest(){
        return maze.getFinish();
    }
}
