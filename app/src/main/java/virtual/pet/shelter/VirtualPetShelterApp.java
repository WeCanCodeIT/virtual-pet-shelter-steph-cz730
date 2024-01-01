package virtual.pet.shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.intakePet("Spartan", "Dog", 80, 30, 20);
        shelter.intakePet("Zelda", "Cat", 70, 45, 5);
        shelter.intakePet("Corvik", "Bird", 40, 20, 85);
        shelter.intakePet("Cinderace", "Rabbit", 60, 25, 35);

        System.out.println("Welcome to Stephanie's Pet Shelter! Thank you for volunteering your time!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayPetStatus(shelter.getAllPets());

            System.out.println("What would you like to do next?");
            System.out.println("1. Feed the pets");
            System.out.println("2. Water the pets");
            System.out.println("3. Play with a pet");
            System.out.println("4. Adopt a pet");
            System.out.println("5. Admit a pet");
            System.out.println("6. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shelter.feedAllPets();
                    System.out.println("You feed all the pets!");
                    break;
                case 2:
                    shelter.waterAllPets();
                    System.out.println("You water all the pets!");
                    break;
                case 3:
                    playWithPetInteraction(shelter, scanner);
                    break;
                case 4:
                    adoptPetInteraction(shelter, scanner);
                    break;
                case 5:
                    admitPetInteraction(shelter, scanner);
                    break;
                case 6:
                    System.out.println("Goodbye! Please come again!");
                    System.exit(0);
                    break;
                case 7:
                    tickShelter(shelter);
                    System.out.println("Time passes. The pets' needs have changed.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayPetStatus(Collection<VirtualPet> pets) {
        System.out.println("Name\t|Hunger\t|Thirst\t|Boredom");
        System.out.println("--------|-------|-------|-------");

        for (VirtualPet pet : pets) {
            Map<String, Object> petData = new HashMap<>();
            petData.put("Name", pet.getName());
            petData.put("Hunger", pet.getHunger());
            petData.put("Thirst", pet.getThirst());
            petData.put("Boredom", pet.getBoredom());
        
            for (Map.Entry<String, Object> entry : petData.entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "\t|");
            }
        
            System.out.println();
        }
    }

    private static void playWithPetInteraction(VirtualPetShelter shelter, Scanner scanner) {
        System.out.println("Ok, so you'd like to play with a pet. Please choose one:");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println("[" + pet.getName() + "]");
        }

        String petName = scanner.nextLine();
        shelter.playWithPet(petName);
        System.out.println("You played with " + petName + ".");
    }

    private static void adoptPetInteraction(VirtualPetShelter shelter, Scanner scanner) {
        System.out.println("Ok, so you'd like to adopt a pet. Please choose one:");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println("[" + pet.getName() + "]");
        }

        String petName = scanner.nextLine();
        shelter.adoptPet(petName);
        System.out.println("You adopted " + petName + ".");
    }

    private static void admitPetInteraction(VirtualPetShelter shelter, Scanner scanner) {
        System.out.println("Ok, so you'd like to admit a pet. Please enter the following information:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Thirst: ");
        int thirst = scanner.nextInt();
        System.out.print("Hunger: ");
        int hunger = scanner.nextInt();
        System.out.print("Boredom: ");
        int boredom = scanner.nextInt();

        shelter.intakePet(name, type, thirst, hunger, boredom);
        System.out.println(name + " has been admitted to the shelter.");
    }

    private static void tickShelter(VirtualPetShelter shelter) {
        for (VirtualPet pet : shelter.getAllPets()) {
            pet.tick();
        }
    }
}
