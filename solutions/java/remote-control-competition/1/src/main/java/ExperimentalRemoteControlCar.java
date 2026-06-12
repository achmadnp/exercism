public class ExperimentalRemoteControlCar implements RemoteControlCar {
    int getDistanceTravelled;

    public ExperimentalRemoteControlCar() {
        this.getDistanceTravelled = 0;
    }

    public void drive() {
        this.getDistanceTravelled += 20;
    }

    public int getDistanceTravelled() {
        return this.getDistanceTravelled;
    }
}
