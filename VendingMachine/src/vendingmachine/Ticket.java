

package vendingmachine;
import java.time.LocalDate;


/**
 *
 * @author jacek.malatynski
 */
public interface Ticket {

    
    void issueTicket();
    int getUnitCost();
    
}

  class Zone1 implements Ticket {
        final private String type;
        final private String description;
        final private Integer unitCost;
        LocalDate today = LocalDate.now();
        
        public Zone1(){
        this.type = "Zone 1";
        this.unitCost = 150;
        this.description = "bilet upowaznia do podróżowania w strefie 1,"
                           + "bez przesiadek, przez 30 minut ";
        }
        
        @Override
        public int getUnitCost(){
            return unitCost;
        }
        
        @Override
        public void issueTicket() {
             System.out.println("#####################");
             System.out.println(type);
             System.out.println("price: " + (unitCost / 100.0) + " zl");
             System.out.println("Issued: " + today);
             System.out.println(description);
             System.out.println("#####################");
             System.out.println();
        }
}

class Zone2 implements Ticket {
        final private String type;
        final private String description;
        final private Integer unitCost;
        LocalDate today = LocalDate.now();
        
        public Zone2(){
        this.type = "Zone 2";
        this.unitCost = 340;
        this.description = "bilet upowaznia do podróżowania w strefie 1-2,"
                           + "bez przesiadek, przez 60 minut ";
        }
    
    @Override
    public int getUnitCost(){
        return unitCost;
    }
                
    @Override
    public void issueTicket( ) {
             System.out.println("#####################");
             System.out.println(type);
             System.out.println("price: " + (unitCost / 100.0) + " zl");
             System.out.println("Issued: " + today);
             System.out.println(description);
             System.out.println("#####################");
             System.out.println();
    }
}

class Zone3 implements Ticket {
    final private String type;
    final private String description;
    final private Integer unitCost;
    LocalDate today = LocalDate.now();

    
    public Zone3(){
    this.type = "Zone 3";
    this.unitCost = 500;
    this.description = "bilet upowaznia do podróżowania w strefie 1-3,"
                       + "z przesiadkami, przez 60 minut ";
    }

    @Override
    public int getUnitCost(){
        return unitCost;
    }

    @Override
    public void issueTicket( ) {
         System.out.println("#####################");
         System.out.println(type);
         System.out.println("price: " + (unitCost / 100.0) + "zl" );
         System.out.println("Issued: " + today);
         System.out.println(description);
         System.out.println("#####################");
         System.out.println();
    }
}    
    



