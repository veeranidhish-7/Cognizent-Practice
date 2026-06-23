package DependencyInjectionExample;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerInfo(int id) {
        System.out.println("Processing business logic...");
        String data = customerRepository.findCustomerById(id);
        System.out.println(data);
    }
}
