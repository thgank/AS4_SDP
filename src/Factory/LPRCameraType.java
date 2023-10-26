package Factory;

public class LPRCameraType implements TrafficCameraType{
    @Override
    public String capture() {
        return "Plate recognized";
    }
}
