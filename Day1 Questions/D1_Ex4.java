class InputValidator1{
    public boolean validateEmail(String email) {return true; }
    public boolean validatePhoneNumber(String phone) { return true; }
}

class InputValidator2{
    public static boolean validateEmail(String email) {return true; }
    public static boolean validatePhoneNumber(String phone) { return true; }
}

abstract class InputValidator3{
    public abstract boolean validateEmail(String email);
    public abstract boolean validatePhoneNumber(String phone);
}

interface InputValidator4 {
 boolean validateEmail(String email);
 boolean validatePhoneNumber(String phone);
}

class InputValidator3Test extends InputValidator3
{
    @Override
    public boolean validateEmail(String email)
    {
        return true;
    }

    @Override 
    public  boolean validatePhoneNumber(String phone)
    {
        return true;
    }
}

class InputValidator4Test implements InputValidator4
{
    @Override
    public boolean validateEmail(String email)
    {
        return true;
    }

    @Override
    public boolean validatePhoneNumber(String phone)
    {
        return true;   
    }
}

public class D1_Ex4
{
    public static void main(String[] args) {
        System.out.println("Testing Question 4 of Day 1");
        InputValidator1 val1 = new InputValidator1();

        System.out.println("Email Validation using " + val1.getClass() +" : " + val1.validateEmail("a")+ ","+ val1.validatePhoneNumber("phone"));
        System.out.println("Email Validation using " + 
        InputValidator2.class +" : " + InputValidator2.validateEmail("a")+ 
        ","+ InputValidator2.validatePhoneNumber("phone"));
    }
}

