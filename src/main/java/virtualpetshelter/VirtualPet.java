package virtualpetshelter;

public class VirtualPet {

	private String petName;
	private String petDescription;
	private int hunger;
	private int happy;
	private int clean;
	private int thirst;

	public VirtualPet(String petName, String userPetDescription, int hunger, int happy, int clean, int thirst) {
		this.petName = petName;
		this.petDescription = userPetDescription;
		this.hunger = hunger;
		this.happy = happy;
		this.clean = clean;
		this.thirst = thirst;
	}

	public String getPetName() {
		return petName;
	}

	public int getHunger() {
		return hunger;
	}

	public int getHappy() {
		return happy;
	}

	public int getClean() {
		return clean;
	}

	public int getThirst() {
		return thirst;

	}

	public String getPetDescription() {
		return petDescription;
	}

	public int throwTheKernel(VirtualPet pet) {
		return hunger = 100;
	}

	public int cleanEachPen() {
		return clean = 100;

	}

	public int waterEachPet() {
		return thirst = 100;
	}

	public void feedEachPet() {
		hunger = 100;
	}

	public void play(int happy2) {
		happy = 100;

	}

	public void tickEachPet() {
		hunger -= 4;
		happy -= 8;
		clean -= 7;
		thirst -= 3;

	}

}