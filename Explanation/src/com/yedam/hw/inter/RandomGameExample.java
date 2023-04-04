package com.yedam.hw.inter;

import java.util.Scanner;

public class RandomGameExample {
//	1) 프로그램을 실행할 경우 50% 확률로 두 개의 게임 중 하나가 셋팅된다.
//( RPGgame or ArcadeGame )
	public static Keypad getRandomGame() {
		Keypad game = null;
		int random = (int) (Math.random() * 2 + 1);
		switch(random) {
		case 1:
			game = new RPGgame();
			break;
		case 2:
			game = new ArcadeGame();
			break;
		}
		return game;
	} //'랜덤게임으로 출력결과는 실행 시 설정되는 게임에 따라 달라질 수 있다.'라는 조건 때문에 함수를 그냥 따로 빼서 만든 것
	  //자주 쓰는 기능은 따로 함수로 빼서 

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);

		Keypad game = getRandomGame(); //랜덤 값 1) RPG
									   //랜덤 값 2) Arcade
		
		// 만약 따로 함수를 설정하지 않았을 때, 이렇게 설정한 후 선택옵션 0번은 아래 주석과 같이 하거나 아니면 아래 함수 내용 반복해서 쓰기
//		Keypad game = null;
//		int random = (int) (Math.random() * 2 + 1);
//		switch(random) {
//		case 1:
//			game = new RPGgame();
//			break;
//		case 2:
//			game = new ArcadeGame();
//			break;
//		}

		while (run) {
			System.out.println(
					"============================================================================================");
			System.out.println(
					"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.println(
					"============================================================================================");
			System.out.print("choice>>");
			int menuNo = Integer.parseInt(sc.nextLine());

			switch (menuNo) {
			case 1:
				game.leftUpButton();
				break;
			case 2:
				game.leftDownButton();
				break;
			case 3:
				game.rightUpButton();
				break;
			case 4:
				game.rightDownButton();
				break;
			case 5:
				game.changeMode();
				break;
			case 0:
				game = getRandomGame();
//				if(game instanceof RPGgame) {
//					game = new ArcadeGame();
//				}else if(game instanceof ArcadeGame) {
//					game = new RPGgame();
//				}
				break;
			case 9:
				System.out.println("EXIT");
				run = false;
				break;
			//예외 처리
			default:
				System.out.println("메뉴를 잘못 선택하였습니다.");
			}
		}
	}
}
