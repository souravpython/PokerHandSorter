package au.com.game.poker;
import java.util.HashMap;

public class RankCombination {
	
	private HashMap<Integer,String> combination;
	
	public RankCombination(){
		
		this.combination=new HashMap<Integer,String>();
	}
	
	
	//Support Method
	private void ruleRankCombination(){
		
		combination.put(1,"High Card");
		combination.put(2,"Pair");
		combination.put(3,"Two Pairs");
		combination.put(4,"Three of a kind");
		combination.put(5,"Straight");
		combination.put(6,"Flush");
		combination.put(7,"Full House");
		combination.put(8,"Four of a kind");
		combination.put(9,"Straight Flush");
		combination.put(10,"Royal Flush");
	}

	
	//Retrieve Rank Info	
	public String getRankDetails(int rank) {
		
		ruleRankCombination();
		String rankValue="";
		for (int i : combination.keySet()) {
			if(i==rank) {
				rankValue = combination.get(i);
				}
			}
		return rankValue;
	}

}
