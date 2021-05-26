package game;

import fixtures.Door;
import fixtures.Light;
import fixtures.Room;

public class FixtureManager {
	
	Room startingRoom;
	
	public void init() {
		
		// Create rooms
		Room frontYard = new Room(
				"The Front Yard",
				"a front yard",
				"The yard in front of a small house. There is a small concrete walkway leading East to the porch." + "\n"
				+ "The porch has a light next to the front door. There are bushes on both sides of the porch." + "\n"
				+ "Several trees from the neighbors yard give shade.");
		this.startingRoom = frontYard;

		Room livingRoom = new Room(
				"The Living Room",
				"a living room",
				"A living room with three exits. The front door exits to the West. The kitchen is to the East." + "\n"
				+ "And a hallway can be seen to the North. Two couches are along the East and South walls with a small" + "\n"
				+ "table in front of them. A large TV is against the North wall.");
		
		Room kitchen = new Room(
				"The Kitchen",
				"a kitchen",
				"A kitchen with two exits. The back door exits to the East. The living room is to the West." + "\n"
				+ "Large cupboards line the North wall, as well as the South wall with a sink. On the West wall, is a stove" + "\n"
				+ "and a refridgerator. And an eating table is against the East wall with house plants hanging above it.");
		
		Room backYard = new Room(
				"The Back Yard",
				"a back yard",
				"The back yard of the house. There is a porch to the West leading to the back door. A sidewalk leads North from it." + "\n"
				+ "The porch has a light next to the back door.To the South are several raised flower beds." + "\n"
				+ "There is a fence to the East with a narrow garden along it.");
		
		Room hallWay = new Room(
				"The Hallway",
				"a hallway",
				"A short hallway leading to other rooms. At the North end of the hallway there is a bathroom entrance." + "\n"
				+ "There is a bedroom entrance to the East and West. And the living room is through an opening to the South.");
		
		Room myRoom = new Room(
				"My Room",
				"a West bedroom",
				"This is my bedroom. An exit to the hallway is seen to the East. There is a bed and a dog house along the North wall." + "\n"
				+ "A bookcase is next to the door on the East wall. And a closet is seen on the South wall.");
		
		Room houseMateRoom = new Room(
				"My Housemate's Room",
				"an East bedroom",
				"This is my housemate's bedroom. There is an exit to the hallway on the West wall Along with a bed." + "\n"
				+ "A large closet is seen on the North wall. And ther is a desk along the East wall.");
		
		Room bathRoom = new Room(
				"The Bathroom",
				"a bathroom",
				"The bathroom of the house. The bathroom door exits to the South. A shower/tub is found to the North" + "\n"
				+ "Towel racks are placed on the West wall. The sink and toilet can be seen an the East wall.");
		
		Room street = new Room(
				"The Street",
				"a street",
				"The street serves as an exit from the program.");

		
		// create lights
		Light frontPorchLight = new Light("The Front Porch Light");
		Light livingRoomLight = new Light("The Living Room Light");
		Light kitchenLight = new Light("The Kitchen Light");
		Light backPorchLight = new Light("The Back Porch Light");
		Light hallWayLight = new Light("The Hallway Light");
		Light myRoomLight = new Light("My Room's Light");
		Light houseMateRoomLight = new Light("My Housemate's Room Light");
		Light bathRoomLight = new Light("The Bathroom Light");
		
		// Assign lights to their rooms
		frontYard.setLights(new Light[] {frontPorchLight});
		livingRoom.setLights(new Light[] {livingRoomLight});
		kitchen.setLights(new Light[] {kitchenLight});
		backYard.setLights(new Light[] {backPorchLight});
		hallWay.setLights(new Light[] {hallWayLight});
		myRoom.setLights(new Light[] {myRoomLight});
		houseMateRoom.setLights(new Light[] {houseMateRoomLight});
		bathRoom.setLights(new Light[] {bathRoomLight});
		
		// Assign light switches to their rooms
		livingRoom.setLightSwitches(new Light[] {livingRoomLight, frontPorchLight});
		kitchen.setLightSwitches(new Light[] {kitchenLight, backPorchLight});
		hallWay.setLightSwitches(new Light[] {hallWayLight});
		myRoom.setLightSwitches(new Light[] {myRoomLight});
		houseMateRoom.setLightSwitches(new Light[] {houseMateRoomLight});
		bathRoom.setLightSwitches(new Light[] {bathRoomLight});
		
		
		// Create doors including divisions between rooms
		Door frontDoor = new Door("The Front Door");
		Door backDoor = new Door("The Back Door");
		Door myRoomDoor = new Door("My Room Door");
		Door houseMateDoor = new Door("My House Mate's Door");
		Door bathRoomDoor = new Door("The Bathroom Door");
		Door hallWayDoor = new Door("The Hallway Door");
		Door kitchenDoor = new Door("The Kitchen Door");
		Door streetDoor = new Door("The Street Door");
		
		// Assign the two rooms to each door
		frontDoor.setRooms(new Room[] {livingRoom, frontYard});
		backDoor.setRooms(new Room[] {kitchen, backYard});
		myRoomDoor.setRooms(new Room[] {myRoom, hallWay});
		houseMateDoor.setRooms(new Room[] {houseMateRoom, hallWay});
		bathRoomDoor.setRooms(new Room[] {bathRoom, hallWay});
		hallWayDoor.setRooms(new Room[] {livingRoom, hallWay});
		kitchenDoor.setRooms(new Room[] {livingRoom, kitchen});
		streetDoor.setRooms(new Room[] {street});
		
		// Assign doors to rooms
		frontYard.setDoors(new Door[] {frontDoor, streetDoor});
		livingRoom.setDoors(new Door[] {frontDoor, hallWayDoor, kitchenDoor});
		kitchen.setDoors(new Door[] {backDoor, kitchenDoor});
		backYard.setDoors(new Door[] {backDoor, streetDoor});
		hallWay.setDoors(new Door[] {myRoomDoor, houseMateDoor, bathRoomDoor, hallWayDoor});
		myRoom.setDoors(new Door[] {myRoomDoor});
		houseMateRoom.setDoors(new Door[] {houseMateDoor});
		bathRoom.setDoors(new Door[] {bathRoomDoor});
		
		// Identify divisions between rooms with no door
		hallWayDoor.setNoDoor(true);
		kitchenDoor.setNoDoor(true);
		streetDoor.setNoDoor(true);
	}
}
