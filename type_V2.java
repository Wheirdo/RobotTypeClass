import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;
public class type_V2{
    static delay d = new delay();
    public static void main() throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = "";

        fillKeyEvents();

        System.out.println("What would you like to type?");
        input = scan.nextLine();

        delay d = new delay();
        d.delay(3000);
        typeV2(input);
    }

    /**
     * This is the 2nd iteration of the type class, and a copy of type2. See version 1 for a general explanation
     * 0123456789!@#$%^&*()-_=+[]{};:,<.>?"'/|\
     * the quick brown fox jumps over a lazy dog
     * 
     * The biggest change to V2 is instead of an if statements for every special character, it adds them all to an array (called keys) and reads from that instead
     * Pros: This makes the type class (and the whole program) much easier to read, and shortens the total line count
     * Cons: the array keys is a complete mess and requires 3 new methods to function. Adding support for a new charcter is also much harder
     * keys is far to messy for me to be satisfied with this soultion.
     */
    public static void typeV2(String text) throws Exception{
        Robot robot = new Robot();
        robot.setAutoDelay(5);

        char letter = 'a';
        int press = 0;
        int number = -1;
        String word = "    ";
        boolean shift = false;

        String [] keys = fillKeyEvents();      

        for (int x = 0; x < text.length(); x++) {

            letter = text.charAt(x);
            shift = false;
            press = -1;
            word = "";

            press = letter;
            if (press >= 65 && press <= 90) {//Uppercase Letters
                shift = true;
            }
            else if (press >= 97 && press <= 122) {//Lowercase Letters
                press -= 32;
            }   
            else {
                press = -1;
            }

            try {//Numbers
                number = Integer.parseInt(text.substring(x,x+1));
                press = number + 48;
            }
            catch (Exception e) {
                //
            }

            if (x + 5 < text.length() && text.substring(x,x+1).equals("/") && text.substring(x+5,x+6).equals("/")) {//special 4 letter characters
                word = text.substring(x+1,x+5);

                x += 5;
            }

            if (press == -1) {//Everything else
                press = indexToKeyEvent(keys,text.substring(x,x+1));
                shift = needsShift(keys,text.substring(x,x+1));
            }

            
            
            if (shift == true) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }            
            robot.keyPress(press);
            d.delay(5);
            robot.keyRelease(press);
            if (shift == true) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }            

        }
    }

    public static int indexToKeyEvent(String [] keys , String value) {

        int index = -1; //index of the key
        int x = -1; //the key
        for (int i = 0; i < keys.length; i++) {
            try {
                if (keys[i].equals(value)) {
                    x = i;
                }
            }
            catch (NullPointerException e) {
                //
            }

        }

        if ((x >= 56 && x <= 58) || x==68 || x==75 || (x >= 85 && x <= 88)) {//special 4 letter characters
            return x-48;
        }
        else if (x==0 ||( x>=12 && x<= 15) || x == 27 || x == 29 || (x >= 59 && x <= 61)) {//special characters
            return x+32;
        }
        else if ((x >= 30 && x <= 43) || x == 45 || x == 47 || (x >= 77 && x <= 79)) {//special characters that also need shift
            return x+14;
        }
        else if (x == 2) {return x+220;}//for the '
        else if (x == 3) {return x+219;}//for the "

        return -1;
    }

    public static boolean needsShift(String [] keys, String value) {
        int index = -1; //index of the key
        int x = -1; //the key
        for (int i = 0; i < keys.length; i++) {
            try {
                if (keys[i].equals(value)) {
                    x = i;
                }
            }
            catch (NullPointerException e) {
                //catchs half of the null space instead of crashing
            }
        }

        if ((x >= 56 && x <= 58) || x==68 || x==75 || (x >= 85 && x <= 88) || x==0 ||( x>=12 && x<= 15) || x == 27 || x == 29 || (x >= 59 && x <= 61) || x == 2) {
            return false;
        }
        else if ((x >= 30 && x <= 43) || x == 45 || x == 47 || (x >= 77 && x <= 79) || x == 3) {
            return true;
        }
        return false;
    }

    /**
     * Ok this method is nonsense but it works 
     * The problem with filling the array with keys is that there are 19 keys that have two values depending on if shift is held
     * Therefore, I need to have at least two sections with different code that a add or subtract from the index value
     * A then added a third for the 4 letter special guys because they wouldn't fit neaty anywhere else without making the array needlessly long
     * I then added the fourth and fifth, each of which contains 1 character, because the quotes being at the 200s was not ideal
     * (They also wouldn't fit in the 2 sections built for the shift and non shift because it would add even more wasted space)
     * 
     * Those 5 sections are why all of the if statements are so bonkers
     */
    public static String [] fillKeyEvents() {
        String [] answer = new String[89];

        //Keycode + 48 = Index
        answer[56] = "BACK";
        answer[57] = "TAB ";
        answer[58] = "ENTR";
        answer[68] = "CAPS";
        answer[75] = "ESC ";
        answer[85] = "LEFT";
        answer[86] = "UP  ";
        answer[87] = "RGHT";
        answer[88] = "DOWN";

        //Keycode - 32 = Index
        answer[0] = " ";
        answer[12] = ",";
        answer[13] = "-";
        answer[14] = ".";
        answer[15] = "/";
        answer[27] = ";";
        answer[29] = "=";
        answer[59] = "[";
        answer[60] = "\\";
        answer[61] = "]";

        //Keycode - 14 = Index
        //These requre pressing shift
        answer[30] = "<";
        answer[31] = "_";
        answer[32] = ">";
        answer[33] = "?";
        answer[34] = ")";
        answer[35] = "!";
        answer[36] = "@";
        answer[37] = "#";
        answer[38] = "$";
        answer[39] = "%";
        answer[40] = "^";
        answer[41] = "&";
        answer[42] = "*";
        answer[43] = "(";
        answer[45] = ":";
        answer[47] = "+";
        answer[77] = "{";
        answer[78] = "|";
        answer[79] = "}";

        //Keycode - 220 = Index
        answer[2] = "\'";
        //Keycode - 219 = Index (this one also needs shift)
        answer[3] = "\"";

        
        
        printKeys(answer);
        
        return answer;
    }

    /**
     * Extra method I added to print the keys array along with the keys
     * Also serves as a good visual aid to how nonsence the keys array is
     */    
    public static void printKeys(String [] keys) {
        int null_count = 0;
        
        for (int x = 0; x < keys.length; x++) {  
            if ((x >= 56 && x <= 58) || x==68 || x==75 || (x >= 85 && x <= 88)) {
                System.out.println((x-48)+" "+keys[x]);
            }
            else if (x==0 ||( x>=12 && x<= 15) || x == 27 || x == 29 || (x >= 59 && x <= 61)) {
                System.out.println((x+32)+" "+keys[x]);
            }
            else if ((x >= 30 && x <= 43) || x == 45 || x == 47 || (x >= 77 && x <= 79)) {
                System.out.println((x+14)+"(and shift) "+keys[x]);
            }
            else if (x == 2) {System.out.println((x+220)+" "+keys[x]);}
            else if (x == 3) {System.out.println((x+219)+"(and shift) "+keys[x]);}
            else {
                System.out.println("Else: "+x+" "+keys[x]);
                null_count += 1;
            } 
        }
        System.out.println("There are "+null_count+" wasted spaces");
    }

}