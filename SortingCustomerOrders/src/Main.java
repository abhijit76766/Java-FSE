import java.util.Arrays;

class Order {
    private final int orderId;
    private final String customerName;
    private final double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return orderId + " - " + customerName + ": " + totalPrice;
    }
}

public class Main {
    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Asha", 1500.0),
            new Order(2, "Ravi", 700.0),
            new Order(3, "Meera", 4200.0),
            new Order(4, "Kabir", 2500.0)
        };

        Order[] bubbleSorted = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSorted);
        System.out.println("Bubble Sort:");
        System.out.println(Arrays.toString(bubbleSorted));

        Order[] quickSorted = Arrays.copyOf(orders, orders.length);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("Quick Sort:");
        System.out.println(Arrays.toString(quickSorted));
    }
}

