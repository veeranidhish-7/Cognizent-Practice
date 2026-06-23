package DecoratorPatternExample;

public class Main {
    public static void main(String[] args) {

        System.out.println(" Basic Notification : ");
        Notifier simpleNotifier = new EmailNotifier();
        simpleNotifier.send("Hello World");

        System.out.println(" Layered Notification : ");
        // We wrap the Email base inside an SMS, and wrap that inside a Slack notifier.
        Notifier urgentNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()));

        urgentNotifier.send("CRITICAL SYSTEM FAILURE!");
    }
}
