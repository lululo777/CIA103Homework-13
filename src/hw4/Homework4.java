package hw4;

import java.util.Scanner;

public class Homework4 {
	
//	(第一題計算平均數的方法)
	public int average(int[]array) {
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		return sum/array.length;
	}
	
//	(第一題印出大於平均數的方法)
	public void print(int[]array,int avg) {
		for(int i=0;i<array.length;i++) {
			if(array[i]>avg) {
				System.out.print(array[i]+" ");
			}
		}
	}
	
//	(為第二題的反轉字串的方法)
	public void reverse(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.substring(i, i + 1));
		}
	}
	
	
//	(第三題找出母音的方法)
	public int findVowel(String[]array) {
		int count =0;
		//第一個迴圈取出陣列每個元素，第二層迴圈取出每個元素的每個字做比對
		for(int k=0;k<array.length;k++) {
			for(int j=0;j<array[k].length();j++) {
				String string =array[k].substring(j,j+1); //每個取出的英文字
				if("aeiou".contains(string)) { //.contain可檢查()中的字串是否被包含於前者字串當中，返回布林值
					count+=1;
				}
			}
		}
		return count;
	}
	
	public static void main(String[]args) {
		
//		產生hw物件
		Homework4 hw = new Homework4();
		
//	第一題:
//	有個一維陣列如下:
//	{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//	請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
	
	int[]array1 = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
	
//	呼叫averge方法取得平均數
	System.out.println("平均值為:"+hw.average(array1));
//	呼叫print方法，並放入平均數做為參數，印出所有大於平均的元素
	System.out.print("大於平均值的元素:");
	hw.print(array1,hw.average(array1));
	
	System.out.println();
	System.out.println("======================================");
	
//	第二題
//	請建立一個字串,經過程式執行後,輸入結果是反過來的
//	例如String s = “Hello World”,執行結果即為dlroW olleH
	
//	呼叫reverse方法，取得反字串
	hw.reverse("Hello World");
	
	System.out.println();
	System.out.println("======================================");
	
//	第三題
//	有個字串陣列如下:
//	{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//	請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)
	
	String[]s2= {"mercury","venus","earth","mars","jupiter","saturn","uranus","neptune"};
	
	System.out.println("母音一共有"+hw.findVowel(s2)+"個");
	
	System.out.println("======================================");
//	第四題
//	阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有 5 個，請設計一個程式,可以讓小華輸入欲借的金額後,
//	便會顯示哪些員工編號的同事有錢可借他;並且統計有錢可借的總人數:
//	例如輸入 1000 就顯示「有錢可借的員工編號: 25 19 27 共 3 人!」
	
	System.out.println("小華，請輸入你要借的金額");
	
	int[][]colleague = {{25,2500},{32,800},{8,500},{19,1000},{27,1200}}; //前者為編號，後者為可借金額
	
//	使用者輸入金額
	Scanner sc =new Scanner(System.in);
	int input =sc.nextInt();
	

	System.out.println("有錢可借的員工編號:");
	
	int counting =0;
//	使用迴圈存取陣列內每個元素，比對小陣列length-1的元素，如果大於input，就印出小陣列索引為0的值
	for(int i=0;i<colleague.length;i++) {
		for(int j=1;j<2;j++) { //直接從每個小陣列的第2項，索引值1開始比對，只取金額
			if(colleague[i][j]>=input) {
				System.out.print(colleague[i][0]+"\t");
				counting+=1;
			}
		}
	}
	
	System.out.print("共"+counting+"人"+"\n");
	
	System.out.println("======================================");
	
//	第五題
//	請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天
//	例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」
	
	System.out.println("請輸入三個整數:yyyy年,mm月,dd日");
	
	int i1 =sc.nextInt();
	int i2 =sc.nextInt();
	int i3 =sc.nextInt();
	
//	擋下錯誤輸入
	if(i2==2 && i3>29) {
		System.out.println("該月份不會超過29天，請再次輸入三個整數");
		i1 =sc.nextInt();
		i2 =sc.nextInt();
		i3 =sc.nextInt();
	}
	
//	擋下錯誤輸入
	if(i2>12) {
		System.out.println("月份不會超過12月，請再次輸入三個整數");
		i1 =sc.nextInt();
		i2 =sc.nextInt();
		i3 =sc.nextInt();
	}
	
//	擋下錯誤輸入
	if(i3>31) {
		System.out.println("日期不會超過31天，請再次輸入三個整數");
		i1 =sc.nextInt();
		i2 =sc.nextInt();
		i3 =sc.nextInt();
	}
	System.out.println("您輸入的日期為:"+i1+"年"+i2+"月"+i3+"日");
	
//	閏年:(1)該年份可以被4整除，但不可被100整除 (2)該年份可以被400整除
//	若為閏年，2月有29天
	
	int[]normalYear= {31,28,31,30,31,30,31,31,30,31,30,31};
	int[]leapYear ={31,29,31,30,31,30,31,31,30,31,30,31};
	
//	判斷是否為閏年，如果為閏年，累加閏年的陣列元素，長度為i2-1(例如8月，累加1-7月的天數)
//	非閏年就累加一般年的陣列元素，長度為i2-1
	int total=0;
	if((i1%4==0 && i1%4!=0 )||i1%400==0) {
		for(int i=0;i<i2-1;i++) {
			total+=leapYear[i];
		}
	}else {
		for(int i=0;i<i2-1;i++) {
			total+=normalYear[i];
		}
	}
	
//	總天數為一月到前一個月份累加天數+當月天數
	int result =total+i3;
	
	System.out.println("輸入的日期為該年第"+result+"天");
	System.out.println("======================================");
	
	
//	第六題
//	班上有8位同學,請算出每位同學考最高分的次數。
	
//	每次考試，八位同學的分數，小陣列中從左到右是1-8號
	int[][]score = {
			       {10,35,40,100,90,85,75,70},
			       {37,75,77,89,64,75,70,95},
			       {100,70,79,90,75,70,79,90},
			       {77,95,70,89,60,75,85,89},
			       {98,70,89,90,75,90,89,90},
			       {90,80,100,75,50,20,99,75} };
	
//	將八位學生個別的計數器存放於陣列，預設為0，每次找到學生為該考試最高分時，就更新計數器
	int[]counters =new int[8];
	

//	外迴圈決定第幾個小陣列，內迴圈找到每個元素
	for(int i =0;i<score.length;i++) {
//		每個小陣列的第一個元素預設為最大值
		int max =score[i][0]; 
		
//		找到每次考試中的最高分
		for(int j=0;j<score[i].length;j++) {	
			if(score[i][j]>max) { //如果小陣列中的元素值大於預設最大值，就取代之成為最大值
				max=score[i][j]; 
			}	
		}
		
//		更新每位學生的計數器
		for(int j=0;j<score[i].length;j++) {
		 if(score[i][j]==max) { //若學生成績等於每次考試的最大值，計數器陣列的相同索引值累加1。j即代表學生編號
			 counters[j]++;
		 }	
		}
	}
	
//	從陣列取出計數器的每個元素->印出每位學生考最高分的次數
	for(int i=0;i<counters.length;i++) {
		System.out.println(i+1+"號學生有"+counters[i]+"次考最高分");
	}
	
	sc.close();//關閉鍵盤輸入釋放資源
	
	}	
}
