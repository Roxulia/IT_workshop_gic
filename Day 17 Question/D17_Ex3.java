
import java.util.*;
import java.util.stream.*;

class User{
    private boolean isPremium;
    private int uid ;
    private static int id = 0;

    public User(boolean isPremium) {
        this.isPremium = isPremium;
        this.uid = ++id;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void print()
    {
        System.out.println("UID : "+uid + ", Premium : "+ isPremium);
    }
}

public class D17_Ex3 {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User(false),
            new User(true),
            new User(false),
            new User(true),
            new User(false)
        );

        System.out.println("Testing A.....");
        List<User> premiumUsers = users.stream().filter(User::isPremium).collect(Collectors.toList());
        for(User u : premiumUsers)
        {
            u.print();
        }

        System.out.println("Testing B.....");
        premiumUsers = users.parallelStream().filter(u -> u.isPremium()).toList();
        for(User u : premiumUsers)
        {
            u.print();
        }

        System.out.println("Testing C.....");
        premiumUsers = users.stream().map(u -> u.isPremium() ? u : null).collect(Collectors.toList());
        for(User u : premiumUsers)
        {
            try {
                u.print();
            } catch (NullPointerException e) {
                System.out.println("null value");
            }
        }

        System.out.println("Testing D.....");
        premiumUsers = users.stream().filter(u -> u.isPremium() == true).collect(Collectors.toList());
        for(User u : premiumUsers)
        {
            u.print();
        }
    }
}