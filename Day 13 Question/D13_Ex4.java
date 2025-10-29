public class D13_Ex4 {

    static boolean funcA (int number)
    {
        return  (number > 0 && number < 100);
    }

    static boolean funcB (int number)
    {
        return (number >= 0 && number <= 100);
    }

    static boolean funcC(int number)
    {
        return (number > 0 || number < 100);
    }

    static boolean funcD (int number)
    {
        return (!(number <= 0 || number >= 100));
    }
    public static void main(String[] args) {
        int[] tests = {
            1,0,100,99
        };
        boolean[] expected = {
            true,false,false,true
        };
        System.out.println("Testing Func A");
        boolean func_success = true;
        for (int i=0;i<expected.length;i++)
        {
            if(expected[i] != funcA(tests[i]))
            {
                System.out.println("Test Fail");
                func_success = false;
                break;
            }
        }
        if(func_success)
        {
            System.out.println("Test Success");
        }

        System.out.println("Testing Func B");
        func_success = true;
        for (int i=0;i<expected.length;i++)
        {
            if(expected[i] != funcB(tests[i]))
            {
                System.out.println("Test Fail");
                func_success = false;
                break;
            }
        }
        if(func_success)
        {
            System.out.println("Test Success");
        }

        System.out.println("Testing Func C");
        func_success = true;
        for (int i=0;i<expected.length;i++)
        {
            if(expected[i] != funcC(tests[i]))
            {
                System.out.println("Test Fail");
                func_success = false;
                break;
            }
        }
        if(func_success)
        {
            System.out.println("Test Success");
        }

        System.out.println("Testing Func D");
        func_success = true;
        for (int i=0;i<expected.length;i++)
        {
            if(expected[i] != funcD(tests[i]))
            {
                System.out.println("Test Fail");
                func_success = false;
                break;
            }
        }
        if(func_success)
        {
            System.out.println("Test Success");
        }
    }
}

