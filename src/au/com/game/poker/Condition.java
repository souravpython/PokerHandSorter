package au.com.game.poker;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Character;


public class Condition {

    //Get the number of cards for a player
	public static HashMap<Character,Integer> getCardCounts(char[] cardValues) {
		HashMap<Character,Integer> cards = new HashMap<Character,Integer>();
		int count = 0;
		for(char value:cardValues) {
		count = cards.containsKey(value) ? cards.get(value) : 0;
		cards.put(value, count+1);
		}
		return cards;
	}

    //Check Consecutive Order
	public static boolean checkConsecutiveCond(char[] values) {		
		boolean cond = true;
		int[] cardValues = new int[values.length];
		for(int i=0;i<values.length;i++) {
			cardValues[i] = charToInt(values[i]);
		}
		Arrays.sort(cardValues);
		int temp = cardValues[0];
		for(int i=1;i<cardValues.length;i++) {
			if(cardValues[i] == temp+1) {
				temp = cardValues[i];
			}
			else {
				cond = false;
				break;
			}
		}
		return cond;
	}

	//For comparison
	public static int highestCard(char[] values) {
		int[] cardValues = new int[values.length];
		for(int i=0;i<values.length;i++) {
			cardValues[i] = charToInt(values[i]);
		}
		int highestCardValue = cardValues[0];
		for(int value:cardValues) {
			if(value>highestCardValue) {
				highestCardValue=value;
			}
		}
		return highestCardValue;		
	}
	
	//Splitting input value
	public static char splitInputValue(String input) {
		return input.charAt(0);
	}
	
	//Splitting input character
	public static char splitInputSuit(String input) {
		return input.charAt(1);
	}
	
	//Check a pair
	public static boolean checkPairs(char[] cardValues) {
		boolean present = false;
		HashMap<Character,Integer> counts = getCardCounts(cardValues);
		for(char i:counts.keySet()) {
			if(counts.get(i)==2) {
				present = true;
			}
		}
		return present;
	}
	
	//Count one or two distinct pair
	public static int countDistinctPairs(char[] cardValues) {
		int pair = 0;
		HashMap<Character,Integer> counts = getCardCounts(cardValues);
		for(char i:counts.keySet()) {
			if(counts.get(i)==2) {
				pair++;
			}
		}
		return pair;
	}
	
	//Check three of a kind
	public static boolean check3of1Kind(char[] cardValues) {
		boolean present = false;
		HashMap<Character,Integer> counts = getCardCounts(cardValues);
		for(char i:counts.keySet()) {
			if(counts.get(i)==3) {
				present = true;
			}
		}
		return present;	
	}
	
	//Check four of same value
	public static boolean check4ofSame(char[] cardValues) {
		boolean present = false;
		HashMap<Character,Integer> counts = getCardCounts(cardValues);
		for(char i:counts.keySet()) {
			if(counts.get(i)==4) {
				present = true;
			}
		}
		return present;	
	}

	//Check same suit
	public static boolean checkSameSuit(char[] cardSuits) {
		boolean sameSuit = false;
		HashMap<Character,Integer> counts = getCardCounts(cardSuits);
		for(char i:counts.keySet()) {
			if(counts.get(i)==5) {
				sameSuit = true;
			}
		}
		return sameSuit;
	}
	
	//Check Royal Flush
	public static boolean checkRoyalFlush(char[] cardValues) {
		char[] values= {'T','J','Q','K','A'};
		int count = 0;
		Arrays.sort(cardValues);
		char[] distinctArr = removeDuplicates(cardValues);
		for(char value: values) {
			for(int i = 0; i<distinctArr.length; i++) {
				count = (value == distinctArr[i])?count+1:count;
			}
		}
		boolean royalFlush = (count == 5)?true:false;
		return royalFlush;
	}
	
	//Convert input character to integer
	public static int charToInt(char input) {
		char[] elements= {'T','J','Q','K','A'};
		if(checkElement(elements,input)) {
			return charToDigit(input);
		}
		else {
			return Integer.parseInt(String.valueOf(input));
		}
	}
	
