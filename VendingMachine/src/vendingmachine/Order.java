
package vendingmachine;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jacek.malatynski
 */
public class Order {

    private ArrayList<Ticket> orderList = new ArrayList<>();
    private int totalPrice;
    
        public Integer getNumberOfTickets(){
            return orderList.size();
        }
        
        public void calculatePrice(int unitprice, int amount) {
            totalPrice = totalPrice + (unitprice * amount);
        }
        
        public Integer getCurrentTotalPrice(){
            return totalPrice;
        }
        
        public void composeOrder(){
              
            Scanner inString = new Scanner(System.in);
            Scanner tickets = new Scanner(System.in);
            int numberOfTickets;
            String choice;
            Ticket zone1 = new Zone1();
            Ticket zone2 = new Zone2();
            Ticket zone3 = new Zone3();

            boolean activeShopping = true;

            while (activeShopping) {
                System.out.println();
                System.out.println("Good morning, please follow instructions on screen.");
                System.out.println("Select ticket to issue\n"
                               + "\n1 - Zone 1 ticket, price: " + (zone1.getUnitCost() / 100.0)
                               + "\n2 - Zone 2 ticket, price: " + (zone2.getUnitCost() / 100.0)
                               + "\n3 - Zone 2 ticket, price: " + (zone3.getUnitCost() / 100.0)
                              );        
                System.out.println("--------------------");
                
                Scanner in = new Scanner(System.in);
                int input = in.nextInt();

                switch (input) {
                    case 1:
                        System.out.println("how many tickets");
                        numberOfTickets = tickets.nextInt();
                        createOrder(zone1, numberOfTickets);
                        calculatePrice(zone1.getUnitCost(), numberOfTickets);
                        System.out.println("continue shopping yes/no?");
                        choice = inString.next();
                        if (choice.equals("yes")) {
                            activeShopping = true;
                            //input = 0;
                            } else {
                                    activeShopping = false;
                                    break;
                                    }
                        break;    

                    case 2:
                        System.out.println("how many tickets");
                        numberOfTickets = tickets.nextInt();
                        createOrder(zone2, numberOfTickets);
                        calculatePrice(zone2.getUnitCost(), numberOfTickets);
                        System.out.println("continue shopping yes/no?");
                        choice = inString.next();
                        if (choice.equals("yes")) {
                            activeShopping = true;
                            } else {
                                    activeShopping = false;
                                    break;
                                    }
                        break;

                    case 3:
                        System.out.println("how many tickets");
                        numberOfTickets = tickets.nextInt();
                        createOrder(zone3, numberOfTickets);
                        calculatePrice(zone3.getUnitCost(), numberOfTickets);

                        System.out.println("continue shopping yes/no?");
                        choice = inString.next();
                        if (choice.equals("yes")) {
                            activeShopping = true;
                            //input = 0;
                            } else {
                                    activeShopping = false;
                                    break;
                                    }
                        break;
                }            
            }
        }
    
        public void createOrder(Ticket type, int increment) {
           for (int i = 0 ; i < increment ; i ++) {
           orderList.add(type);        
           }
    
        }
    
        public ArrayList getOrder(){
            return orderList;
        }
}