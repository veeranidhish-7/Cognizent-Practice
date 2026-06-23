package ProxyPatterExample;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Downloading " + filename + " from remote server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying :" + filename + " ");
    }
}
