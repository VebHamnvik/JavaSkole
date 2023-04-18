package oblig6;

import java.util.HashMap;
import java.util.Map;

public class Zoo {
    private HashMap<String, String> listeDyr;

    public Zoo() {
        this.listeDyr = new HashMap<>();
    }

    public HashMap<String, String> getDyrepark() {
        return listeDyr;
    }

    public void leggTilDyr(Animal animal) {
        String name = animal.getName();
        String info = "a " + animal.getSpecies() + " that is " + animal.getAge() + " years old, and they can run " + animal.getSpeed() + "km/h. They are a " + animal.getDiettype();
        listeDyr.put(name, info);
    }

    public void printDyrepark() {
        System.out.println("Dyreparken har disse dyrene:");
        for (Map.Entry<String, String> entry : listeDyr.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " = " + value);
        }
    }
}
