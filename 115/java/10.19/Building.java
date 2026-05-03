public class Building implements CarbonFootprint {
    private String name;
    private double squareFootage;
    private double kwh;

    public Building(String name, double squareFootage, double kwh) {
        this.name = name;
        this.squareFootage = squareFootage;
        this.kwh = kwh;
    }

    public String getName() {
        return name;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public double getAnnualEnergyUsageKwh() {
        return kwh;
    }

    @Override
    public double getCarbonFootprint() {
        return kwh * 0.386;
    }

    @Override
    public String toString() {
        return String.format("Building [name=%s, size=%.0f sq ft, energy=%.0f kWh/yr]",
                name, squareFootage, kwh);
    }
}
