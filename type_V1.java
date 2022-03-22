import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;
public class type_V1{
    public static void main() throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println("What would you like to type?");
        input = scan.nextLine();

        delay d = new delay();
        d.delay(1000);
        
        typeV1(input);
    }

    /**
     * This is a copy of the type class, but with comments and explanations
     * 
     * Takes in a string and uses the Robot Class to type it out
     * This class needs to be thrown an Exception (either with 'throws Exception' or a try-catch)
     * Works for all (english) letters and these characters:
     * 0123456789!@#$%^&*()-_=+[]{};:,<.>?"'/\
     * The following keys can be pressed if the following syntax is entered
     *    /BACK/   Backspace
     *    /TAB /   Tab
     *    /ENTR/   Enter
     *    /ESC /   Escape
     *    /LEFT/   Left Arrow
     *    /UP  /   Up Arrow
     *    /RGHT/   Right Arrow
     *    /DOWN/   Down Arrow
     *    
     *    If you give the class a character not in the above list, it types a space
     *    A full list of all KeyEvent for typing can be found here: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
     *    
     *    
     *    This is version 1, and is fully functional, but very long. V2 seeks to be shorter
     */
    public static void typeV1(String text) throws Exception{
        Robot robot = new Robot();
        robot.setAutoDelay(5);//Can be decreased to increase speed, but if its too fast, characters will be missed
        char letter = 'a';  
        int press = -1; //press is the KeyEvent number;
        int number = -1; //used to check if the current letter in loop is a number 
        String word = "    "; //used for the special chacters (escape, backspace etc)
        boolean shift = false; //tracks if shift needs to be pressed

        for (int x = 0; x < text.length(); x++) {
            letter = text.charAt(x);
            shift = false;
            press = -1;
            word = "";

            press = letter;
            //turning a char into a number returns the ascii values, so these if statments check if the current character is a letter
            if (press >= 65 && press <= 90) {//65-90 are ascii values for Upper Case letters
                shift = true;
            }
            else if (press >= 97 && press <= 122) {//97-122 are lowercase in ascii
                press -= 32;
            }   
            else {//insures only character that are letters are changed
                press = -1;
            }

            try {//tries to make the current character a number
                number = Integer.parseInt(text.substring(x,x+1));
                press = number + 48;
            }
            catch (Exception e) {
                press = -1; //not required since press shouldn't be changed but helps for reading
            }

            if (press != -1) {//skip all the if statements if the current character is a letter or number
                //
            }
            //Special Keys
            //Syntax" /****/; must have 4 character inside even if word is only 3 or 2
            else if (x + 5 < text.length() && text.substring(x,x+1).equals("/") && text.substring(x+5,x+6).equals("/")) {//Special Keys
                word = text.substring(x+1,x+5);
                if (word.equals("BACK")) {//Backspace
                    press = 8;
                }
                else if (word.equals("TAB ")) {//Tab
                    press = 9;
                }
                else if (word.equals("ENTR")) {//Enter
                    press = 10;
                }
                else if (word.equals("CAPS")) {//Caps lock
                    press = 20;
                }
                else if (word.equals("ESC ")) {//Escape
                    press = 27;
                }
                else if (word.equals("LEFT")) {//Left Arrow
                    press = 37;
                }
                else if (word.equals("UP  ")) {//Up Arrow
                    press = 38;
                }
                else if (word.equals("RGHT")) {//Right Arrow
                    press = 39;
                }
                else if (word.equals("DOWN")) {//Down Arrow
                    press = 40;
                }

                x += 5; //skips foward 5 to insure for loop doesnt get off track

            }
            else if (letter == ' ') {//Space
                press = 32;
            }
            else if (letter == ',') {//Comma
                press = 44;
            }
            else if (letter == '<') {//Lesser than
                press = 44;
                shift = true;
            }
            else if (letter == '-') {//Dash
                press = 45;
            }
            else if (letter == '_') {//Underscore
                press = 45;
                shift = true;
            }
            else if (letter == '.') {//period
                press = 46;
            }
            else if (letter == '>') {//Greater than
                press = 46;
                shift = true;
            }
            else if (letter == '/') {//Fowardslash
                press = 47;
            }
            else if (letter == '?') {//Question Mark
                press = 47;
                shift = true;
            }
            else if (letter == ')') {//Left Parthensis
                press = 48;
                shift = true;
            }
            else if (letter == '!') {//Explination Mark
                press = 49;
                shift = true;
            }
            else if (letter == '@') {//At
                press = 50;
                shift = true;
            }
            else if (letter == '#') {//Hashtag or Number
                press = 51;
                shift = true;
            }
            else if (letter == '$') {//Dollar Sign
                press = 52;
                shift = true;
            }
            else if (letter == '%') {//Percent or Module
                press = 53;
                shift = true;
            }
            else if (letter == '^') {//Carrot
                press = 54;
                shift = true;
            }
            else if (letter == '&') {//Ambersand
                press = 55;
                shift = true;
            }
            else if (letter == '*') {//Star
                press = 56;
                shift = true;
            }
            else if (letter == '(') {//Right Parthensis
                press = 57;
                shift = true;
            }
            else if (letter == ';') {//Semicolon
                press = 59;
            }
            else if (letter == ':') {//Colon
                press = 59;
                shift = true;
            }
            else if (letter == '=') {//Equal Sign
                press = 61;
            }
            else if (letter == '+') {//Plus Sign
                press = 61;
                shift = true;
            }
            else if (letter == '[') {//Left Square Bracket
                press = 91;
            }
            else if (letter == '{') {//Left Curly Bracket
                press = 91;
                shift = true;
            }
            else if (letter == '\\') {//Backslash    
                press = 92;
            }
            else if (letter == ']') {//Right Square Bracket
                press = 93;
            }
            else if (letter == '}') {//Right Curly Bracket
                press = 93;
                shift = true;
            }
            else if (text.substring(x,x+1).equals("'")) {//Single Quote; substring used because ''' doesn't work
                press = 222;
            }
            else if (letter == '"') {//Double Quote
                press = 222;
                shift = true;
            }
            else if (press == -1) {//Uses space if no other character is understood
                press = 32;
            }

            if (shift == true) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }            
            robot.keyPress(press);
            //delay(5) can be added here to increase speed (by decreaseing autoDelay). See delay method below
            robot.keyRelease(press);
            if (shift == true) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }            

        }
    }
}