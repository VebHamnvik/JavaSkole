package oblig6;

public class Bear extends Animal{
    private double speed;
    private String species;

    public Bear(String name, DietType dietType, int age, String species){
        super(name, dietType, age);
        this.speed = 56;
        setSpecies(species);
        calculateSpeed();
    }

    @Override
    public double calculateSpeed() {
        int age = getAge();
        double newSpeed = speed - (age*0.95);
        if (newSpeed <= 0) {
            newSpeed = 1;
        }
        setSpeed(newSpeed);
        return speed;
    }

    @Override
    public String toString() {
        return "Bear{" + "name='" + getName() + '\'' + ", diettype=" + getDiettype() + ", age=" + getAge() + ", speed=" + getSpeed() + '}';
    }
}
