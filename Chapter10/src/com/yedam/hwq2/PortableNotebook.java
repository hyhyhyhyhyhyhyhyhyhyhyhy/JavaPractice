package com.yedam.hwq2;

public class PortableNotebook implements Notebook, Tablet {

	//필드
	int mode = NOTEBOOK_MODE;
	String document;
	String url;
	String videoType;
	String appType;
	
	
	//생성자
	public PortableNotebook(){
		
	}
	
/*	public PortableNotebook(String document) {
		this.document = document;
	}
	
	public PortableNotebook(String url) {
		this.url = url;
	}
	
	public PortableNotebook(String videoType) {
		this.videoType = videoType;
	}
	
	public PortableNotebook(String appType) {
		this.appType = appType;
	} */
	
	public PortableNotebook(String document, String url, String videoType, String appType) {
		this.document = document;
		this.url = url;
		this.videoType = videoType;
		this.appType = appType;
	}
	
	
	//메소드
	
	@Override
	public void watchVideo() {
		System.out.println(this.videoType + "를 시청.");
	}
	
	@Override
	public void useApp() {
		if(mode == NOTEBOOK_MODE) {
			mode = TABLET_MODE;
			System.out.println(this.appType + "를 실행.");
		}else {
			System.out.println(this.appType + "를 실행.");
		}
	}
	
	@Override
	public void writeDocumentaion() {
		System.out.println(this.document + "을 통해 문서를 작성.");
	}
	
	@Override
	public void searchInternet() {
		System.out.println(this.url + "를 통해 인터넷을 검색.");
	}
	
	public void changeMode() {
		if(mode == NOTEBOOK_MODE) {
			mode = TABLET_MODE;
		}else {
			mode = NOTEBOOK_MODE;
		}
	}
	

}
