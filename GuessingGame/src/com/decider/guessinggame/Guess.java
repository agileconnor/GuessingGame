package com.decider.guessinggame;

import java.util.Random;


public class Guess {
	
	public static int getWinner(String p1Value, String p2Value, String p3Value, String p4Value, final int rNumber) {
		int p1Number = 0, p2Number = 0, p3Number = 0, p4Number = 0;
		if (p1Value.length() > 0) {
			p1Number = Integer.parseInt(p1Value);
		}
		if (p2Value.length() > 0) {
			p2Number = Integer.parseInt(p2Value);
		}
		if (p3Value.length() > 0) {
			p3Number = Integer.parseInt(p3Value);
		}
		if (p4Value.length() > 0) {
			p4Number = Integer.parseInt(p4Value);
		}
		
		int winner = 0;
		if (p1Number == rNumber ) {
			winner = 1;
		}
		if (p2Number == rNumber) {
			winner = 2;
		}
		if (p3Number == rNumber) {
			winner = 3;
		}
		if (p4Number == rNumber) {
			winner = 4;
		}
		if (winner == 0) {
			winner = getClosest(p1Number, p2Number, p3Number, p4Number, rNumber);
		}
		return winner;
	}
	
	public static int getClosest(int p1Num, int p2Num, int p3Num, int p4Num, final int rNum) {
		int closest = 1;
		int small;
		p1Num = getDifference(p1Num, rNum);
		p2Num = getDifference(p2Num, rNum);
		p3Num = getDifference(p3Num, rNum);
		p4Num = getDifference(p4Num, rNum);
		small = p1Num;
		if (p2Num < small) {
			small = p2Num;
			closest = 2;
		}
		if (p3Num < small) {
			small = p3Num;
			closest = 3;
		}
		if (p4Num < small) {
			small = p4Num;
			closest = 4;
		}
		return closest;
	}
	
	public static int randomInteger(int Start, int End) {
        Random random = new Random();
		long range = (long)End - (long)Start + 1;
        long fraction = (long)(range * random.nextDouble());
        int randomNumber = (int)(fraction + Start);
        return randomNumber;
    }
	
	public static int getDifference(int num, final int rNum) {
		if (num != 0) {
			num = Math.abs(num - rNum);
		}else{
			num = 100;
		}
		return num;
	}
	

}
