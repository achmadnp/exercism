class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    int getDistanceTravelled;
    int numberOfVictories;

    public ProductionRemoteControlCar() {
        this.getDistanceTravelled = 0;
        this.numberOfVictories = 0;
    }

    public void drive() {
        this.getDistanceTravelled += 10;

    }

    public int getDistanceTravelled() {
        return this.getDistanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return Integer.compare(o.getNumberOfVictories(), this.getNumberOfVictories());
    }
}
