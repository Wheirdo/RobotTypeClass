/** 
 * Take in a number in milliseconds, and pauses for that period of time
 */
public class delay{
    
    public static void main() {
        
    }
    
    public static void delay(int x) {
        try{
            Thread.sleep(x);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public static void delayMin(int x) {
        x = x*60000;
        try{
            Thread.sleep(x);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
