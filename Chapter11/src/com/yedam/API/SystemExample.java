package com.yedam.API;

public class SystemExample {
	public static void main(String[] args) {
		//System클래스
		//System.exit(0)
		
		for(int i = 0; i<=10; i++) {
			System.out.println(i);
			if(i == 5) {
//				System.exit(0); //약간 필기체로 되어있는게 static으로 설정되어 있어서 어디서든 사용가능하다. 시스템 클래스는 웬만해선 전부 정적(=static)으로 많이 되어 있음
				break;
			}
		}
		System.out.println("프로그램 종료"); //break로 끝났으면 이 구문이 실행되어야 함
		
		//But!! 최대한 쓰지 말도록! '능.숙.하.게' 쓸 수 있을 때만 쓰도록,
		//출시한 프로그램에 테스트 한다고 넣어놨다가 그대로 출시해서 시스템이 계속 강제종료가 되는 경험을 하게될 수 있음
		
		
		
		//현재 시간 읽기
		long time = System.nanoTime();
		
		int sum = 0;
		
		for(int i=0; i<=1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime();
		
		System.out.println(time);
		System.out.println(time2);
		System.out.println("1~1000000의 합 : " + sum);
		System.out.println("소요 시간 : " + (time2-time) + "나노 초 소요");
		
		System.out.println(System.currentTimeMillis());
	}
}
