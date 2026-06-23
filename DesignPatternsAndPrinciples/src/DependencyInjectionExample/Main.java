package DependencyInjectionExample;

public class Main {
    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        System.out.println(" Executing Client Request : ");
        service.getCustomerInfo(101);
    }
}
