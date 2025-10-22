
import utils.ConcurrentPerformanceTester;
import java.util.function.*;

public class D10_Ex8 {

    public static String categorizeProductA(double temp) { 
        if (temp < 0) return("Heavy winter coat"); 
        else if (temp < 10) return("Lightjacket"); 
        else if (temp < 20) return("Sweater"); 
        else return("T-shirt");
     }

    public static String categorizeProductD(double temp) { 
        if (temp <= 0) return ("Heavy winter coat"); 
        else if (temp <= 10) 
        return ("Lightjacket"); 
        else if (temp <= 20) return ("Sweater"); 
        else return ("T-shirt"); 
    }

    public static void main(String[] args) {
        Double[] tests = {
            -1D,0D,10D,11D,20D,21D
        };
        String[] res = {
            "Heavy winter coat","Lightjacket","Lightjacket","Sweater","Sweater","T-shirt"
        };

        Function<Double,String> funca = (n)->categorizeProductA(n);
        ConcurrentPerformanceTester<Double,Void,String> tester = new ConcurrentPerformanceTester<Double,Void,String>("Function A",funca,tests,res,0,0);
        tester.runTest(10);
        funca = (n)->categorizeProductD(n);
        tester = new ConcurrentPerformanceTester<Double,Void,String>("Function D",funca,tests,res,0,0);
        tester.runTest(10);
    }
}
