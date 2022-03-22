import java.util.List;
import java.util.ArrayList;
/**
 * print seeks to emulate the simplicity that print() has in python, and improving it so println() works
 * currently works with strings, ints, floats, booleans, arrays of all of those types, and lists of string arrays 
 * also includes a println() for hitting enter
 * 
 * 
 */

public class print{
    public static void main() {

    }
    
    /**
     * No arguements; used just for the enter
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Strings
     */
    public static void print(String text) {
        System.out.print(text);
    }
    public static void println(String text) {
        System.out.println(text);
    }

    /**
     * Integers
     */
    public static void print(int number) {
        System.out.print(number);
    }
    public static void println(int number) {
        System.out.println(number);
    }
    
    /**
     * Floats
     */
    public static void print(float number) {
        System.out.print(number);
    }
    public static void println(float number) {
        System.out.println(number);
    }
    
    /**
     * Booleans
     */
    public static void print(boolean bool) {
        System.out.print(bool);
    }
    public static void println(boolean bool) {
        System.out.println(bool);
    }
    

    /**
     * String arrays
     */
    public static void print(String [] text) {
        System.out.print("{");
        for (int x = 0; x < text.length; x++) { 
            System.out.print("\""+text[x]+"\"");
            if (x+1 < text.length) {System.out.print(",");}
            else {System.out.print("}");}
        }
    }
    public static void println(String [] text) {
        print(text);
        System.out.println();
    }
    /**
     * String arrays, but without the {} at the start and the "" between each word
     */
    public static void simplePrint(String [] text) {
        for (int x = 0; x < text.length; x++) { 
            System.out.print(text[x]);
            if (x+1 < text.length) {System.out.print(",");}
        }
    }
    public static void simplePrintln(String [] text) {
        simplePrint(text);
        System.out.println();
    }
    
    /**
     * Integer arrays
     */
    public static void print(int [] numbers) {
        System.out.print("{");
        for (int x = 0; x < numbers.length; x++) { 
            System.out.print(numbers[x]);
            if (x+1 < numbers.length) {System.out.print(",");}
            else {System.out.print("}");}
        }
    }
    public static void println(int [] numbers) {
        print(numbers);
        System.out.println();
    }
    
    /**
     * Float arrays
     */
    public static void print(float [] numbers) {
        System.out.print("{");
        for (int x = 0; x < numbers.length; x++) { 
            System.out.print(numbers[x]);
            if (x+1 < numbers.length) {System.out.print(",");}
            else {System.out.print("}");}
        }
    }
    public static void println(float [] numbers) {
        print(numbers);
        System.out.println();
    }
    
    /**
     * Boolean arrays
     */
    public static void print(boolean [] bools) {
        System.out.print("{");
        for (int x = 0; x < bools.length; x++) { 
            System.out.print(bools[x]);
            if (x+1 < bools.length) {System.out.print(",");}
            else {System.out.print("}");}
        }
    }
    public static void println(boolean [] bools) {
        print(bools);
        System.out.println();
    }

    
    /**
     * List of String arrays, along with a simple version
     */
    public static void print(List<String []> text) {
        System.out.print("[");
        for (int x = 0; x < text.size(); x++) {
            print(text.get(x));
            if (x+1 < text.size()) {System.out.println(",");}
        }
        System.out.print("]");
    }
    public static void println(List<String []> text) {
        print(text);
        System.out.println();
    }
    public static void simplePrint(List<String []> text) {
        System.out.print("[");
        for (int x = 0; x < text.size(); x++) {
            simplePrint(text.get(x));
            if (x+1 < text.size()) {System.out.println(",");}
        }
        System.out.print("]");
    }
    public static void simplePrintln(List<String []> text) {
        simplePrint(text);
        System.out.println();
    }
    

}





