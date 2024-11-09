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
            System.out.println(plantRose.getFrequencyOfWatering());
        } catch (PlantExeption e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}