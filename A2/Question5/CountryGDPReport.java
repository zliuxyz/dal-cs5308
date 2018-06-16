import java.util.ArrayList;

public class CountryGDPReport {
    ArrayList<Country> countries;

    public CountryGDPReport() {
        countries = new ArrayList<>();
        countries.add(new Canada());
        countries.add(new Mexico());
    }

    public void printCountryGDPReport() {
        System.out.println("GDP By Country:\n");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println("- " + countries.get(i).getName() + ":\n");
            System.out.println("   - Agriculture: " + countries.get(i).getAgriculture());
            System.out.println("   - Manufacturing: " + countries.get(i).getManufacturing());
        }
    }
}