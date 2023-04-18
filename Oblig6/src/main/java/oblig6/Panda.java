package oblig6;

public class Panda extends Animal{
    private double speed;
    private String species;

    public Panda(String name, DietType dietType, int age, String species) {
        super(name, dietType, age);
        this.speed = 32;
        setSpecies(species);
        calculateSpeed();
    }


    @Override
    public double calculateSpeed() {
        int age = getAge();
        double newSpeed = speed-age;
        if(newSpeed <= 0) {
            newSpeed = 1;
        }

        setSpeed(newSpeed);
        return speed;


    }

    @Override
    public String toString() {
        return "Panda{" + "name='" + getName() + '\'' + ", diettype=" + getDiettype() + ", age=" + getAge() + ", speed=" + getSpeed() + '}';
    }
}
