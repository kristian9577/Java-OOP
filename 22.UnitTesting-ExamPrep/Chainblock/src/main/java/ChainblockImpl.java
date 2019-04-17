import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> record;

    public ChainblockImpl() {
        this.record = new HashMap<>();
    }

    @Override
    public Map<Integer, Transaction> getRecord() {
        return record;
    }

    @Override
    public int getCount() {
        return this.record.size();
    }

    @Override
    public void add(Transaction transaction) {
        this.record.putIfAbsent(transaction.getId(), transaction);
    }

    @Override
    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    @Override
    public boolean contains(int id) {

        return this.record.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.record.containsKey(id)) {
            throw new IllegalArgumentException("No such transaction");
        }
        this.record.get(id).setStatus(newStatus);
    }

    @Override
    public void removeTransactionById(int id) {
        if (!this.record.containsKey(id)) {
            throw new IllegalArgumentException("Transaction not present");
        }
        this.record.remove(id);
    }

    @Override
    public Transaction getById(int id) {
        if (!this.record.containsKey(id)) {
            throw new IllegalArgumentException("Transaction not present");
        }
        return this.record.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.record.values().stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted((f,s)->Double.compare(s.getAmount(),f.getAmount()))
                .collect(Collectors.toList());
       if( transactions.isEmpty()){
           throw new IllegalArgumentException("NO Transaction with given status");
       }
       return transactions;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
         return    this.record.values().stream()
                    .filter(t->t.getStatus().equals(status))
                    .map(Transaction::getSender)
                    .collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return null;
    }
}
