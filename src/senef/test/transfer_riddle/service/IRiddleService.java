package senef.test.transfer_riddle.service;

import java.util.List;

import senef.test.transfer_riddle.domaine.Step;

public interface IRiddleService {
	public boolean solutionExist();
	public List<Step> solution();
	public void init(int tankASize,int tankBSize,int t);
}
