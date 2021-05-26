package fixtures;

public class Light extends Fixture {
	
	private String state;
	private String oppositeState;
	
	public Light(String name) {
		super.name = name;
		this.state = ("off");
		this.oppositeState = ("on");
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

	public String getOppositeState() {
		return oppositeState;
	}
}
