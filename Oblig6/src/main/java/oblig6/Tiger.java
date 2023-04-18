package oblig6;

public class Tiger extends Animal{
    private double speed;
    private String species;

    public Tiger(String name, DietType dietType, int age, String species) {
        super(name, dietType, age);
        setSpecies(species);
        calculateSpeed();
    }

    @Override
    public double calculateSpeed() {
        int speed = 65;
        int age =getAge();
        if (age < 5) {
            double newSpeed = (speed-(age*2));
            setSpeed(newSpeed);
            return speed;
        }
        else if (age > 15) {
            double newSpeed = (speed-(age*0.65));
            if (newSpeed <= 0) {
                newSpeed = 1;
            }
            setSpeed(newSpeed);

            return speed;
        }
        else {
            setSpeed(65);
            return speed;
        }

    }

    @Override
    public String toString() {
        return "Tiger{" + "name='" + getName() + '\'' + ", diettype=" + getDiettype() + ", age=" + getAge() + ", speed=" + getSpeed() + '}';
    }
}
