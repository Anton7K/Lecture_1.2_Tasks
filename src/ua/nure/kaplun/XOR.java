package ua.nure.kaplun;

/**
 * Created by Anton on 19.02.2017.
 */
public class XOR {
    public static boolean xor(boolean x, boolean y){
        boolean isAllTrue = ((x||y)&&(x&&y));
        boolean isAllFalse = !(x||y);
        return !(isAllFalse||isAllTrue);
    }

    public static void main(String[] args){
        System.out.println("1:0 => " + xor(true, false));
        System.out.println("0:1 => " + xor(false, true));
        System.out.println("1:1 => " + xor(true, true));
        System.out.println("0:0 => " + xor(false, false));
    }
}
