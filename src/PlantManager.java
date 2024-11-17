import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PlantManager {
    private List <Plant> plantList  = new ArrayList<>();


    public List<Plant> getPlantList() {
        return plantList;
    }
        //přidání nové květiny do seznamu přes manažera
    public void addPlant(Plant plant){
    plantList.add(plant);
    }
        //získání květiny ze senamu dle indexu přes manažera
    public Plant getPlantIndex(int index){
    return plantList.get(index);
    }
        //smazání květiny ze seznamu přes manažera
    public void plantListRemoveIndex(int index){
        plantList.remove(index);
    }
        //vytvoření kopie seznamu přes manažera
    public List <Plant> copyOfPlantList(){
    List <Plant> copyOfPlantList = new ArrayList<>(plantList);
    return copyOfPlantList;
    }
        // metoda na výpis rostlin k zalití přes manažera
    public void plantsForWatering(){
        for (int i = 0; i < plantList.size(); i++) {
            if(plantList.get(i).getWatering().isBefore(plantList.get(i).getWatering().plusDays(plantList.get(i).getFrequencyOfWatering())));
            System.out.println("rostlinu "+plantList.get(i).getName()+" je potřeba zalít!");
        }
    }
        //seřazení rostlin podle jména
    public void sortingName(){
            // Seřazení plantList
            plantList.sort(Comparator.comparing(Plant::getName));
            // Výpis rostlin na obrazovku
            for (Plant plant : plantList) {
                System.out.println(plant.getName());
            }
            System.out.println("\n");
        }
        //seřazení rostlin podle poslední zálivky
    public void sortingWatering(){
            plantList.sort(Comparator.comparing(Plant::getWatering));
            //výpis seřazených rostlin na obrazovku
        for (Plant plant : plantList) {
            System.out.println(plant.getWatering()+" "+plant.getName());
        }
        System.out.println("\n");
        }
        //načtení ze souboru
    public void loadingAndSaving(String nameFile) throws PlantExeption {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nameFile)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                System.out.println(Plant.parse(line, lineNumber)); //zavolán výtisk s statickou metodou Plant parse
                plantList.add(Plant.parse(line, lineNumber));
            }
        } catch (FileNotFoundException e) {
            throw new PlantExeption("Soubor " + nameFile + " nebyl nalezen! \n" + e.getLocalizedMessage());

        }
    }


    public void loadingAndListing (String nameFile) throws PlantExeption {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nameFile)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineNumber++;
                    System.out.println(Plant.parse(line, lineNumber)); //zavolán výtisk s statickou metodou Plant parse

                }
            } catch (FileNotFoundException e) {
                throw new PlantExeption("Soubor " + nameFile + " nebyl nalezen! \n" + e.getLocalizedMessage());

            }

        }
    public void listing(){
        System.out.println("výpis všech rostlin v listu ");
            for (int i = 0; i < getPlantList().size(); i++) {
                System.out.println(plantList.get(i).getName()+" zasazení "+plantList.get(i).getPlanted()+" zalití "+
                        plantList.get(i).getWatering());
            }
        }
    public  void writingToFile(){


    }

    }







