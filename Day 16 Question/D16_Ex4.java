
import java.util.Arrays;
import java.util.List;

class Customer1{
    private String country;

    Customer1(String country) {
        this.country = country;
    }  

    public String getCountry(){
        return this.country;
    }
}

class Order1{
    private Customer1 customer;
    private double value;

    public Order1(Customer1 customer,double value) {
        this.customer = customer;
        this.value = value;
    }

    Customer1 getCustomer()
    {
        return this.customer;
    }

    double getValue()
    {
        return  this.value;
    }
}

public class D16_Ex4 {

    public static void main(String[] args) {
        Customer1 c1 = new Customer1("America");
        Customer1 c2 = new Customer1("Africa");
        List<Order1> orders = Arrays.asList(
            new Order1(c1, 100.5),
            new Order1(c2, 125.5),
            new Order1(c2, 135),
            new Order1(c1, 150),
            new Order1(new Customer1("Asia"), 100),
            new Order1(new Customer1("Asia"), 200),
            new Order1(new Customer1("Asia"), 100.5)
        );
        String country = "America";

        double totalValue = orders.stream()
                    .filter(o->o.getCustomer().getCountry().equals(country))
                    .mapToDouble(Order1::getValue).sum();
        System.out.println("Test A Result : " + totalValue);

        totalValue = orders.stream()
                .filter(o->o.getCustomer().getCountry().equals(country))
                .map(Order1::getValue)
                .reduce(0.0, Double::sum);
        System.out.println("Test B Result : " + totalValue);

        //totalValue = orders.parallelStream().filter(o-> o.getCustomer().getCountry().equals(country)).map(Order::getValue).sum();
        //System.out.println("Test C Result : " + totalValue);

        totalValue = orders.stream()
                .map(o -> o.getCustomer().getCountry().equals(country) ? o.getValue() : 0)
                .reduce(0.0, Double::sum);
        System.out.println("Test D result : " + totalValue);
    }
}