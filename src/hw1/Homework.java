package hw1;

public class Homework {
 
	public static void main(String[]args) {
		  //第一題
		  int x=12;
		  int y=6;
		  int sum = x+y;
		  int product = x*y;
		  
		  System.out.println("和:"+sum+"積:"+product);
		  
		  //第二題
		  int dozen = 200/12;
		  int remain = 200%12;
		  
		  System.out.println(dozen + "打"+ remain + "顆");
		  
//		  //第三題
		  
		  int num = 256559; 
		  int e = 60*60*24; //天換算成秒的方式
		  int day = num/e; //2
		  int hour =(num%e)/3600; //(總秒數換成天之後剩下的秒數)再除以3600換算成小時
		  int min = ((num%e)-(hour*3600))/60; // 總秒數扣掉天之後的秒數-換算後的小時，最後將秒換成單位為分鐘
		  int sec = (num%e)-(hour*3600)-(min*60); // 總秒數扣掉天、扣掉小時、扣掉分即為秒
		  System.out.println(day+"天"+hour+"小時"+min+"分"+sec+"秒");
		  
		  //第四題
		  final double PI = 3.1415;
		  int r = 5;
		  double area = PI*Math.pow(r, 2);
		  double perimeter = 2*PI*r;
		  
		  System.out.printf("面積:%.2f%n周長:%.2f%n",area,perimeter);
		  
		  //第五題
		  long money =1500000;
		  double total = money*(Math.pow(1.02,10));
		  //以上也可以使用for來計算
//		  for(int i =1;i<=10;i++){
//		     money += (money*0.02);
//		    }
//		    
		  System.out.printf("%.2f%n",total); //使用printf(前面放文字資訊在字串中，加上%.2f%n，逗點後放要輸出的變數，需對應順序)
		  
		    
		  //第六題
		  System.out.println(5+5); //兩個運算元皆為整數，整數相加為10
		  System.out.println(5+'5'); //因為'5'的資料型別是char，對照unicode的編號為35，十六進制轉換十位進制為53，53+5=58
		  System.out.println(5+"5"); //整數和字串相加會做串接的動作，所以會印出55
		  
		  
	}
	
	
  
  
}
