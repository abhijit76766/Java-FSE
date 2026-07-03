import java.util.HashMap;
import java.util.Map;

class Product {
    private final int productId;
    private String productName;
    private int quantity;
    private double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    int getProductId() {
        return productId;
    }

    void update(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + ", quantity=" + quantity + ", price=" + price;
    }
}

class Inventory {
    private final Map<Integer, Product> products = new HashMap<>();

    void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    boolean updateProduct(int productId, String productName, int quantity, double price) {
        Product product = products.get(productId);
        if (product == null) {
            return false;
        }
        product.update(productName, quantity, price);
        return true;
    }

    boolean deleteProduct(int productId) {
        return products.remove(productId) != null;
    }

    void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(101, "Keyboard", 25, 799.0));
        inventory.addProduct(new Product(102, "Mouse", 40, 499.0));
        inventory.addProduct(new Product(103, "Monitor", 12, 8999.0));

        inventory.updateProduct(102, "Wireless Mouse", 35, 899.0);
        inventory.deleteProduct(101);
        inventory.displayProducts();
    }
}

