
import java.util.*;
import  java.util.stream.*;

enum  TransactionType{
CREDIT,DEBIT
}
class Transaction{
    private TransactionType type;
    private double amount;

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

public class D17_Ex5 {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction(TransactionType.CREDIT, 100),
            new Transaction(TransactionType.DEBIT, 200),
            new Transaction(TransactionType.CREDIT, 50),
            new Transaction(TransactionType.DEBIT, 100)
        );
        double total_amount = transactions.stream().filter(t->t.getType()==TransactionType.CREDIT).mapToDouble(Transaction::getAmount).sum();
        total_amount = transactions.parallelStream().filter(t -> t.getType() == TransactionType.CREDIT).map(Transaction::getAmount).reduce(0.0, Double::sum);
        total_amount = transactions.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount))).get(TransactionType.CREDIT);
        total_amount = transactions.stream().filter(t -> t.getType() == TransactionType.CREDIT).collect(Collectors.summingDouble(Transaction::getAmount));
        
        long startTime = System.nanoTime();

        total_amount = transactions.stream().filter(t->t.getType()==TransactionType.CREDIT).mapToDouble(Transaction::getAmount).sum();
        System.out.println("Tessting A Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+total_amount);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        total_amount = transactions.parallelStream().filter(t -> t.getType() == TransactionType.CREDIT).map(Transaction::getAmount).reduce(0.0, Double::sum);
        System.out.println("Tessting B Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+total_amount);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        total_amount = transactions.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount))).get(TransactionType.CREDIT);
        System.out.println("Tessting C Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+total_amount);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        total_amount = transactions.stream().filter(t -> t.getType() == TransactionType.CREDIT).collect(Collectors.summingDouble(Transaction::getAmount));
        System.out.println("Tessting D Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+total_amount);
        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();
        total_amount = transactions.stream().filter(t->t.getType()==TransactionType.CREDIT).mapToDouble(Transaction::getAmount).sum();
        System.out.println("Tessting A Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+total_amount);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

    }
}
