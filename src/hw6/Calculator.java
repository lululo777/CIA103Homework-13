package hw6;

import java.util.InputMismatchException;

public class Calculator {
//	請設計三個類別Calculator.java,CalException.java與CalTest.java,在Calculator.java裡有個自訂
//	方法為powerXY(int x, int y),功能是會計算x的y次方並回傳結果。 CalTest.java執行後,使用者可
//	以輸入x與y的值,請加入例外處理機制,讓程式能解決以下狀況:
	
//	1. x與y同時為0,(產生自訂的CalException例外物件)
//	2. y為負值,而導致x的y次方結果不為整數
//	3. x與y皆正確情況下,會顯示運算後結果
	
//	拋出自訂例外的方法
	public int powerXY(int x,int y) throws CallException {
		if(x==0 && y==0) {
			throw new CallException("0的0次方沒有意義");
		}else if(y<0) {
			throw new CallException("次方為負值結果回傳不為整數!");
		} else {
			return (int)Math.pow(x, y);
		}	
		
	}
	
	
}
