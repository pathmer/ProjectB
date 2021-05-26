package fixtures;

public class Room extends Fixture {
	
	private Light[] lights;
	private Light[] lightSwitches;
	private Door[] doors;
	
	public Room(String name, String shortDescription, String longDescription) {
		super.name = name;
		super.shortDescription = shortDescription;
		super.longDescription = longDescription;
	}
	
	public Light[] getLights() {
		return lights;
	}

	public void setLights(Light[] lights) {
		this.lights = lights;
	}

	public Light[] getLightSwitches() {
		return lightSwitches;
	}

	public void setLightSwitches(Light[] lightSwitches) {
		this.lightSwitches = lightSwitches;
	}

	public Door[] getDoors() {
		return doors;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}
}
