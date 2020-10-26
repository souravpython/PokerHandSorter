package au.com.game.poker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;

public class Game {
	
	String[] p1Input;
	String[] p2Input;
	
	public static void main(String[] args) {
		
		try {
			Hand h = new Hand();
			String[] p1Input;
			String[] p2Input;
			int p1Wins=0;
			int p2Wins = 0;
			ArrayList<String> handList = new ArrayList<String>();
			HashMap<Integer,String> gameResult = new HashMap<Integer,String>();
			File file = new File("resources/poker-hands.txt");
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				handList.add(reader.nextLine());
			}
			
			reader.close();
			for(String hand: handList) {
				String[] tempArr = hand.split(" ");
				int n = tempArr.length;
				p1Input = new String[(n+1)/2];
				p2Input = new String[n-p1Input.length];
				
				for(int i=0; i<n; i++) {
					if(i<p1Input.length) {
						p1Input[i] = tempArr[i];
					}
					else
						p2Input[i-p1Input.length]=tempArr[i];
				}
				int handId = h.getHand();
				String winner = h.handWinner(p1Input, p2Input);
				gameResult.put(handId, winner);
				}
				
				p1Wins = Collections.frequency(gameResult.values(), "P1");
				p2Wins = Collections.frequency(gameResult.values(), "P2");
				System.out.println("P1 Wins: "+p1Wins);
				System.out.println("P2 Wins: "+p2Wins);
		}
			
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
