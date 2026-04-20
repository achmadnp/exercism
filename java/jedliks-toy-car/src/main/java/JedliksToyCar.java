public class JedliksToyCar {

    private int batteryPercentage;
    private int totalDistance;

    public JedliksToyCar() {
        this.batteryPercentage = 100;
        this.totalDistance = 0;
    }

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + totalDistance + " meters";
    }

    public String batteryDisplay() {
        if (batteryPercentage <= 0) {
            return "Battery empty";
        }
        return "Battery at " + batteryPercentage + "%";
    }

    public void drive() {
        if (batteryPercentage > 0) {
            this.totalDistance += 20;
            this.batteryPercentage -= 1;
        }
    }
}
