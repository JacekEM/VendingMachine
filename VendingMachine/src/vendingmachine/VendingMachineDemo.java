
package vendingmachine;


public class VendingMachineDemo {
    
    
    public static void main(String[] args) {
        
        Transaction run = new Transaction();
        boolean a = true;
        while (a) {
            run.makeTransaction();
           // a = false;
        }
    }
    
}
