import java.util.*;

public class Square {

    //declare instance variables
    private int row, col, type;
    public boolean explored, onPath, inList;
    private Square previous;

    /**
     * Constructor takes a row, column, and type
     */
    public Square (int row, int col, int type){
        this.row = row;
        this.col = col;
        this.type = type;
        this.explored = false;
        this.onPath = false;
        this.inList = false;
    }

    /**
     * @return int the square's row
     */
    public int getRow(){
        return row;
    }

    /**
     * @return int the square's column
     */
    public int getCol(){
        return col;
    }

    /**
     * @return int the square's type
     */
    public int getType(){
        return type;
    }

    /**
     * resets all of the state booleans
     */
    public void reset()
    {
        explored = false;
        onPath = false;
        inList = false;
    }

    /**
     * sets the explored state to true
     */
    public void explore(){
        explored = true;
    }

    /**
     * @return boolean the square's explored state
     */
    public boolean isExplored(){
        return explored;
    }

    /**
     * set the inList state to true
     */
    public void enlist(){
        inList = true;
    }

    /**
     * set the onPath state to true
     */
    public void onPath(){
        onPath = true;
    }

    /**
     * links a square to the one which added it to worklist
     * @param square S
     */
    public void setPrevious(Square s){
        previous = s;
    }

    /**
     * @return Square the linked previous square
     */
    public Square getPrevious(){
        return previous;
    }

    /**
     * @param Square s
     * @return boolean if the square's row, column, and type match
     */
    public boolean equals(Square s){
        return (this.getCol() == s.getCol() && this.getRow() == s.getRow() && this.getType() == s.getType());
    }

    /**
     * @return String a character to represent the square's type
     */
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
