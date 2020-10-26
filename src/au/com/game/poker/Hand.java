package au.com.game.poker;
public class Hand {
	
	private int handId;
	private String winner;
	
	public Hand() {
		this.handId = 1;
		this.winner="";
	}
	
	public String handWinner(String[] p1Input, String[] p2Input) {
		handId++;
		Rank r = new Rank();
		int player1rank = r.getRank(p1Input);
		int player2rank = r.getRank(p2Input);
		r.setRank(player1rank,player2rank);
		String performer = (player1rank>=player2rank)?(player1rank == player2rank)?r.gameWinnerTie(p1Input, p2Input):"P1":"P2";
		this.setWinner(performer);
		return winner;
		}
	
	public int getHand() {
		return handId;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner=winner;
	}

}