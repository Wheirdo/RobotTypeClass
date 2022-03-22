import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
public class type_V3{
    public static void main() throws Exception {
        print p = new print();
        Scanner scan = new Scanner(System.in);
        String input = "";

        System.out.println("What would you like to type?");
        input = scan.nextLine();

        delay d = new delay();
        d.delay(3000);
        while (true) {
            typeV3("d /ENTR/");
        }
    }

    /** fuck off /ENTR/
     * This is the 3rd iteration of the type class and a copy of type3. See version 1 for a general explanation
     * 0123456789!@#$%^&*()-_=+[]{};:,<.>?"'/|\
     * the quick brown fox jumps over a lazy dog
     * THE QUICK BROWN FOX JUMPS OVER A LAZY DOG
     * words/ENTR/more words/ENTR//TAB /even more words/LEFT//RGHT//UP  //DOWN//ESC /
     * 
     * V3 reads from a cvs file (named KeyEvents) with all the numbers and characters, and loops through that file every time
     * Pros: This is the shortest version, and easiest to read, with only 2 sections for parsing words
     * Cons: You need the file for it to work, it might be slower, and the comma doesn't work and must be hardcoded
     * 
     * I really like this solution (and don't think I can make it any shorter), I want the final solution not to rely on a file
     */
    public static void typeV3(String text) throws Exception{
        print p = new print();
        Robot robot = new Robot();
        robot.setAutoDelay(50);

        char letter = 'a';
        int press = 0;
        int number = -1;
        String word = "";
        boolean shift = false;

        List<String []> keys = new ArrayList<String []>();//stores keys from sheet. The syntax is number,character,2nd character (that needs shift)
        keys = readFile(); 

        for (int x = 0; x < text.length(); x++) {//loops through entire input
            shift = false;
            press = -1;
            word = "";

            for (int i = 0; i < keys.size(); i++) {//loops through keys looking for a match
                if (x + 5 < text.length() && text.substring(x,x+1).equals("/") && text.substring(x+5,x+6).equals("/")) {//block for /****/ commands
                    word = text.substring(x+1,x+5);
                    if (keys.get(i)[1].equals(word)) {
                        press = Integer.parseInt(keys.get(i)[0]);
                        shift = false;
                        x += 5;
                        break;
                    }
                }

                if (keys.get(i)[1].equals(text.substring(x,x+1))) {//block for numbers, letters, characters that don't need shift
                    press = Integer.parseInt(keys.get(i)[0]);
                    shift = false;
                    break;
                }
                else if (keys.get(i).length > 2 && keys.get(i)[2].equals(text.substring(x,x+1))) {//characters that do need shift
                    press = Integer.parseInt(keys.get(i)[0]);
                    shift = true;
                    break;
                } 

            }
            if (text.substring(x,x+1).equals(",")) {//because the file is comma delimited, I couldn't figure a way to get it to work, so the comma is hardcoded
                press = 44;
            }
            if (press == -1) {//defaults to space if an unknown charcater is given
                press = 32;
            }            

            
            if (shift == true) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }            
            robot.keyPress(press);
            robot.keyRelease(press);
            if (shift == true) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }            

        }
        //prints all of keys for debugging purposes; see print() for syntax
        //p.simplePrintln(keys);
    }

    public static List<String []> readFile() {
        List <String []> data = new ArrayList<String []>();
        String input = "";
        String [] info = new String[3];

        Scanner scanFile = null;
        try {
            scanFile = new Scanner(new File("KeyEvents.csv"));
        }
        catch (Exception err) {
            err.printStackTrace();
        }

        while (true) {
            try {
                input = scanFile.nextLine();
            }
            catch (java.util.NoSuchElementException e) {
                break;
            }
            info = input.split(",");
            data.add(info);
        }
        return data;
    }
}