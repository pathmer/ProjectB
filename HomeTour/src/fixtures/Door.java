package fixtures;

public class Door extends Fixture {
	
	private String state;
	private String oppositeState;
	private Room[] rooms;
	private Boolean noDoor;
	
	public Door(String name) {
		super.name = name;
		this.state = ("closed");
		this.oppositeState = ("open");
		this.noDoor = false;
	}

	public String getState() {
		return state;
	}

	public void setState() {
		String tempState = this.state;
		String tempOppositeState = this.oppositeState;
		this.state = tempOppositeState;
		this.oppositeState = tempState;
	}
	
	public Boolean getNoDoor() {
		return noDoor;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	public void setNoDoor(Boolean noDoor) {
		this.noDoor = noDoor;
	}
}
