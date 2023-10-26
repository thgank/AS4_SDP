package Factory;

public class SpeedCameraFactory implements TrafficCameraFactory{
    @Override
    public TrafficCameraType createCamera() {
        return new SpeedCameraType();
    }
}
