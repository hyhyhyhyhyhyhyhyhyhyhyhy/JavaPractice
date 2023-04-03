package com.yedam.hwq1;

public class HomeworkQuestion1 {

	public static void main(String[] args) {
		
		RPGgame rpg = new RPGgame();
		rpg.leftUpButton();
		rpg.rightUpButton();
		rpg.changeMode();
		rpg.rightUpButton();
		rpg.rightDownButton();
		rpg.leftDownButton();
		rpg.changeMode();
		rpg.rightDownButton();
		
		System.out.println("========================");
		
		ArcadeGame arcade = new ArcadeGame();
		arcade.leftUpButton();
		arcade.rightUpButton();
		arcade.leftDownButton();
		arcade.changeMode();
		arcade.rightUpButton();
		arcade.leftUpButton();
		arcade.rightDownButton();

	}
}
