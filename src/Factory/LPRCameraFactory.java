package Factory;

public class LPRCameraFactory implements TrafficCameraFactory{
    @Override
    public TrafficCameraType createCamera() {
        return new LPRCameraType();
    }
}
