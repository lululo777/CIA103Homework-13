package hw5;

public class Homework5 {
//	第一題
//請設計一個方法為starSquare(int width, int height),當使用者鍵盤輸入寬與高時,即會印出對應的*長方形
	
//	height為高，代表層，用外迴圈。width為寬，代表每層內數量，用內迴圈
	public void starSquare(int width,int height) {
		for(int i=1;i<=height;i++) {
			for(int j=1;j<=width;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
//	第二題
//	請設計一個方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值並印出這10個亂數與平均值
	
	public void randAvg() {
		int[]array = new int[10];
		
//		將亂入存入陣列
		for(int i=0;i<10;i++) {
			array[i]=(int)(Math.random()*101); //0-100共101個數
			System.out.print(array[i]+"\t");
		}
		
		System.out.println();
//		計算平均值並印出
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=array[i];
		}
		System.out.println(sum/10);
	}
	
//	第三題
//	利用Overloading,設計兩個方法int maxElement(int x[][])與double maxElement(double x[][]),
//	可以找出二維陣列的最大值並回傳
	public int maxElement(int x[][]) {
		int max=0;
		for(int i=0;i<x.length;i++) {
			max=x[0][0];
			for(int j=0;j<x[i].length;j++) {
//				如果找到比當前最大值大的元素，該元素取代之成為最大值
				if(x[i][j]>max) {
					max=x[i][j];
					
				}
			}
		}
		
		return max;
	}
	
//	overloading:方法名稱相同，但參數型別或數量不同
	public double maxElement(double x[][]) {
		double max=0.0;
		for(int i=0;i<x.length;i++) {
			max=x[0][0];
			for(int j=0;j<x[i].length;j++) {
//				如果找到比當前最大值大的元素，該元素取代之成為最大值
				if(x[i][j]>max) {
					max=x[i][j];
					
				}
			}
		}
		
		return max;
	}
	
	
//  第五題
//	身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,請設計一個方法
//	genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,此驗證碼內容包含了英文大小寫
//	與數字的亂數組合
	
	public void genAuthCode() {
		System.out.println("本次隨機產生驗證碼為");
		
//		準備一字元陣列，存放取出的隨機字元
		char[]randomArray=new char[8];
		
//		透過迴圈將隨機字母和數字存入字元陣列
		for(int i=0;i<randomArray.length;i++) {
//			準備0-2三個隨機數，每次迴圈進行時都會更新值，代表隨機取出大寫、小寫、數字這三種類型
			int randomNum=(int)(Math.random()*3);
			
			switch(randomNum) {
//			當隨機數等於0時，隨機取一大寫英文字存入陣列
			case 0:
				//A-Z，共26個英文字。從A開始，加上0-25的隨機數，可隨機取出65(A)-90(Z)的字元，再將整數轉換為字元型別放入陣列
				randomArray[i]=(char)('A'+(int)(Math.random()*26)); 
				break;
//			當隨機為1時，隨機取一小寫英文存入陣列
			case 1:
				randomArray[i]=(char)('a'+(int)(Math.random()*26));
				break;
//			當隨機數為2時，隨機取0-9的一個數存入陣列
			case 2 :
				randomArray[i]=(char)('0'+(int)(Math.random()*10));
				break;
			}
			System.out.print(randomArray[i]);
		}
			
	}
	
	
}
