package com.yedam.reference;

public class Example01 {

	public static void main(String[] args) {
		// stack 영역에 intVal가 생성되어 10이라는 데이터가 저장 > 기본타입이라 바로 데이터 출력
		int intVal= 10;
		
		//참조타입
		//stack 영역에 array가 생성(참조[I@5594a1b5)가 되고 다음과 같은 주소가 저장되어 있다
		
		int[] array = {1,2,3,4,5,6};
		int[] array2 = {1,2,3,4,5,6};
		int[] array3 = null;
		
		System.out.println(array);
		//array의 참조된 주소가 출력됨
		System.out.println(array2);
		//데이터의 내용은 같지만 데이터가 저장된 공간이 다름
		System.out.println(array == array2);
		//참조타입은 참조된 주소를 비교하기 때문에 데이터의 내용은 같지만 false가 나옴
		System.out.println(array3);
		//데이터가 없어서 주소도 없다
//		System.out.println(array3.length);
//		데이터가 없으니 배열의 길이도 알 수 없어서 실행하면 오류 뜸
	}

}
