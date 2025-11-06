

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

class Order6{
    private int customerid;
    private double value;
    private String status;

    public Order6(int customerid,double value,String status) {
        this.customerid = customerid;
        this.value = value;
        this.status = status;
    }

    int getCustomerId()
    {
        return this.customerid;
    }

    double getValue()
    {
        return  this.value;
    }

    String getStatus()
    {
        return this.status;
    }
}

public class D16_Ex6 {

    public static void main(String[] args) {
        List<Order6> orders = Arrays.asList(
            new Order6(1, 100.5,"PENDING"),
            new Order6(2, 125.5,"PENDING"),
            new Order6(2, 135,"FINISHED"),
            new Order6(1, 150,"FINISHED"),
            new Order6(3, 100,"FINISHED"),
            new Order6(3, 200,"PENDING"),
            new Order6(3, 100.5,"PENDING")
        );
        String country = "America";

        List<Integer> res =orders.stream()
                    .filter(o -> o.getStatus().equals("PENDING"))
                    .map(Order6::getCustomerId)
                    .collect(Collectors.toList());
        System.out.println("Test A Result : ");
        for(Integer i : res)
        {
            System.out.println(i);
        }

        res = orders.parallelStream()
        .filter(o -> o.getStatus() == "PENDING")
        .map(o -> o.getCustomerId())
        .toList();
        System.out.println("Test B Result : ");
        for(Integer i : res)
        {
            System.out.println(i);
        }

    }
}