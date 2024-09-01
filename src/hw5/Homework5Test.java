package hw5;

import java.util.Scanner;

public class Homework5Test {
	
	public static void main(String[] args) {
//		第一題
		System.out.println("請輸入寬和高:");
		Scanner sc=new Scanner(System.in);
		int width=sc.nextInt();
		int height=sc.nextInt();
		
		Homework5 h=new Homework5();
		h.starSquare(width, height);
		
		System.out.println("=======================================");
		
//		第二題
		System.out.println("本次的亂數結果:");
		h.randAvg();
		
		System.out.println("=======================================");
		
//		第三題
		int[][]intArray= {{1,6,3},{9,5,2}};
		double[][]doubleArray={{1.2,3.5,2.2},{7.4,2.1,8.2}};
		
		System.out.println(h.maxElement(intArray));
		System.out.println(h.maxElement(doubleArray));
		
		System.out.println("=======================================");
		
//		第五題
		h.genAuthCode();
		
		sc.close();//關閉鍵盤輸入，釋放資源
	}
}
