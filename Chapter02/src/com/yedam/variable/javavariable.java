package com.yedam.variable;

public class javavariable {
	public static void main(String[] args) {
		//v1 변수 생성 후 15의 값을 초기화.
		int v1= 15;
		
		if(v1>10) {
			int v2 = v1 -10;
		}
		//int v3 = v1 + v2;
		//v2는 함수 안에 들어있는 애라 이렇게 밖에 들어 있으면 안됨
	}
	//v1 = 10;
	//사용할 수 있는 범위 밖으로 벗어나있기 때문에 얘도 사용할 수 없음
	int v4;
	//v1 = v1 +v4;
}
