package au.com.game.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConditionTest {

	@Test //Check Consecutive Condition
	public void test1() {
		char[] values= {'9','T','J','Q','K'};
		assertEquals(true, Condition.checkConsecutiveCond(values));
	}

	@Test //Check Consecutive Condition
	public void test2() {
		char[] values= {'2','Q','J','3','K'};
		assertEquals(false, Condition.checkConsecutiveCond(values));
	}
	
	@Test //Check Card Highest Value
	public void test3() {
		char[] values= {'2','8','4','T','9'};
		assertEquals(10, Condition.highestCard(values));
	}
	
	@Test //Check Pairs
	public void test4() {
		char[] values= {'2','2','J','3','K'};
		assertEquals(true, Condition.checkPairs(values));
	}
	
	@Test //Count one or two distinct pair
	public void test5() {
		char[] values= {'2','2','J','3','K'};
		assertEquals(1, Condition.countDistinctPairs(values));
	}
	
	@Test //Count one or two distinct pair
	public void test6() {
		char[] values= {'2','2','J','3','J'};
		assertEquals(2, Condition.countDistinctPairs(values));
	}
	
	@Test //Check four of same value
	public void test7() {
		char[] values= {'2','3','3','3','3'};
		assertEquals(true, Condition.check4ofSame(values));
	}
	
	@Test //Check four of same value
	public void test8() {
		char[] values= {'2','2','2','3','3'};
		assertEquals(false, Condition.check4ofSame(values));
	}
	
	@Test //Check same suit
	public void test9() {
		char[] values= {'H','H','H','H','S'};
		assertEquals(false, Condition.checkSameSuit(values));
	}
	
	@Test //Check same suit
	public void test10() {
		char[] values= {'H','H','H','H','H'};
		assertEquals(true, Condition.checkSameSuit(values));
	}
	
	@Test //Check T,J,Q,K,A in high order
	public void test11() {
		char[] values= {'T','J','Q','K','A'};
		assertEquals(true, Condition.checkRoyalFlush(values));
	}
}
