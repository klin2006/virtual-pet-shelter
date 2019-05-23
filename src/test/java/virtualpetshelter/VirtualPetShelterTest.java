package virtualpetshelter;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;
	VirtualPet pet5;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		pet2 = new VirtualPet("Dorothy", "the doting dodo", 88, 42, 52, 42);
		pet5 = new VirtualPet("Ruth", "new pet on the block", 12, 14, 15, 9);
	}

	@Test
	public void shouldBeAbleToAdmitAPet() {
		underTest.admit(pet5);
		VirtualPet admitPet = underTest.findPet("Ruth");
		assertEquals(pet5, admitPet);
	}

	@Test
	public void shouldBeAbleToAdmitTwoPets() {
		underTest.admit(pet1);
		underTest.admit(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(2, allPets.size());
	}

	@Test
	public void shouldBetAbleToAdoptAPet() {
		underTest.admit(pet1);
		underTest.adopt(pet1);
		VirtualPet adoptPet = underTest.findPet(pet1.getPetName());
		assertThat(adoptPet, is(nullValue()));
	}

	@Test
	public void dorothyShouldShowNameofPiggly() {
		VirtualPet underTest = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		String name = underTest.getPetName();
		assertEquals("Piggly", name);
	}

	@Test
	public void dorothyShouldShowNameofDorothy() {
		VirtualPet underTest = new VirtualPet("Dorothy", "the doting dodo", 88, 42, 52, 42);
		String name = underTest.getPetName();
		assertEquals("Dorothy", name);
	}

	@Test
	public void pigglyShouldShowHungerOf12() {
		VirtualPet underTest = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		int hunger = underTest.getHunger();
		assertEquals(52, hunger);
	}

	@Test
	public void dorothyShouldShowHungerOf88() {
		VirtualPet underTest = new VirtualPet("Dorothy", "the doting dodo", 88, 42, 52, 42);
		int hunger = underTest.getHunger();
		assertEquals(88, hunger);
	}

	@Test
	public void pigglyShouldShowHappyOf15() {
		VirtualPet underTest = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		int happy = underTest.getHappy();
		assertEquals(65, happy);
	}

	@Test
	public void dorothyShouldShowHappyOf42() {
		VirtualPet underTest = new VirtualPet("Dorothy", "the doting dodo", 88, 42, 52, 42);
		int happy = underTest.getHappy();
		assertEquals(42, happy);
	}

	@Test
	public void pigglyShouldShowCleanOf8() {
		VirtualPet underTest = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		int clean = underTest.getClean();
		assertEquals(78, clean);
	}

	@Test
	public void dorothyShouldShowCleanOf52() {
		VirtualPet underTest = new VirtualPet("Dorothy", "the doting dodo", 88, 42, 52, 42);
		int clean = underTest.getClean();
		assertEquals(52, clean);
	}

	@Test
	public void findPigglyInCollection() {
		VirtualPet underTest = new VirtualPet("Piggly", "the piggy pigeon", 52, 65, 78, 82);
		String name = underTest.getPetName();
		assertEquals("Piggly", name);
	}

	@Test
	public void playWithOnePet() {
		underTest.admit(pet1);
		underTest.play(pet1.getPetName(), 65);
		assertThat(pet1.getHappy(), is(100));
	}

	@Test
	public void cleanAllPens() {
		underTest.admit(pet1);
		underTest.admit(pet2);
		underTest.cleanAllPens();
		assertThat(pet1.getClean(), is(100));
		assertThat(pet2.getClean(), is(100));
	}

	@Test
	public void waterAllPets() {
		underTest.admit(pet1);
		underTest.admit(pet2);
		underTest.waterAllPets();
		assertThat(pet1.getThirst(), is(100));
		assertThat(pet2.getThirst(), is(100));
	}

	@Test
	public void feedAllPets() {
		underTest.admit(pet1);
		underTest.admit(pet2);
		underTest.feedAllPets();
		assertThat(pet1.getHunger(), is(100));
		assertThat(pet2.getHunger(), is(100));
	}

	@Test
	public void tickMethodWork() {
		underTest.admit(pet1);
		underTest.tick();
		assertThat(pet1.getHunger(), is(48));
		assertThat(pet1.getHappy(), is(57));
		assertThat(pet1.getClean(), is(71));
		assertThat(pet1.getThirst(), is(79));
	}
}