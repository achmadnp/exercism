class NeedForSpeed {

    private int BATTERY;
    private final int batteryDrain;
    private final int speed;
    private int distance;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.batteryDrain = batteryDrain;
        this.speed = speed;
        this.distance = 0;
        this.BATTERY = 100;
    }

    public boolean batteryDrained() {
        return this.BATTERY < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        if (this.BATTERY - this.batteryDrain < 0) {
            return;
        }
        this.distance = this.distance + this.speed;
        this.BATTERY = this.BATTERY - this.batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
            
            if (car.distanceDriven() >= this.distance) {
                return true;
            }
        }
        return false;
    }
}
