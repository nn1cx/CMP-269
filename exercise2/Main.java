package exercise2;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<SmartDevice> homehub = new ArrayList<SmartDevice>();
        homehub.add(new SmartLight("Living Room"));
        homehub.add(new SmartLight("Kitchen"));
        homehub.add(new SmartThermostat("Hallway"));

        SmartDevice livingRoom = homehub.get(0);
        SmartDevice kitchen = homehub.get(1);
        SmartDevice hallway = homehub.get(2);

        livingRoom.turnOn();
        hallway.turnOn();
        ((Adjustable) kitchen).setLevel(75);

        for (int i = 0; i < homehub.size(); i++) {
            SmartDevice device = homehub.get(i);
            device.performSelfDiagnostic();
        }
    }
}
