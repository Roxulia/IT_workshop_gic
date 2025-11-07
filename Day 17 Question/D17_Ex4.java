import java.util.*;
import java.util.stream.*;
public class D17_Ex4 {

    public static void main(String[] args) {
        String text = "This is Test. Test is Fun.";
        
        System.out.println(Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(w -> w,Collectors.counting())));

        System.out.println(Arrays.stream(text.split(" ")).collect(Collectors.toMap(w -> w, w -> 1,Integer::sum)));

        //System.out.println(text.split(" ").stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println(Arrays.stream(text.split(" ")).reduce(new HashMap<String, Long>(), (map,word) -> { map.put(word, map.getOrDefault(word, 0L) + 1); return map; },(m1, m2) -> m1));
    }
}
