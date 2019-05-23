package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<>();

	public void admit(VirtualPet pet) {
		pets.put(pet.getPetName(), pet);
	}

	public VirtualPet findPet(String petName) {
		return pets.get(petName);
	}

	public void adopt(VirtualPet pet) {
		pets.remove(pet.getPetName(), pet);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void menu() {
		System.out.println("***********************");
		System.out.println("What would you like to do in the coop?");
		System.out.println("Press 1 to Check pets' stats");
		System.out.println("Press 2 to Throw the kernel");
		System.out.println("Press 3 to Play tic-tac-toe");
		System.out.println("Press 4 to Clean the pens");
		System.out.println("Press 5 to Water the pets");
		System.out.println("Press 6 to Adopt a pet");
		System.out.println("Press 7 to Admit a pet");
		System.out.println("Press 8 to Quit");
	}

	public void adoptMenu() {
		System.out.println("Here are the pets currently in the shelter. Which pet would you like to adopt?");
	}

	public void valid() {
		System.out.println("Please enter a valid selection");
	}

	public void admit(String userPetName, String userPetDescription, int userPetHunger, int userPetHappy,
			int userPetClean) {
	}

	public void cleanAllPens() {
		System.out.println("You clean all the pens.");
		for (VirtualPet eachPet : pets.values()) {
			eachPet.cleanEachPen();
		}
	}

	public void waterAllPets() {
		System.out.println("You water all the pets.");
		for (VirtualPet eachPet : pets.values()) {
			eachPet.waterEachPet();

		}
	}

	public void feedAllPets() {
		System.out.println("You throw the kernel.");
		System.out.println("         *");
		System.out.println("       *    *");
		System.out.println("     *        *");
		System.out.println("    *           *");
		System.out.println("  *              *");
		System.out.println("*                 *");
		System.out.println("All the pets are fed.");
		for (VirtualPet eachPet : pets.values()) {
			eachPet.feedEachPet();
		}
	}

	public void play(String petName, int happy) {
		System.out.println("      |      |");
		System.out.println("      |      |");
		System.out.println("------|------|------");
		System.out.println("      |      |");
		System.out.println("      |      |");
		System.out.println("------|------|------");
		System.out.println("      |      |");
		System.out.println("      |      |");
		VirtualPet playTicTacToe = findPet(petName);
		playTicTacToe.play(happy);
	}

	public void tick() {
		for (VirtualPet eachPet : pets.values()) {
			eachPet.tickEachPet();
		}

	}

}