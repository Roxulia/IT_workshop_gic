import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class D16_Ex5 {

     public static List<String> processStrings(List<String> input) {
        return input.stream()
            .filter(s -> s != null && !s.isEmpty())
            .map(String::toUpperCase)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<String> tests = Arrays.asList(
            "abcd","hehehaha","hihihi","adc"
        );
        List<String> res = processStrings(tests);
        for(String s : res)
        {
            System.out.println(s);
        }
    }
}
