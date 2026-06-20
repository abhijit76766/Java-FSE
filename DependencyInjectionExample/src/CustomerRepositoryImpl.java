import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put(1, "Aarav Sharma");
        customers.put(2, "Meera Iyer");
        customers.put(3, "Rohan Gupta");
    }

    @Override
    public String findCustomerById(int id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}

