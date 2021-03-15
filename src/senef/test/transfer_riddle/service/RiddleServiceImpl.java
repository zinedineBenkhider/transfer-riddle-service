package senef.test.transfer_riddle.service;

import java.util.ArrayList;
import java.util.List;

import senef.test.transfer_riddle.domaine.*;

public class RiddleServiceImpl implements IRiddleService {
	private Tank tankA;
	private Tank tankB;
	private int t;
	
	public RiddleServiceImpl() {
		this.tankA=new Tank(0,"A");
		this.tankB=new Tank(0,"B");
		this.t=0;
	}
	
	public void init(int tankASize,int tankBSize,int t) {
		this.tankA.setSize(tankASize);
		this.tankB.setSize(tankBSize);
		this.t=t;
	}

	
	/*Check if this Riddle have solution
	 * Return true if gcd(A,B) / t and t<max(A,B) or tankASize=tankBSize=t=0
	 */
	public boolean solutionExist() {
		int gcd=gcd(tankA.getSize(),tankB.getSize());
		if(gcd==0) {
			return t==0?true:false;
		}
		return t % gcd==0 && t<=Math.max(tankA.getSize(), tankB.getSize());
	}

	/*
	 * Calculate the solution in both directions and take the most optimal
	 */
	public List<Step> solution(){
		List<Step> stepsSolOne=this.solution(this.tankA, this.tankB);
		this.tankA.empty();
		this.tankB.empty();
		List<Step> stepsSolTwo=this.solution(this.tankB, this.tankA);
		return stepsSolOne.size()<stepsSolTwo.size()?stepsSolOne:stepsSolTwo;
	}
	
	/*
	 * Calculate solution with this method
	 * if tenkTwo is empty fill up it
	 * else if tankOne is't full and tankTwo is'nt empty: cross Content of tankTwo to tankOne
	 * else if tankOne is full empty it
	 */
	private List<Step> solution(Tank tankOne, Tank tankTwo) {
		List<Step> steps=new ArrayList<>();
		boolean allConfigsBrowsed=false;
		tankTwo.fillUp();
		Step fillUp=new Step("*",tankTwo.getName(),tankA.getContent(), tankB.getContent());
		steps.add(fillUp);
		while(!allConfigsBrowsed) {
			if(tankOne.getContent()==this.t || tankTwo.getContent()==this.t) {//Solution founded
				return steps;
			}
			if(tankTwo.isEmpty()) {//Fill Up X : *->X
				tankTwo.fillUp();
				Step fillUpB=new Step("*",tankTwo.getName(),tankA.getContent(), tankB.getContent());
				steps.add(fillUpB);
			}
			else if(!tankOne.isFull() && !tankTwo.isEmpty()) {//Cross content:X->Y
				tankTwo.crossContentTo(tankOne);
				Step crossContent=new Step(tankTwo.getName(),tankOne.getName(),tankA.getContent(), tankB.getContent());
				steps.add(crossContent);
			}
			else if(tankOne.isFull()) {//Empty content:X->*
				tankOne.empty();
				Step emptyContent=new Step(tankOne.getName(),"*",tankA.getContent(), tankB.getContent());
				steps.add(emptyContent);
			}
			if(tankTwo.isFull() && tankOne.isEmpty()) {//All Configs browsed
				allConfigsBrowsed=true;
			}
		}
		return steps;
	}
	
	/*
	 * calculate the greatest common divisor 
	 */
	private static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }
}
