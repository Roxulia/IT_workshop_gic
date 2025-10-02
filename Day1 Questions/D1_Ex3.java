

class Order
{
    private double price;

    public Order(double price) {
        this.price = price;
    }
    
    /*public static void calculateTotalPrice1(Order order, double taxRate)
    {
        this.price = order.price + (order.price * taxRate);
    }*/

    public double calculateTotalPrice2(Order order, double taxRate)
    {
        return (order.price + (order.price * taxRate));
    }

    private double calculateTotalPrice3(Order order, double taxRate)
    {
        return (order.price + (order.price * taxRate));
    }

    public Order calculateTotalPrice4(double taxRate)
    {
        this.price += (this.price * taxRate);
        return this;
    }
}

public class D1_Ex3 {
    public static void main(String[] args) {
        System.out.println("TEsting Question 3 of Day 1");

        Order order1 = new Order(100.50);
        System.out.println("Price after calling calculateTotalPrice2 : " + order1.calculateTotalPrice2(order1, 0.05) );
        //System.out.println("Price After calling calculateTotalPrice3 : " + order1.calculateTotalPrice3(order1, 0.05));
        System.out.println("Price After calling calculateTotalPrice4 : " + order1.calculateTotalPrice4(0.05));
    }
}
