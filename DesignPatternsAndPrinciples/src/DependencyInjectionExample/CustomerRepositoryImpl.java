package DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating a database fetch
        if (id == 101) {
            return "Customer Record: [ID: 101, Name: Veera Nidhish]";
        }
        return "Customer not found.";
    }
}
