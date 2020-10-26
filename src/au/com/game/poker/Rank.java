package au.com.game.poker;
import java.util.HashMap;

public class Rank {
	
	private int p1Rank;
	private int p2Rank;
	private int len;
	private char[] cardValues;
	private char[] cardSuits;
	
	public Rank() {
		this.p1Rank = 1;
		this.p2Rank = 1;
	}
	
	public int getRank(String[] inputCards) {
		int rank=1;
		splitString(inputCards);
		switch(rank) {
		case 1: rank = (Condition.highestCard(cardValues)>1)?1: rank;
		case 2: rank = (Condition.checkPairs(cardValues))?2: rank;
		case 3: rank = (Condition.countDistinctPairs(cardValues)==2)?3:rank;
		case 4: rank = (Condition.check3of1Kind(cardValues))?4:rank;
		case 5:	rank = (Condition.checkConsecutiveCond(cardValues))?5:rank;
		case 6: rank = (Condition.checkSameSuit(cardSuits))?6:rank;
		case 7:	rank = (Condition.check3of1Kind(cardValues)&&Condition.checkPairs(cardValues))?7:rank;
		case 8:	rank = (Condition.check4ofSame(cardValues))?8:rank;
		case 9:	rank = (Condition.checkConsecutiveCond(cardValues)&&Condition.checkSameSuit(cardSuits))?9:rank;
		case 10:rank = (Condition.checkRoyalFlush(cardValues)&&Condition.checkSameSuit(cardSuits))?10:rank;
				break;
		default:rank = 0;break;
		}
		return rank;
	
	  }
	
	public void setRank(int p1Rank,int p2Rank) {
		this.p1Rank = p1Rank;
		this.p2Rank = p2Rank;
	}
	
	public String gameWinnerTie(String[] p1Input, String[] p2Input) {
		int start =1;
		String winner="";
		splitString(p1Input);
		HashMap<Character,Integer> p1Values = Condition.getCardCounts(cardValues);
		splitString(p2Input);
		HashMap<Character,Integer> p2Values = Condition.getCardCounts(cardValues);
		switch(start) {
		case 1:winner = Condition.tieCheck4ofSame(p1Values, p2Values);
						if(winner!="")break;
		case 2:winner = Condition.tieCheck3of1Kind(p1Values, p2Values);
						if(winner!="")break;
		case 3:winner = (Condition.tieCheckPairs(p1Values, p2Values)==1)?"P1":"P2";
						if(winner!="")break;
		default: winner="";break;
		}
		return winner;
	}
	
	private void splitString(String[] inputCards) {
		len = inputCards.length;
		cardValues=new char[len];
		cardSuits=new char[len];
		for(int i=0; i<inputCards.length; i++) {
			cardValues[i]=Condition.splitInputValue(inputCards[i]);
			cardSuits[i]=Condition.splitInputSuit(inputCards[i]);
		}
	}

	public int getP1Rank() {
		return p1Rank;
	}

	public int getP2Rank() {
		return p2Rank;
	}
	 
	
}