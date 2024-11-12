import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws PlantExeption {
        try {
            Plant plantKaktus = new Plant("kaktus");
            Plant plantRose = new Plant("rose", " červená ", 7, LocalDate.of(2024, 11, 1),
                    LocalDate.of(2024, 11, 1));

            System.out.println(plantKaktus.getWetingInfo());
            System.out.println(plantRose.getWetingInfo());
            plantRose.setWatering(LocalDate.now());
            System.out.println("výpis po přepsání zálivky na dnešní datum \n"+plantRose.getWetingInfo());
            plantRose.setFrequencyOfWatering(10);
            System.out.println("výpis po změně frekvence zalívání na "+plantRose.getFrequencyOfWatering()+" dnů. ");
            System.out.println(plantRose.getWetingInfo());

            PlantManager plantManager = new PlantManager();

            plantManager.addPlant(new Plant("kaktus"," bez poznámky ",7,LocalDate.of(2024, 10,1),
                    LocalDate.of(2024,9,10)));
            plantManager.addPlant(new Plant("rose1"," cervena ",10,LocalDate.of(2024,11,8),
                    LocalDate.of(2024,11,1)));
            plantManager.addPlant(new Plant("bledule"));
            System.out.println("\n");

            plantManager.sortingName();
            plantManager.sortingWatering();
        } catch (PlantExeption e) {
            System.err.println(e.getMessage());
           // e.printStackTrace();
        }

    }
}