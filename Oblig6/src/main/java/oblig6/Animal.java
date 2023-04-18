package oblig6;

public abstract class Animal {
    private String name;
    private DietType diettype;
    private int age;
    private double speed;
    private String species;

    public Animal(){}

    public Animal(String name, DietType diettype, int age) {
        this.name = name;
        this.diettype = diettype;
        this.age = age;
        calculateSpeed();
    }

    public abstract double calculateSpeed();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DietType getDiettype() {
        return diettype;
    }

    public void setDiettype(DietType diettype) {
        this.diettype = diettype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", diettype=" + diettype + ", age=" + age + ", speed=" + speed + '}';
    }

}
