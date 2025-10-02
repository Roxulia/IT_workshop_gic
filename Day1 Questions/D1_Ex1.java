class BankAccount1
{
    public double balance; 
    public void deposit(double amount) { this.balance += amount; } 
    public void withdraw(double amount) { this.balance -= amount; }
}

class BankAccount2
{
    private double balance; 
    public void deposit(double amount) 
    { 
        if (amount > 0) this.balance += amount; 
    } 
    public void withdraw(double amount) 
    { 
        if (amount > 0 && amount <= this.balance) this.balance -= amount; 
    }
    public double  getBalance()
    {
        return this.balance;
    }
}

class BankAccount3
{
    public static double balance; 
    public static void deposit(double amount) { balance += amount; } 
    public static void withdraw(double amount) { balance -= amount; }
}

class BankAccount4
{
    private double balance; 
    public void setBalance(double newBalance) { this.balance = newBalance; } 
    public double getBalance() { return this.balance; }
}

public class D1_Ex1{
    public static void main(String[] args)
    {
        System.out.println("Testing Question 1 of Day 1");
        BankAccount1 mgmgAccount1 = new BankAccount1();
        BankAccount2 mgmgAccount2 = new BankAccount2();
        BankAccount3 mgmgAccount3 = new BankAccount3();
        BankAccount3 kokoAccount3 = new BankAccount3();
        BankAccount4 mgmgAccount4 = new BankAccount4();

        mgmgAccount1.deposit(1000);
        System.out.println("MgMg Account 1 balance after deposit : "+ mgmgAccount1.balance);
        mgmgAccount1.withdraw(2000);
        System.out.println("MgMg Account 1 balance after withdraw: "+ mgmgAccount1.balance);
        mgmgAccount1.balance += 1000;
        System.out.println("MgMg Account 1 balance : "+ mgmgAccount1.balance);

        mgmgAccount2.deposit(1000);
        System.out.println("MgMg Account 2 balance after deposit: "+ mgmgAccount2.getBalance());
        mgmgAccount2.withdraw(3000);
        System.out.println("MgMg Account 2 balance after withdraw: "+ mgmgAccount2.getBalance());
        
        mgmgAccount3.deposit(1000);
        kokoAccount3.deposit(1000);
        System.out.println("MgMg Account 3 balance after deposit: "+ mgmgAccount3.balance);

        mgmgAccount4.setBalance(1000);
        System.out.println("MgMg Account 4 balance : "+ mgmgAccount4.getBalance());
    }
}