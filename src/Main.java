import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws PlantExeption {
        try {
            Plant plantKaktus = new Plant("kaktus");
            Plant plantRose = new Plant("rose", " červená ", 7, LocalDate.of(2024, 11, 6),
                    LocalDate.of(2024, 11, 1));

            System.out.println(plantKaktus.getWetingInfo());
            System.out.println(plantRose.getWetingInfo());
            plantRose.setWatering(LocalDate.now());
            System.out.println("výpis po přepsání zálivky na dnešní datum \n"+plantRose.getWetingInfo());
            plantRose.setFrequencyOfWatering(10);
            System.out.println("výpis po změně frekvence zalívání na "+plantRose.getFrequencyOfWatering()+" dnů. ");
            System.out.println(plantRose.getWetingInfo());

            PlantManager plantManager = new PlantManager();

            plantManager.addPlant(new Plant("Kaktus"," bez poznámky ",7,LocalDate.of(2024, 11,6),
                    LocalDate.of(2024,9,10)));
            plantManager.addPlant(new Plant("Rose1"," cervena ",10,LocalDate.of(2024,11,8),
                    LocalDate.of(2024,11,1)));
            plantManager.addPlant(new Plant("Bledule"));
            plantManager.addPlant(new Plant("Mrkev"," červená ",7,LocalDate.of(2024,11,6),
                    LocalDate.of(2024,11,1)));
            System.out.println("\n");


            plantManager.sortingName();
            plantManager.sortingWatering();
            plantManager.loadingAndSaving("Resources/kvetiny.txt");
            plantManager.getPlantList().sort(Plant::compareTo);

            System.out.println(plantManager.getPlantList().size());
            System.out.println("výpis dle zasazení");
            plantManager.getPlantList().sort(Comparator.comparing(Plant::getPlanted));
            plantManager.listing();
            plantManager.writingToFile("Resources/nacteny-soubor.txt");
            System.out.println("vypsání načteného souboru");
            plantManager.loadingAndListing("Resources/nacteny-soubor.txt");



            for (int i = 0; i < 10; i++) {

                plantManager.getPlantList().add(new Plant("Tulipan"+Seting.flowerNumber()));

            }
            plantManager.getPlantList().sort(Comparator.comparing(Plant::getName));
            System.out.println("\nvýpis po přidání tulipánů\n");
            plantManager.listing();
            plantManager.plantListRemoveIndex(2);
            System.out.println("\nvýpis po prodeji třetí rostliny\n");
            plantManager.listing();


        } catch (PlantExeption e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}