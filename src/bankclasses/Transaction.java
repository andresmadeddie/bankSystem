package bankclasses;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private static int counter = 0;
    private String transactionId;
    private LocalDateTime dateTime;
    private double amount;

    public Transaction(LocalDateTime dateTime, double amount) {
        this.transactionId = generateTransactionId();
        this.dateTime = dateTime;
        this.amount = amount;
    }

    // Generate a new unique transaction ID
    private static synchronized String generateTransactionId() {
        return "TRANS" + (++counter);
    }
    @Override
    public String toString() {
        return "transactionId=" + transactionId + ", dateTime=" + dateTime + ", amount=" + amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transaction that = (Transaction) obj;
        return Double.compare(that.amount, amount) == 0 &&
                transactionId.equals(that.transactionId) &&
                dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, dateTime, amount);
    }
}
