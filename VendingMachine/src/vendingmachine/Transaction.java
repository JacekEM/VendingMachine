
package vendingmachine;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jacek.malatynski
 */
public class Transaction {
    
    private static Transaction ui = new Transaction();
    private Order order = new Order();
    private Buffer buffer = new Buffer();
    
    
    protected void makeTransaction() {
        
      order.composeOrder();
      if (order.getNumberOfTickets() > buffer.getPaperUnitsLeft()) {
        System.out.println("sorry bro, not enough tickets left\n"
                           + "max number of tickets is "
                           + buffer.getPaperUnitsLeft());
      } else {
        
        System.out.println("Please insert "  + (order.getCurrentTotalPrice() / 100.0 ) + " zl\n"
                           + "to cancel, please press cancel button");
        System.out.println("Accepted coins/notes are: ");
        System.out.println(buffer.getAcceptedValues());
        
        Scanner in = new Scanner(System.in);  

        while (buffer.getInsertedCash() < order.getCurrentTotalPrice()) {
          String coin = in.next();
          if (coin.equals("cancel")) {
            buffer.returnMoney(buffer.getMoneyBuffer());
            break;
          } else {
            buffer.insertMoney(coin);
            buffer.countInsertedMoney();
            System.out.println("inserted cash:" + (buffer.getInsertedCash() / 100.0) + " zl" );
            }

        }
      }
    
        if (buffer.getInsertedCash() >= order.getCurrentTotalPrice()
            ){
        sellTickets();
        }
    }
    
    public void sellTickets(){
        
      Integer change = overPaid(buffer.getInsertedCash(), order.getCurrentTotalPrice() );
      printTickets(order.getOrder());
      buffer.returnMoney(buffer.calculateChange(change));
      buffer.zeroMoneyBuffer();
      System.out.flush();
      
    }
    
    public void printTickets(ArrayList<Ticket> toPrint){
           for ( int i = 0 ; i < toPrint.size() ; i++ ) {
           toPrint.get(i).issueTicket();
       }
        
    }
        public static Integer overPaid(Integer a, Integer b){

       Integer change = a - b;

        return change;
    }
}
