import java.util.*;

public class SquareTester {
    

    public static void main (String[] args){
        //declare and set 5 different squares to test 5 cases
        Square emptysquare;
        Square wallsquare;
        Square startsquare;
        Square exitsquare;
        Square errorsquare;

        emptysquare = new Square(14, 13, 0);
        wallsquare = new Square(5, 10, 1);
        startsquare = new Square(2, 1, 2);
        exitsquare = new Square(0, 0, 3);
        errorsquare = new Square(8, 2, 4);

        //test the toString which will test all other methods as well
        System.out.println(emptysquare);
        System.out.println(wallsquare);
        System.out.println(startsquare);
        System.out.println(exitsquare);
        System.out.println(errorsquare);

    }
}
