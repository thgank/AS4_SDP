package Factory;

public class SpeedCameraType implements TrafficCameraType{
    @Override
    public String capture() {
        return "Speed violation";
    }
}
