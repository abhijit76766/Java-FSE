public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        customerService.printCustomer(1);
        customerService.printCustomer(4);
    }
}

