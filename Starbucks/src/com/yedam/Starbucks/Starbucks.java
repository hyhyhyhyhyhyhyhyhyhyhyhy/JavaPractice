package com.yedam.Starbucks;

import lombok.Data;

@Data

public class Starbucks {

//	COFFEE_MENU    NOT NULL VARCHAR2(30)   
//	COFFEE_PRICE   NOT NULL NUMBER         
//	COFFEE_EXPLAIN          VARCHAR2(1000) 
//	COFFEE_SALES            NUMBER
	
	private String coffeeMenu;
	private int coffeePrice;
	private String coffeeExplain;
	private int coffeeSales;
	
}
