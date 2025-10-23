
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class D12_Ex1 {

    public static void processData_A(List<Integer> numbers)
    {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
    }
    public static void processData_B(List<Integer> numbers)
    {
        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext();) {
 if (iter.next() % 2 == 0) {
 iter.remove();
 }
}
    }
    public static void processData_C(List<Integer> numbers)
    {
        for (int i = 0; i < numbers.size(); i++) {
 if (numbers.get(i) % 2 == 0) {
 numbers.remove(i);
 i--;
 }}
    }
    public static void processData_D(List<Integer> numbers)
    {
        numbers.removeIf(n -> n % 2 == 0);
    }
    static void displayResult(List<Integer> numbers1 , List<Integer> numbers2)
    {
        if(numbers1.size() != numbers2.size())
        {
            System.out.println("Test Failed");
            return;
        }
        else
        {
            for(int i=0;i<numbers1.size();i++)
            {
                if(numbers1.get(i) != numbers2.get(i))
                {
                    System.out.println("Test Failed");
                    return;
                }
            }
            System.out.println("Test Success");
            return;
        }
    }
    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<>(Arrays.asList(-1,-2,0,1,2,3,4,5));
        List<Integer> res1 = new ArrayList<>(Arrays.asList(-1,1,3,5));
        processData_A(test1);
        displayResult(test1, res1);

        
        test1 = new ArrayList<>(Arrays.asList(-1,-2,0,1,2,3,4,5));
        processData_B(test1);
        displayResult(test1, res1);
        
        test1 = new ArrayList<>(Arrays.asList(-1,-2,0,1,2,3,4,5));
        processData_C(test1);
        displayResult(test1, res1);
        
        test1 = new ArrayList<>(Arrays.asList(-1,-2,0,1,2,3,4,5));
        processData_D(test1);
        displayResult(test1, res1);
    }
}
