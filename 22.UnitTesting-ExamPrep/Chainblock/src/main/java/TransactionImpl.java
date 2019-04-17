public class TransactionImpl implements Comparable<TransactionImpl>,Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }


    @Override
    public int getId() {
         return id;
    }

    @Override
    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public String getSender() {
        return from;
    }

    @Override
    public int compareTo(TransactionImpl o) {
        return 0;
    }
}
