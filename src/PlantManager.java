import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlantManager {
    private List <Plant> plantList  = new ArrayList<>();

    //metody

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
                System.out.println(plant);
            }
            System.out.println("\n");
        }
    //seřazení rostlin podle poslední zálivky
    public void sortingWatering(){
            plantList.sort(Comparator.comparing(Plant::getWatering));
            //výpis seřazených rostlin na obrazovku
            plantList.forEach(System.out::println);
        }
    }




