public class SmartLight extends SmartDevice implements Adjustable{
    private int brightness;

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0;
    }

    @Override
    public void turnOn() {
        isOn = true;
        activeDevicesCount++;
    }

    @Override
    public void turnOff() {
        isOn = false;
        activeDevicesCount--;
    }

    @Override
    public void setLevel(int level) {
        if (!isOn) {
            System.out.println("Cannot adjust: Device is OFF.");
        }
        else {
            if (level < 0 || level > 100) {
                System.out.println("Brightness level must be between 0 and 100.");
            } else {
                brightness = level;
                System.out.println("Brightness set to " + brightness + "%.");
            }
        }
    }

    void performSelfDiagnostic() {
        System.out.println("Checking LED health...");
    }
}
