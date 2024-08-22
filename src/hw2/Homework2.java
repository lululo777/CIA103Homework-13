package hw2;

public class Homework2 {
	public static void main(String[] args) {
//	1.請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum = 0;
		for (int i = 0; i <= 1000; i += 2) {
			sum += i;
		}

		System.out.println(sum);
//	2.請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int product = 1;
		for (int i = 1; i <= 10; i++) {
			product *= i;
		}

		System.out.println(product);
//	3.請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int total = 1;
		int multi = 1; //迴圈初始值
		while (multi <= 10) {
			total *= multi;
			multi++;
		}

		System.out.println(total);
//	4.請設計一隻Java程式,輸出結果為以下:
//	1 4 9 16 25 36 49 64 81 100
		for (int i = 1; i <= 10; i++) {
			System.out.print(i * i + " ");
		}

		System.out.println();
//	5.阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,
//	輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
//十位數需檢查、個位數也需檢查，十位數執行一次，個位數執行十次

		
		int count = 0; //計數器，每次有印出就執行+1，宣告在迴圈之外因此離開迴圈才可使用
		for (int tens = 0; tens < 50; tens += 10) { //外迴圈代表十位數，以10為單位做累加
			for (int unit = 0; unit < 10; unit++) { // 內迴圈表示個位數，0-9
				int ableNumber = tens + unit; //寫在內迴圈中才可得總和
				//跳過數字0
				if(ableNumber==0) {
					continue;
				}
				//40以上的數直接離開迴圈
				if (ableNumber >= 40) { 
					break;
				}
				//跳過個位數4的數
				if (unit == 4) { 
					continue;
				}
				//不符合以上條件者印出，且計數器累加1
				System.out.print(ableNumber + " ");
				count += 1; 
			}
		}
		System.out.println();
		System.out.println("可選的數字一共有:" + count + "個");

//	6.請設計一隻Java程式,輸出結果為以下:
//	1 2 3 4 5 6 7 8 9 10
//	1 2 3 4 5 6 7 8 9
//	1 2 3 4 5 6 7 8
//	1 2 3 4 5 6 7
//	1 2 3 4 5 6
//	1 2 3 4 5
//	1 2 3 4
//	1 2 3
//	1 2
//	1
//		//外迴圈代表有幾層，從1遞增到10
		for (int i = 1; i <= 10; i++) { 
			int printNum = 0; // 宣告一變數存放每次一層中要印出的數，需寫在外迴圈之內，內迴圈之外，那麼內迴圈結束時進入下一層之前，才會將數重置為0
			for (int j = 10; j >= i; j--) { // 決定每層印出幾個數，數量從10遞減到1
				printNum += 1; // 每一次印出的數都累加1，內迴圈結束會回到初始值0重新開始
				System.out.print(printNum + " ");
			}
			System.out.println();// 外迴圈控制層，做換行動作
		}
//	7.請設計一隻Java程式,輸出結果為以下:
//	A
//	BB
//	CCC
//	DDDD
//	EEEEE
//	FFFFFF
//	'A'=>char 65

		int wordNum = 65; //須放在迴圈之外，否則每次迴圈都會重置字母從A開始
		for (int i = 1; i <= 6; i++) {
			char charactor = (char) wordNum; //需要放在外迴圈之內，在換層時才轉換為字元，每層印出相同字。放在迴圈之外會直接轉換成A
			for (int j = 1; j <= i; j++) { //內迴圈決定每層印出的數量
				System.out.print(charactor);
			}
			//外迴圈執行換行、將數值累加1，變更字元編號
			System.out.println();
			wordNum++;
		}

	}
}
