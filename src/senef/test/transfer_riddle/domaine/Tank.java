package senef.test.transfer_riddle.domaine;

public class Tank {
	private int size;
	private int content;
	private String name;
	public Tank(int size,String name) {
		this.size=size;
		this.content=0;
		this.name=name;
	}

	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		 this.size=size;
	}
	
	/*
	 * The content of this tank decreases with the value that remains at the other tank to fill.
	 * And the content of the other tank increase with the old value of this tank.
	 */
	public void crossContentTo(Tank otherTank) {
		int contentTmp=this.content;
		this.content=Math.max(this.content-otherTank.remainTobeFull(),0);
		otherTank.content=Math.min(otherTank.content+contentTmp, otherTank.size);
	}
	
	public int remainTobeFull() {
		return this.size-this.content;
	}

	public int getContent() {
		return this.content;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isEmpty() {
		return this.content==0;
	}
	
	public boolean isFull() {
		return this.content==this.size;
	}
	
	public void fillUp() {
		this.content=this.size;
	}
	
	public void empty() {
		this.content=0;
	}
}
