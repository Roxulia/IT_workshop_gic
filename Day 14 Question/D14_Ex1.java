//package Day 14 Question;

public class D14_Ex1 {
    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-5,-2,-8,-1};

        System.out.print("Maximum value : " + findMax(arr));
    }
}
