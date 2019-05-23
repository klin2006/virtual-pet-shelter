package virtualpetshelter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter petShelter = new VirtualPetShelter();

		VirtualPet pet1 = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		VirtualPet pet2 = new VirtualPet("Dorothy", "the doting dodo", 88, 42, 52, 42);
		VirtualPet pet3 = new VirtualPet("Randy", "the random emu", 72, 97, 64, 22);
		VirtualPet pet4 = new VirtualPet("Quack", "the quirky duck", 52, 68, 80, 54);

		petShelter.admit(pet1);
		petShelter.admit(pet2);
		petShelter.admit(pet3);
		petShelter.admit(pet4);

		System.out.println("Welcome to Turky Chiken's Fowl Coop.");

		petShelter.menu();
		String menuSelection = input.next();
		input.nextLine();
		while (!menuSelection.equals("ESC")) {
			if (menuSelection.equals("1")) {
				for (VirtualPet pets : petShelter.getAllPets()) {
					System.out.println(pets.getPetName() + " " + pets.getPetDescription() + ": " + "\nHunger: "
							+ pets.getHunger() + " Happy: " + pets.getHappy() + " Clean: " + pets.getClean()
							+ " Thirst: " + pets.getThirst());
				}
				petShelter.menu();
			} else if (menuSelection.equals("2")) {
				petShelter.feedAllPets();
				petShelter.tick();
				petShelter.menu();

			} else if (menuSelection.equals("3")) {
				System.out.println("Which pet would you like to play Tic-Tac-Toe with?");
				for (String keyValue : petShelter.pets.keySet()) {
					VirtualPet key = petShelter.pets.get(keyValue);
					System.out.println(keyValue);
				}
				String playPet = input.next();
				input.nextLine();
				VirtualPet foundPet = petShelter.findPet(playPet);
				if (playPet == null) {
					petShelter.valid();
					petShelter.menu();
				}

				else {
					System.out.println("You play with " + playPet + "!");
					petShelter.play(playPet, 0);
					petShelter.tick();
					petShelter.menu();
				}

			} else if (menuSelection.equals("4")) {
				petShelter.cleanAllPens();
				petShelter.tick();
				petShelter.menu();

			} else if (menuSelection.equals("5")) {
				petShelter.waterAllPets();
				petShelter.tick();
				petShelter.menu();

			} else if (menuSelection.equals("6")) {
				petShelter.adoptMenu();
				for (String keyValue : petShelter.pets.keySet()) {
					VirtualPet key = petShelter.pets.get(keyValue);
					System.out.println(keyValue);
				}
				String adoptPet = input.next();
				input.nextLine();
				VirtualPet foundPet = petShelter.findPet(adoptPet);
				if (foundPet == null) {
					petShelter.valid();
					petShelter.menu();
				}

				else {
					System.out.println("Goodbye, " + adoptPet + "!");
					petShelter.adopt(foundPet);
					petShelter.tick();
					petShelter.menu();
				}
			}

			else if (menuSelection.equals("7")) {
				System.out.println("What is your pet's name?");
				String userPetName = input.next();
				input.nextLine();
				System.out.println("What is your pet's description?");
				String userPetDescription = input.next();
				input.nextLine();
				System.out.println("What is your pet's hunger level (enter as a number between 0 and 100)?");
				int userPetHunger = input.nextInt();
				input.nextLine();
				System.out.println("What is your pet's happy level (enter as a number between 0 and 100)?");
				int userPetHappy = input.nextInt();
				input.nextLine();
				System.out.println("What is your pet's clean level (enter as a number between 0 and 100)?");
				int userPetClean = input.nextInt();
				input.nextLine();
				System.out.println("What is your pet's thirst level (enter as a number between 0 and 100)?");
				int userPetThirst = input.nextInt();
				VirtualPet petinput = new VirtualPet(userPetName, userPetDescription, userPetHunger, userPetHappy,
						userPetClean, userPetThirst);
				petShelter.admit(petinput);
				System.out.println("Welcome, " + userPetName + ". ");
				petShelter.tick();
				petShelter.menu();
			} else if (menuSelection.equals("8")) {
				System.exit(0);

			} else {
				petShelter.valid();
			}

			menuSelection = input.next();

		}
	}
}