import java.time.LocalDate;

public class Plant implements Comparable <Plant> {
    private String name;
    private String notes;
    private int frequencyOfWatering;//frekvence zalívání
    private LocalDate watering;//datum zalití
    private LocalDate planted;//datum zasazení

    //konstruktor 1
    public Plant(String name, String notes, int frequencyOfWatering, LocalDate watering, LocalDate planted) throws PlantExeption {
        int line = 1;
        if(watering.isBefore(planted)){
            line++;
            throw  new PlantExeption("datum zálivky nemůže být starší jak datum zasazení! chybné datum je na řádku "+line);
        }
        this.name = name;
        this.notes = notes;
        this.setFrequencyOfWatering(frequencyOfWatering);
        this.watering = watering;
        this.planted = planted;
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
        int line = 0;
        if(watering.isBefore(planted)){
            line++;
            throw  new PlantExeption("datum zálivky nemůže být starší jak datum zasazení! řádek\n" + line);
        }

        this.watering = watering;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
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


    @Override
    public int compareTo(Plant o) {
        return 0;
    }
}
