
import java.util.*;

class Orders171{
    private double total;
    private double discount;

    public Orders171(double total, double discount) {
        this.total = total;
        this.discount = discount;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTotal(double discount) {
        this.total = discount;
    }

    public double getDiscount() {
        return this.discount;
    }

    public double getTotal() {
        return this.total;
    }

    public void print()
    {
        System.out.println("Total : "+this.total+", Discount : "+ this.discount);
    }

}
public class D17_Ex1 {

    public static void main(String[] args) {
        List<Orders171> orders = Arrays.asList(
            new Orders171(100, 0),
            new Orders171(99, 0),
            new Orders171(101, 0)
        );

        System.out.println("Tessting Function A....");
        orders.stream().forEach(order -> order.setDiscount(0.1));
        for(Orders171 o : orders)
        {
            o.print();
        }

        orders = Arrays.asList(
            new Orders171(100, 0),
            new Orders171(99, 0),
            new Orders171(101, 0)
        );

        //orders.parallelStream().map(order->order.setDiscount(0.1)).collect(Collectors.toList());
        System.out.println("Tessting Function C....");
        orders.stream().filter(order -> order.getTotal() > 100).forEach(order->order.setDiscount(0.1));
        for(Orders171 o : orders)
        {
            o.print();
        }

        orders = Arrays.asList(
            new Orders171(100, 0),
            new Orders171(99, 0),
            new Orders171(101, 0)
        );

        System.out.println("Tessting Function D....");
        orders.forEach(order -> { if(order.getTotal() > 100) order.setDiscount(0.1); });
        for(Orders171 o : orders)
        {
            o.print();
        }

    }
}
