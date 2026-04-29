public class SmartThermostat extends SmartDevice implements Adjustable{
    private int temperature;

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 60;
    }

    @Override
    public void turnOn() {
        System.out.println("HVAC System Starting...");
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
            if (level < 60 || level > 80) {
                System.out.println("Temperature must be between 60 and 80 degrees.");
            } else {
                temperature = level;
                System.out.println("Temperature set to " + temperature + " degrees.");
            }
        }
    }

    void performSelfDiagnostic() {
        System.out.println("Checking HVAC system health...");
    }
    
}
