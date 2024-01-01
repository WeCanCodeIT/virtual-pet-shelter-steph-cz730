package virtual.pet.shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    private Map<String, VirtualPet> pets = new HashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPet(String name) {
        return pets.get(name);
    }

    public void intakePet(String name, String type, int thirst, int hunger, int boredom) {
        VirtualPet newPet = new VirtualPet(type, name, thirst, hunger, boredom);
        pets.put(name, newPet);
    }

    public void adoptPet(String name) {
        pets.remove(name);
    }

    public void feedAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.feed(10);
        }
    }

    public void waterAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.water(10);
        }
    }

    public void playWithPet(String name) {
        VirtualPet pet = getPet(name);
        if (pet != null) {
            pet.play(10);
        }
    }

    public static void tickShelter(VirtualPetShelter shelter) {
        for (VirtualPet pet : shelter.getAllPets()) {
            pet.tick();
        }
    }
}
