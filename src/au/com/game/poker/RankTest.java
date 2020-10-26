package au.com.game.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

	@Test //Test Rank
	public void test1() {
		Rank r = new Rank();
		String[] input = {"4D","6S","9H","QH","QC"};
		assertEquals(2,r.getRank(input));
	}
	
	@Test
	public void test2() {
		Rank r = new Rank();
		String[] input = {"2H","2D","4C","4D","4S"};
		assertEquals(7,r.getRank(input));
	}
	
	@Test //Tie Winner
	public void test3() {
		Rank r = new Rank();
		String[] p1Input = {"2H","2D","4C","4D","4S"};
		String[] p2Input = {"3C","3D","3S","9S","9D"};
		assertEquals("P1",r.gameWinnerTie(p1Input, p2Input));
	}

}
