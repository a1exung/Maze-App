import java.util.*;

public class Square {

    private int row, col, type;
    private boolean explored;
    private Square previous;

    public Square (int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
        this.explored = false;
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
        
    }

    public void explore(){
        explored = true;
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
