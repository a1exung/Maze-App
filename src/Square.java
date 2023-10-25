import java.util.*;

public class Square {

    private int row, col, type;

    public Square (int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
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

    public String toString(){
        switch (type){
            case 0:
                return "_";
            case 1:
                return "#";
            case 2:
                return "S";
            case 3:
                return "E";
            default:
                return "There is something wrong with this square";
        }
    }
}
