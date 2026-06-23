package ProxyPatterExample;

public class Main {
    public static void main(String[] args) {

        System.out.println(" System Initialized: ");
        Image image = new ProxyImage("holiday_photo_1080p.jpg");

        System.out.println(" User clicks 'View Image' for the first time: ");
        image.display();

        System.out.println(" User clicks 'View Image' again later: ");
        image.display();
    }
}
