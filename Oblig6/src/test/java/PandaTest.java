import oblig6.Panda;
import oblig6.DietType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PandaTest {
    private Panda panda;

    @BeforeEach
    public void init() {
        panda = new Panda("Geir", DietType.Herbivore, 15, "Panda");
    }

    @Test
    public void checkingIfSpeedIsSubtractedProperly(){
        panda.calculateSpeed();
        assertEquals(17, panda.getSpeed());
    }

}
