
package vendingmachine;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author jacek.malatynski
 */
public class Buffer {
    
    String [] acceptedValues = {"gr10", "gr20", "gr50", "zl1", "zl2", "zl5", "zl10", "zl20"};

    protected ArrayList<String> moneyBuffer = new ArrayList<>();

    private Integer insertedCash = 0;    
    private Integer paperUnitsLeft = 100;

    private Integer gr10 = 10;
    private Integer gr20 = 20;
    private Integer gr50 = 15;
    private Integer zl1 = 40;
    private Integer zl2 = 30;
    private Integer zl5 = 20;
    private Integer zl10 = 0;
    private Integer zl20 = 2;

    public String getAcceptedValues() {
        return Arrays.toString(acceptedValues);
    }
    
    public ArrayList<String> getMoneyBuffer() {
        return moneyBuffer;
    }
    
    public Integer getPaperUnitsLeft() {
        return paperUnitsLeft;
    }

    public Integer getGr10() {
        return gr10;
    }

    public Integer getGr20() {
        return gr20;
    }

    public Integer getGr50() {
        return gr50;
    }

    public Integer getZl1() {
        return zl1;
    }

    public Integer getZl2() {
        return zl2;
    }

    public Integer getZl5() {
        return zl5;
    }

    public Integer getZl10() {
        return zl10;
    }

    public Integer getZl20() {
        return zl20;
    }
   
    public void setPaperUnitsLeft(Integer paperUnits) {
        this.paperUnitsLeft = paperUnitsLeft + paperUnits;
    }
//    public Double getAvailableMoney() {
//        return gr10 + gr20 + gr50 + zl1 + zl2 + zl5 + zl10 + zl20;
//    }
    
    public void insertMoney(String coin) {
        

        moneyBuffer.add(coin);
        
    }
    
    public void returnMoney(ArrayList<String> moneyBuffer){
       for (String i: moneyBuffer) {
           if (i.equals("gr10")) {
                System.out.println("returning " + i);
                gr10 -= 1;
            }
            if (i.equals("gr20")) {
                System.out.println("returning " + i);
                gr20 -= 1;
            }
            if (i.equals("gr50")) {
                System.out.println("returning " + i);
                gr50 -= 1;
            }
            if (i.equals("zl1")) {
                System.out.println("returning " + i);
                zl1 -= 1;
            }
            if (i.equals("zl2")) {
                System.out.println("returning " + i);
                zl2 -= 1;
            }
            if (i.equals("zl5")) {
                System.out.println("returning " + i);
                zl5 -= 1;
            }
            if (i.equals("zl10")) {
                System.out.println("returning " + i);
                zl10 -= 1;
            }
            if (i.equals("zl20")) {
                System.out.println("returning " + i);
                zl20 -= 1;
            }  
       }
    }
    
    public void zeroMoneyBuffer(){
        insertedCash = 0;
    }
    
    public Integer getInsertedCash(){
        return insertedCash;
    }
    
    public void countInsertedMoney() {
        for (String i: moneyBuffer) {
            if (i.equals("gr10")) {
                insertedCash += 10;
                gr10 += 1;
            }
            if (i.equals("gr20")) {
                insertedCash += 20;
                gr20 += 1;
            }
            if (i.equals("gr50")) {
                insertedCash += 50;
                gr50 += 1;
            }
            if (i.equals("zl1")) {
                insertedCash += 100;
                zl1 += 1;
            }
            if (i.equals("zl2")) {
                insertedCash += 200;
                zl2 += 1;
            }
            if (i.equals("zl5")) {
                insertedCash += 500;
                zl5 += 1;
            }
            if (i.equals("zl10")) {
                insertedCash += 1000;
                zl10 += 1;
            }
            if (i.equals("zl20")) {
                insertedCash += 2000;
                zl20 += 1;
            }   
        }        

    }
    
    public ArrayList<String> calculateChange(Integer change){
         ArrayList<String> changeMoney = new ArrayList<>();
         Integer count = 0;
         Integer left = 0;

         count = change / 1000;
         left = change % 1000;
         if (count > 0 && getZl10() > count){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("zl10");
             }
            change = left;
         }

         count = change / 500;
         left = change % 500;
         if (count > 0&& getZl5() > count ){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("zl5");
             }
            change = left;
         }

         count = change / 200;
         left = change % 200;
         if (count > 0 && getZl2() > count){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("zl2");
             }
            change = left;
         }

         count = change / 100;
         left = change % 100;
         if (count > 0 && getZl1() > count){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("zl1");
             }
            change = left;
         }

         count = change / 50;
         left = change % 50;
         if (count > 0 && getGr50() > count){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("gr50");
             }
            change = left;
         }

         count = change / 20;
         left = change % 20;
         if (count > 0 && getGr20() > count ){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("gr20");
             }
            change = left;
         }         

         count = change / 10;
         if (count > 0 && getGr10() > count){
             for (int i = 0; i < count; i++ ){
                 changeMoney.add("gr10");
             }
         }
         return changeMoney;
    }

}
