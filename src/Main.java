import Factory.*;
import Observer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static List<Observer> controlCenters = new ArrayList<>();
    static List<TrafficCameraType> cameras = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static speedCamera speedCamera = new speedCamera(); // Create a speedCamera instance

    public static void main(String[] args) {
        System.out.println("--- Traffic Center ---");

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create new Camera");
            System.out.println("2. Create Control Center");
            System.out.println("3. List Cameras");
            System.out.println("4. List Centers");
            System.out.println("5. Check Events");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createNewCamera();
                    break;
                case 2:
                    createNewCenter();
                    break;
                case 3:
                    listCameras();
                    break;
                case 4:
                    listCenters();
                    break;
                case 5:
                    checkEvent();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void checkEvent() {
        System.out.println("Checking Events at Traffic Control Centers and Cameras:");
        checkCameraEvents();
    }

    public static void checkCameraEvents() {
        System.out.println("Camera Events:");
        for (TrafficCameraType camera : cameras) {
            String eventDescription = camera.capture();
            for (Observer center : controlCenters) {
                if (center instanceof TrafficControlCenter controlCenter) {
                    controlCenter.update(eventDescription);
                }
            }
        }
    }


    public static void createNewCenter() {
        System.out.println("--- Enter name of Center ---");
        sc.nextLine(); // Consume the newline character
        String name = sc.nextLine();
        Observer controlCenter = new TrafficControlCenter(name);
        controlCenters.add(controlCenter);
        speedCamera.registerObserver(controlCenter); // Register the control center as an observer
        System.out.println("Traffic Control Center " + name + " created.");
    }

    public static void createNewCamera() {
        System.out.println("--- Choose which Camera you want to create ---");
        System.out.println("1. Speed Camera\n2. LPRCamera");
        int choice = sc.nextInt();
        if (choice == 1) {
            TrafficCameraFactory speedCameraFactory = new SpeedCameraFactory();
            TrafficCameraType speedCameraType = speedCameraFactory.createCamera();
            cameras.add(speedCameraType);
        } else if (choice == 2) {
            TrafficCameraFactory lprCameraFactory = new LPRCameraFactory();
            TrafficCameraType lprCameraType = lprCameraFactory.createCamera();
            cameras.add(lprCameraType);
        }
    }

    public static void listCenters() {
        System.out.println("List of Traffic Control Centers:");
        for (Observer center : controlCenters) {
            if (center instanceof TrafficControlCenter controlCenter) {
                System.out.println(controlCenter.getName());
            }
        }
    }

    public static void listCameras() {
        System.out.println("List of Traffic Cameras:");
        for (TrafficCameraType camera : cameras) {
            if (camera instanceof SpeedCameraType) {
                System.out.println("Speed Camera");
            } else if (camera instanceof LPRCameraType) {
                System.out.println("LPR Camera");
            }
        }
    }
}
