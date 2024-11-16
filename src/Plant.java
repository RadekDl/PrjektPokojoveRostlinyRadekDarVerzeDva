import java.time.DateTimeException;
import java.time.LocalDate;

public class Plant implements Comparable <Plant> {
    private String name;
    private String notes;
    private int frequencyOfWatering;//frekvence zalívání
    private LocalDate watering;//datum zalití
    private LocalDate planted ;//datum zasazení

    //konstruktor 1
    public Plant(String name, String notes, int frequencyOfWatering, LocalDate watering, LocalDate planted) throws PlantExeption {
        this.name = name;
        this.notes = notes;
        this.setFrequencyOfWatering(frequencyOfWatering);
        this.watering = watering;
        this.setPlanted(planted);//planted = planted;
    }
    //konstruktor 2
    public Plant(String name,int frequencyOfWatering) throws PlantExeption {
        this(name," ",frequencyOfWatering,LocalDate.now(),LocalDate.now());
    }
    //konstruktor 3
    public Plant(String name) throws PlantExeption {
        this(name," ",7,LocalDate.now(),LocalDate.now());
    }
    //metody
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getFrequencyOfWatering()  {

        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantExeption {
        if (frequencyOfWatering<=0){
            throw new PlantExeption("zálivka nemůže být 0 a méně zadáno bylo "+getFrequencyOfWatering());
        }

        this.frequencyOfWatering = frequencyOfWatering;
    }

    public LocalDate getWatering() {

        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantExeption {

        if(watering.isBefore(planted)){

           throw  new PlantExeption("datum zálivky nemůže být starší jak datum zasazení!");
        }

        this.watering = watering;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) throws PlantExeption {

        if(planted.isAfter(watering)){

            throw  new PlantExeption("datum zálivky nemůže být starší jak datum zasazení!");
        }
        this.planted = planted;
    }

    //informace - jméno květiny, datum poslední zálivky, doporučená další zálivka
    public String getWetingInfo(){
        String listing = "jmeno "+getName()+ " poslední zálivka "+getWatering()+ " doporučená další zálivka je: "+getWatering().plusDays(getFrequencyOfWatering());
        return listing;
    }
    //přepsání poslední zálivky na dneštní den
    public void doWatering() throws PlantExeption {
        setWatering(LocalDate.now());
    }
    //rozdělení řádku na jednotlivé segmenty
    public static Plant parse(String line, int lineNumber) throws PlantExeption {
        int numberOfItemsOnLine = 5;
        String[] parts = line.split(Seting.getSeparator());
        if (parts.length !=numberOfItemsOnLine){
            throw new PlantExeption("špatný počet poležek na řádku "+ lineNumber+"očekáváme "
                    +numberOfItemsOnLine+"\n"+"\n"+line);
        }
        String name = parts[0].trim(); // trim odstraní mezery za a před segmentem
        String notes = parts[1].trim();
        try {
            int frequencyOfWatering = Integer.parseInt(parts[2].trim());
            LocalDate watering = LocalDate.parse(parts[3].trim());
            LocalDate planted = LocalDate.parse(parts[4].trim());
            return new Plant(name, notes, frequencyOfWatering, watering, planted);

        } catch (DateTimeException | NumberFormatException e) {
            throw new PlantExeption("nesprávný formát položky na řádku" + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Plant{" +
                "jméno = '" + name + '\'' +
                ", zápisník = '" + notes + '\'' +
                ", frekvence zálivky = " + frequencyOfWatering +
                ", datum zálivky = " + watering +
                ", datum zasazení = " + planted +
                '}';
    }

    @Override
    public int compareTo(Plant o) {
        return name.compareTo(o.name);
    }
}
