import java.util.*;

public class Square {

    private int row, col, type;
    private boolean explored, onPath, inList;
    private Square previous;

    public Square (int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
        this.explored = false;
        this.onPath = false;
        this.inList = false;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getType(){
        return type;
    }

    public void reset()
    {
        explored = false;
        onPath = false;
        inList = false;
    }

    public void explore(){
        explored = true;
    }

    public boolean isExplored(){
        return explored;
    }

    public void enlist(){
        inList = true;
    }

    public void onPath(){
        onPath = true;
    }

    public void setPrevious(Square s){
        previous = s;
    }

    public Square getPrevious(){
        return previous;
    }

    public boolean equals(Square s){
        return (this.getCol() == s.getCol() && this.getRow() == s.getRow() && this.getType() == s.getType());
    }

    public String toString(){
        switch (type){
            case 0:

                if (onPath){
                    return "x ";
                } 

                if (explored){
                    return " . ";
                }

                if  (inList){
                    return "o ";
                }

                return "_ ";
            case 1:
                return "# ";
            case 2:
                return "S ";
            case 3:
                return "E ";
            default:
                return "There is something wrong with this square (" + getRow() + ", " + getCol() + ")";
        }
    }
}