	// Check two ranks tie
	public static String tieCheck4ofSame(HashMap<Character,Integer> m1, HashMap<Character,Integer> m2 ) {
		int temp1=0,temp2=0;
		int flag=0;
		for(char i:m1.keySet()) {
			if(m1.get(i)==4) {
				temp1 = charToInt(i);
				flag++;
			}
		}
		for(char j:m2.keySet()) {
			if(m2.get(j)==4 && flag==1) {
				temp2 = charToInt(j);
			}
		}
		String winner = (temp1>temp2)?"P1":(temp1<temp2)?"P2":"";
		return winner;
	}
	
	public static String tieCheck3of1Kind(HashMap<Character,Integer> m1, HashMap<Character,Integer> m2 ) {
		int temp1=0,temp2=0;
		int flag=0;
		for(char i:m1.keySet()) {
			if(m1.get(i)==3) {
				temp1 = charToInt(i);
				flag++;
			}
		}
		for(char j:m2.keySet()) {
			if(m2.get(j)==3 && flag==1) {
				temp2 = charToInt(j);
			}
		}
		String winner = (temp1>temp2)?"P1":(temp1<temp2)?"P2":"";
		return winner;
	}
	 
	public static byte  tieCheckPairs(HashMap<Character,Integer> m1, HashMap<Character,Integer> m2) {
		byte res=0;
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a1=generateKeys(m1,2);
		a2=generateKeys(m2,2);
		if(!a1.equals(a2)) {
			for(int i=0;i<a1.size();i++) {
				if(a1.get(i)!=a2.get(i)) res=compareUneq(a1.get(i),a2.get(i));
				else continue;
			}
			return res;
		}else {
			res = checkHighestCard(m1,m2);
			return res;
		}
		
	}
	
	public static String[] addElements(String entries, int range) {
		String[] arr = new String[range];
		for(int i=0;i<5;i++) {
			arr[i]=entries;
		}
		return arr;
	}
		
    //Support Methods
	
	private static byte checkHighestCard(HashMap<Character,Integer> m1, HashMap<Character,Integer> m2) {
		byte res=0;
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a1=generateKeys(m1,1);
		a2=generateKeys(m2,1);
		if(!a1.equals(a2)) {
			for(int i=0;i<a1.size();i++) {
				if(a1.get(i)!=a2.get(i)) res=compareUneq(a1.get(i),a2.get(i));
				else continue;
			}
		}
		return res;
	}
	
	private static ArrayList<Integer> generateKeys(HashMap<Character,Integer> m,int ofValue){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		if(m.containsValue(ofValue)) {
			for(char i:m.keySet()) {
				if(m.get(i)==ofValue) arrList.add(charToInt(i));
			}
		}
		if(!arrList.isEmpty()) Collections.sort(arrList);
		return arrList;
	}
	
	private static byte compareUneq(int a, int b) {
		byte res = (byte) ((a>b)?1:2);
		return res;
	}
	
 	private static int charToDigit(char cardValue) {
		int value = 0;
		switch(Character.toUpperCase(cardValue)){
		case 'T':value = 10;break;
		case 'J':value = 11;break;
		case 'Q':value = 12;break;
		case 'K':value = 13;break;
		case 'A':value = 14;break;
		default: break;
		}
		return value;
	}	

	private static char[] removeDuplicates(char[] values) {  
		int size=values.length;
		int newSize,n=0,k=0;
		char[] newArr;
        for (int i=0; i < size-1; i++){  
            if (values[i] != values[i+1]){  
                values[k++] = values[i];  
            }  
        }  
        values[k++] = values[size-1];  
        newSize=k;
        newArr= new char[newSize];
        for(int i=0;i<newArr.length;i++) {
        	newArr[i]=values[n];
        	n++;
        }
        return newArr;
}

	private static boolean checkElement(char[] elements,char key) {
		Arrays.sort(elements);
		int res = Arrays.binarySearch(elements, key);
		boolean present = (res>=0)?true:false;
		return present;
	}
	
}

