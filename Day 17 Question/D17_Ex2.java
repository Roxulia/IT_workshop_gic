import java.util.*;
import java.util.stream.*;

class Investments{
    private double value;

    public Investments(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
}

public class D17_Ex2 {

    public static void main(String[] args) {
        List<Investments> investments = Arrays.asList(
            new Investments(11),
            new Investments(11.5),
            new Investments(12),
            new Investments(12.5),
            new Investments(13.25)
        );
        //double total = investments.stream().map(Investments::getValue).sum();
        double total = investments.stream().mapToDouble(Investments::getValue).sum();
        System.out.println("Testing Option B.....");
        System.out.println("Actual Res :  60.25" );
        System.out.println("Tested Res : " + total);

        total = investments.stream().collect(Collectors.summingDouble(Investments::getValue ));
        System.out.println("Testing Option D.....");
        System.out.println("Actual Res :  60.25" );
        System.out.println("Tested Res : " + total);
    }
}