
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        Product product = this.findByLabel(label);
        int newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);
    }

    @Override
    public Product find(int index) {
        return this.products.get(index - 1);
    }

    @Override
    public Product findByLabel(String label) {
        return this.products.stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        ArrayList<Product> result = new ArrayList<>();
        if (!(count <= 0 || count > this.getCount())) {
            this.products
                    .stream()
                    .sorted(Product::compareTo)
                    .limit(count)
                    .forEach(result::add);
        }
        return result;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
