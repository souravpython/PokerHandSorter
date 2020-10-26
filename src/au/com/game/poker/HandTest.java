package au.com.game.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandTest {

	@Test //Check winner Player 2
	public void test1() {
		Hand test = new Hand();
		String[] p1Input = {"4H","4C","6S","7S","KD"};
		String[] p2Input = {"2C","3S","9S","9D","TD"};
		assertEquals("P2",test.handWinner(p1Input,p2Input));
	}
	
	@Test
	public void test2() {
		Hand test = new Hand();
		String[] p1Input = {"2D","9C","AS","AH","AC"};
		String[] p2Input = {"3D","6D","7D","TD","QD"};
		assertEquals("P2",test.handWinner(p1Input,p2Input));
	}
	
	@Test //Check winner Player 1
	public void test3() {
		Hand test = new Hand();
		String[] p1Input = {"5D","8C","9S","JS","AC"};
		String[] p2Input = {"2C","5C","7D","8S","QH"};
		assertEquals("P1",test.handWinner(p1Input,p2Input));
	}
	
	@Test
	public void test4() {
		Hand test = new Hand();
		String[] p1Input = {"4D","6S","9H","QH","QC"};
		String[] p2Input = {"3D","6D","7H","QD","QS"};
		assertEquals("P1",test.handWinner(p1Input,p2Input));
	}
	
	@Test
	public void test5() {
		Hand test = new Hand();
		String[] p1Input = {"2H","2D","4C","4D","4S"};
		String[] p2Input = {"3C","3D","3S","9S","9D"};
		assertEquals("P1",test.handWinner(p1Input,p2Input));
	}
	
	@Test //Get HandId
	public void test6() {
		Hand test = new Hand();
		assertEquals(1,test.getHand());
	}

}
