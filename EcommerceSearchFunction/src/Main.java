import java.util.Arrays;
import java.util.Comparator;

class Product {
    private final int productId;
    private final String productName;
    private final String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class Main {
    static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = products[middle].getProductName().compareToIgnoreCase(name);

            if (comparison == 0) {
                return products[middle];
            }
            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Camera", "Electronics"),
            new Product(4, "Book", "Education")
        };

        System.out.println("Linear search: " + linearSearch(products, "Camera"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Binary search: " + binarySearch(products, "Laptop"));
    }
}

