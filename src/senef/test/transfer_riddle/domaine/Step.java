package senef.test.transfer_riddle.domaine;

public class Step {
	private int tankOneContent;
	private int tankTwoContent;


	private String tankOneName;
	private String tankTwoName;
	
	public Step(String tankOneName,String tankTwoName,int tankOneContent, int tankTwoContent) {
		this.tankOneName=tankOneName;
		this.tankTwoName=tankTwoName;
		this.tankOneContent=tankOneContent;
		this.tankTwoContent=tankTwoContent;
	}
	public Step() {
		
	}
	
	
	public int getTankOneContent() {
		return tankOneContent;
	}
	public void setTankOneContent(int tankOneContent) {
		this.tankOneContent = tankOneContent;
	}
	public int getTankTwoContent() {
		return tankTwoContent;
	}
	public void setTankTwoContent(int tankTwoContent) {
		this.tankTwoContent = tankTwoContent;
	}
	public String getTankOneName() {
		return tankOneName;
	}
	public void setTankOneName(String tankOneName) {
		this.tankOneName = tankOneName;
	}
	public String getTankTwoName() {
		return tankTwoName;
	}
	public void setTankTwoName(String tankTwoName) {
		this.tankTwoName = tankTwoName;
	}
}
