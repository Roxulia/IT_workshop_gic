
import java.util.*;

public class D17_Ex8 {

    public static List<Transaction> getTransactions()
    {
        return (
        Arrays.asList(
            new Transaction(TransactionType.CREDIT, 1000),
            new Transaction(TransactionType.DEBIT, 2000),
            new Transaction(TransactionType.CREDIT, 500),
            new Transaction(TransactionType.DEBIT, 1500)
        )
        );
    }

    public static void main(String[] args) {
         List<Transaction> transactions = getTransactions();
 double sum = transactions.stream()
    .filter(t -> t.getAmount() > 1000)
    .map(Transaction::getAmount)
    .reduce(0, (a, b) -> a + b);
    System.out.println(sum);
    }
}
