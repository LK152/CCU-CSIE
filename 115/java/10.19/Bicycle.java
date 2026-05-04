public class Bicycle implements CarbonFootprint {
    private String type;
    private double mpy;
    private boolean isEbike;
    private double kwh;

    public Bicycle(String type, double mpy, boolean isEbike, double kwh) {
        this.type = type;
        this.mpy = mpy;
        this.isEbike = isEbike;
        this.kwh = kwh;
    }

    public Bicycle(String type, double mpy) {
        this(type, mpy, false, 0.0);
    }

    public String getType() { return type; }
    public double getMilesPerYear() { return mpy; }
    public boolean isEbike() { return isEbike; }

    @Override
    public double getCarbonFootprint() {
        double footprint = mpy * 0.034;

        if (isEbike) {
            footprint += mpy * kwh * 0.386;
        }

        return footprint;
    }

    @Override
    public String toString() {
        return String.format("Bicycle [type=%s, %.0f miles/yr%s]",
            type, mpy, isEbike ? ", e-bike" : "");
    }
}
