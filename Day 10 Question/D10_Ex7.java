
import utils.ConcurrentPerformanceTester;
import java.util.function.*;

public class D10_Ex7 {

    public static float categorizeA(double orderAmount,Boolean isPremiumMember) { 
        float discount = 0;
        if (orderAmount > 200) discount = 0.10f;
        else if (orderAmount > 100) discount = 0.05f; 
        if (isPremiumMember) discount += 0.05f;
        
        return discount;
    }

    public static float categorizeD(double orderAmount,Boolean isPremiumMember) { 
        float discount = 0;
        if (orderAmount > 100) discount = 0.05f; 
        if (orderAmount > 200)
        discount = 0.10f; 
        if (isPremiumMember) discount *= 1.05f;
        
        return discount;
    }

    public static float categorizeB(double orderAmount,Boolean isPremiumMember) { 
        float discount = 0;
        if (orderAmount > 100) discount = 0.05f; if (orderAmount > 200) discount = 0.10f; if
(isPremiumMember) discount = discount + 0.05f;
        
        return discount;
    }

    public static float categorizeC(double orderAmount,Boolean isPremiumMember) { 
        float discount = 0;
        discount = (orderAmount > 200) ? 0.10f : (orderAmount > 100) ? 0.05f : 0; 
        if(isPremiumMember) discount += 0.05f;
        return discount;
    }

    
    public static void main(String[] args) {
        Double[] test1 = {
            50D,50D,101D,101D,201D,201D
        };
        Boolean[] test2 = {
            true,false,true,false,true,false
        };
        Float[] res = 
        {
            0.05f,0f,0.1f,0.05f,0.15f,0.1f
        };

        BiFunction<Double,Boolean,Float> funca = (n,b)->categorizeA(n,b);
        ConcurrentPerformanceTester<Double,Boolean,Float> tester = new ConcurrentPerformanceTester<Double,Boolean,Float>("Function A",funca,test1,test2,res,0,0);
        tester.runTest(10);
        funca = (n,b)->categorizeB(n,b);
        tester = new ConcurrentPerformanceTester<Double,Boolean,Float>("Function B",funca,test1,test2,res,0,0);
        tester.runTest(10);
        funca = (n,b)->categorizeC(n,b);
        tester = new ConcurrentPerformanceTester<Double,Boolean,Float>("Function C",funca,test1,test2,res,0,0);
        tester.runTest(10);
        funca = (n,b)->categorizeD(n,b);
        tester = new ConcurrentPerformanceTester<Double,Boolean,Float>("Function D",funca,test1,test2,res,0,0);
        tester.runTest(10);
    }
}
