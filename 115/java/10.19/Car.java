public class Car implements CarbonFootprint {
    private String make;
    private String model;
    private double mpy;
    private double mpg;

    public Car(String make, String model, double mpy, double mpg) {
        this.make = make;
        this.model = model;
        this.mpg = mpg;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getMilesPerYear() {
        return mpy;
    }

    public double getMilesPerGallon() {
        return mpg;
    }

    @Override
    public double getCarbonFootprint() {
        double gallonsPerYear = mpy / mpg;
        return gallonsPerYear * 8.887;
    }

    @Override
    public String toString() {
        return String.format("Car [%s %s, %.0f miles/yr, %.1f mpg]",
                make, model, mpg, mpg);
    }
}
