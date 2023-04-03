package com.yedam.hwq3;

import com.yedam.hwq1.*;

public class HomeworkQuestion3 {
	public static void main(String[] args) {
		int randomGame;
		Scanner sc = new Scanner(System.in);
		
		if(Math.random()<0.5) {
			randomGame = 0;
			RPGgame rpg = new RPGgame();
		}else {
			randomGame = 1;
			ArcadeGame archade = new ArcadeGame();
		}
		
		System.out.println("==========================================================================================================================");
		

		if(randomGame == 0) {
			System.out.println("1. Left Up | 2. Left Down | 3. Right Up | 4. Right Down | 5. Mode Change | 0. Game Change | 9. EXIT");
			System.out.println("Choice >> ");
			
			int selectNo = sc.nextInt();
			sc.nextLine();
			
			switch(selectNo) {
				case 1 :
					rpg.leftUpButton();
					break;
				case 2 :
					rpg.rightDownButton();
					break;
				case 3 :
					rpg.rightUpButton();
					break;
				case 4 :
					rpg.rightDownButton();
					break;
				case 5 :
					rpg.changeMode();
					break;
				case 0 :
					
					break;
				case 9 :
					break;
				default :
					System.out.println("없는 번호입니다. 다시 입력하세요.");
					break;
				
			}
		}else {
			switch(selectNo) {
				case 1 :
					
					break;
				case 2 :
					break;
				case 3 :
					break;
				case 4 :
					break;
				case 5 :
					break;
				case 0 :
					break;
				case 9 :
					break;
				default :
					System.out.println("없는 번호입니다. 다시 입력하세요.");
					break;
		}
		
	}
}
