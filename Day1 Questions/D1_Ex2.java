class Employee1
{
    private String name;
    public void Employee1(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}

class Employee2
{
    private String name;

    public Employee2(String name){
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}

class Employee3
{
    private String name;
    Employee3(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
    
}

class Employee4
{
    private String name;

    void Employee4(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}

public class D1_Ex2 {
    public static void main(String[] args) {
        System.out.println("Testing Question 2 of Day 1");

        //Employee1 emp1 = new Employee1("mg mg");
        Employee2 emp2 = new Employee2("Mg Mg");
        Employee3 emp3 = new Employee3("Mg Mg");
        //Employee4 emp4 = new Employee4("Mg Mg");

        //System.out.println("Emp1 name : "+emp1.getName());
        System.out.println("Emp2 name : "+emp2.getName());
        System.out.println("Emp3 name : "+emp3.getName());
        //System.out.println("Emp4 name : "+emp4.getName());
    }
}
