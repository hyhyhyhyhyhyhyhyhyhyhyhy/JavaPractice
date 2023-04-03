package com.yedam.hwq2;

public class HomeworkQuestion2 {

	public static void main(String[] args) {
		
		PortableNotebook portableNB = new PortableNotebook("한글2020", "크롬", "영화", "안드로이드앱");
		
		System.out.println("NOTEBOOK_MODE");
		portableNB.writeDocumentaion();
		portableNB.watchVideo();
		
		System.out.println("TABLET_MODE");
		portableNB.useApp();
		portableNB.searchInternet();
		
		
		

	}

}
