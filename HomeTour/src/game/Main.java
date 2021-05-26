package game;

import java.util.Scanner;
import java.util.TreeMap;
import fixtures.Door;
import fixtures.Light;
import fixtures.Room;

public class Main {
	
	public static void main(String[] args) {
		
		FixtureManager fixtureManager = new FixtureManager();
		fixtureManager.init();
		Player player = new Player();
		player.setCurrentRoom(fixtureManager.startingRoom);
		System.out.println("Welcome to my house.");
		System.out.println("There will be cake.");
		System.out.println("You can exit at any time by entering the street through the front or back yards. Enjoy!");
		do {
			TreeMap<Integer, Object> menuCount = printRoom(player);
			String[] x = collectInput();
			parse(x, player, menuCount);
			}
			while (player.getCurrentRoom().getDoors() != null); // Only the street has no doors, so program will exit
		System.out.println("Bye, hope you enjoyed the tour!");
		System.out.println("If you didn't find the cake, play Portal.");
	}
	
	
	private static TreeMap<Integer, Object> printRoom(Player player) {
		TreeMap<Integer, Object> menuOptions = new TreeMap<Integer, Object>(); // generate unique list of interactive objects
		Boolean openDoor = false; // status of open doors in the room
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println(player.getCurrentRoom().name);
		System.out.println();
		  
		System.out.println(player.getCurrentRoom().longDescription);
		System.out.println();
		
		// Print list of lights based on light switches, otherwise based on lights.
		if (player.getCurrentRoom().getLightSwitches() != null) {
			for (int i = 0; i < player.getCurrentRoom().getLightSwitches().length; i++) {
				System.out.println(
						player.getCurrentRoom().getLightSwitches()[i].name +
						" is " + player.getCurrentRoom().getLightSwitches()[i].getState());
		  	}
		}
		else {
			for (int i = 0; i < player.getCurrentRoom().getLights().length; i++) {
				System.out.println(
						player.getCurrentRoom().getLights()[i].name +
						" is " + player.getCurrentRoom().getLights()[i].getState());
		  	}
		}
		
		
		// Print list of exits.
		System.out.println();
		System.out.println("Exits:");
		for (int i = 0; i < player.getCurrentRoom().getDoors().length; i++) {
			if (player.getCurrentRoom().getDoors()[i].getNoDoor() == true) {
				for (int j = 0; j < player.getCurrentRoom().getDoors()[i].getRooms().length; j++) {
					if (player.getCurrentRoom().getDoors()[i].getRooms()[j] != (player.getCurrentRoom())) {
						menuOptions.put((menuOptions.size() + 1), (player.getCurrentRoom().getDoors()[i].getRooms()[j]));
						System.out.println(
								(menuOptions.size()) +
								". Enter " +
								player.getCurrentRoom().getDoors()[i].getRooms()[j].shortDescription);
					}
				}
			}
			else if (player.getCurrentRoom().getDoors()[i].getState() == "closed") {
				menuOptions.put((menuOptions.size() + 1), (player.getCurrentRoom().getDoors()[i]));
				System.out.println(
						(menuOptions.size()) +
						". Open " +
						player.getCurrentRoom().getDoors()[i].name);
			}
			else {
				for (int j = 0; j < player.getCurrentRoom().getDoors()[i].getRooms().length; j++) {
					if (player.getCurrentRoom().getDoors()[i].getRooms()[j] != (player.getCurrentRoom())) {
						menuOptions.put((menuOptions.size() + 1), (player.getCurrentRoom().getDoors()[i].getRooms()[j]));
						System.out.println(
								(menuOptions.size()) +
								". Enter " +
								player.getCurrentRoom().getDoors()[i].getRooms()[j].shortDescription);
					}
				}
			}
		}
		
		// Print list of light switches, if any.
		if (player.getCurrentRoom().getLightSwitches() != null) {
			System.out.println();
			System.out.println("Light Switches:");
			for (int i = 0; i < player.getCurrentRoom().getLightSwitches().length; i++) {
				menuOptions.put((menuOptions.size() + 1), (player.getCurrentRoom().getLightSwitches()[i]));
				System.out.println(
						((menuOptions.size()) + ". Turn " + 
						player.getCurrentRoom().getLightSwitches()[i].name + " " +
						player.getCurrentRoom().getLightSwitches()[i].getOppositeState()));
		  	}
		}
		
		// Check for open doors
		for (int i = 0; i < player.getCurrentRoom().getDoors().length; i++) {
			if (player.getCurrentRoom().getDoors()[i].getNoDoor() == false) {
				if (player.getCurrentRoom().getDoors()[i].getState() == "open") {
					openDoor = true;
				}
			}
		}
		// Print out a list of open doors
		if (openDoor == true) {
			System.out.println();
			System.out.println("Open Doors:");
			for (int i = 0; i < player.getCurrentRoom().getDoors().length; i++) {
				if (player.getCurrentRoom().getDoors()[i].getNoDoor() == false) {
					if (player.getCurrentRoom().getDoors()[i].getState() == "open") {
						menuOptions.put((menuOptions.size() + 1), (player.getCurrentRoom().getDoors()[i]));
						System.out.println(
								(menuOptions.size()) +
								". Close " +
								player.getCurrentRoom().getDoors()[i].name);
					}
				}
			}
		}
		return menuOptions;
	}

	
	private static String[] collectInput() {
		//collect user input
		Scanner scanner = new Scanner(System.in);
		String[] strArray = new String[] {scanner.nextLine()};
		return strArray;
	}
	
	
	private static void parse(String[] command, Player player, TreeMap<Integer, Object> count) {
		// handle user choices
		try {
			int choice = Integer.parseInt(command[0]);
			if ((choice <= 0) || (choice > count.size())) {
				System.out.println("Please make a valid number choice.");
			}
			else {
				if (count.get(choice) instanceof Room) {
					player.setCurrentRoom((Room) count.get(choice));
				}
				else if (count.get(choice) instanceof Light) {
					Light light = (Light) count.get(choice);
					light.setState();
				}
				else {
					Door door = (Door) count.get(choice);
					door.setState();
				}
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Please make a valid number choice.");
		}
	}
}
