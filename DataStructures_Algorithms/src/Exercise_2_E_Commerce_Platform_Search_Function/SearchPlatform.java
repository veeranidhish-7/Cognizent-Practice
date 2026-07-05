package Exercise_2_E_Commerce_Platform_Search_Function;

public class SearchPlatform {

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i; // Target found, return index
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return mid;
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] catalog = {
                new Product(101, "Wireless Mouse", "Electronics"),
                new Product(204, "Running Shoes", "Apparel"),
                new Product(305, "Coffee Mug", "Kitchen"),
                new Product(420, "Mechanical Keyboard", "Electronics"),
                new Product(550, "Desk Lamp", "Home Decor")
        };

        int target = 420;

        // Execute searches
        int linearIndex = linearSearch(catalog, target);
        int binaryIndex = binarySearch(catalog, target);

        // Print results
        System.out.println("Linear Search Found Target at Index: " + linearIndex);
        System.out.println("Binary Search Found Target at Index: " + binaryIndex);
    }
}
