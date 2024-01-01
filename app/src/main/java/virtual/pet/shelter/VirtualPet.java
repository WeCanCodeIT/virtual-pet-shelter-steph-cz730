package virtual.pet.shelter;

public class VirtualPet {

    public String type;
    public String name;
    private int thirst;
    private int hunger;
    private int boredom;

    public VirtualPet(String type, String name, int thirst, int hunger, int boredom) {
        this.type = type;
        this.name = name;
        this.thirst = thirst;
        this.hunger = hunger;
        this.boredom = boredom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getBoredom() {
        return boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public void feed(int foodIn) {
        if (foodIn > 0) {
            this.hunger -= foodIn;
        }
    }

    public void water(int waterIn) {
        if (waterIn > 0) {

            this.thirst -= waterIn;
        }
    }

    public void play(int playTime) {
        if (playTime > 0) {
            this.boredom -= playTime;
        }
    }

    public void tick() {
        this.hunger += 5;
        this.thirst += 5;
        this.boredom += 5;
    }
}
