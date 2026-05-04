import java.util.ArrayList;

public class CarbonFootprintTest {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> items = new ArrayList<>();

        items.add(new Building("Office", 50000, 850000));
        items.add(new Building("Home", 2000, 12000));
        items.add(new Car("Toyota", "Camry", 15000, 32.0));
        items.add(new Car("Ford", "F-150", 12000, 20.0));
        items.add(new Bicycle("Road", 2000));
        items.add(new Bicycle("Mountain", 1500));
        items.add(new Bicycle("E-Bike", 3000, true, 0.5));

        System.out.println("=== Carbon Footprint Report ===\n");
        System.out.printf("%-55s %20s%n", "Object", "CO2 (kg/year)");
        System.out.println("-".repeat(78));

        for (CarbonFootprint item : items) {
            System.out.printf("%-55s %,20.2f%n",
                item.toString(), item.getCarbonFootprint());
        }

        System.out.println("-".repeat(78));

        double total = 0;
        for (CarbonFootprint item : items)
            total += item.getCarbonFootprint();

        System.out.printf("%-55s %,20.2f%n", "TOTAL", total);
    }
}
