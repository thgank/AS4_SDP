package Observer;

public class TrafficControlCenter implements Observer{
    private String name;

    public TrafficControlCenter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String event) {
        System.out.println("Traffic Control Center " + name + " received event: " + event);
    }
}
