package BuilderPatternExample;

public class Main {
    public static void main(String[] args) {

        System.out.println(" Building a Basic Office Computer");
        Computer officePC = new Computer.ComputerBuilder("Intel", "8GB")
                .build();
        System.out.println(officePC);


        System.out.println(" Building Optional features");
        Computer gamingPC = new Computer.ComputerBuilder("AMD", "18GB")
                .setStorage("2TB NVDIA")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();
        System.out.println(gamingPC);
    }
}
