package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) {
//	第一題
//	請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰
//三角形的條件:最長邊小於兩邊和
//	正三角形:三邊相同
// 等腰三角形:兩邊相同，一邊不相同

		System.out.println("請輸入三個整數:");

////		使用者輸入三個數字
		Scanner sc = new Scanner(System.in); //創建sc物件，之後可透過同一個物件呼叫方法
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int t3 = sc.nextInt();
		System.out.println(t1 +" "+ t2 + " " + t3);

//		輸入值存放於陣列
		int[] number = { t1, t2, t3 };
		Arrays.sort(number); // 依照小到大做排序

		int sideA = number[0]; 
		int sideB = number[1];
		int sideC = number[2]; //sideC為最長邊

		//判斷是否為三角形:最長邊小於其他兩邊和
		if ((sideA + sideB) > sideC) {
			//判斷為正三角形
			if (sideA == sideB && sideB == sideC) {
				System.out.println("正三角形");
				//判為為等腰三角形
			} else if (sideA == sideB && sideA != sideC) {
				System.out.println("等腰三角形");
				//判斷為直角三角形
			} else if (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2)) {
				System.out.println("直角三角形");
				//符合三角形條件但非以上者
			} else {
				System.out.println("其他三角形");
			}
			
			//不符合三角形條件
		} else {
			System.out.println("不是三角形");
		}

		System.out.println("====================================================");
//	第二題
//	請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜
//	對則顯示正確訊息,如圖示結果:

		// 產生一隨機變數
		int randomNumber = (int) (Math.random() * 10);

		System.out.println("開始猜數字吧!範圍介於0-9");
		int i = sc.nextInt();// 使用者輸入數字

		//判斷輸入值是否與隨機數相等
	    //使用無窮迴圈，只有在猜對時才會跳出迴圈
		while (true) { 
			if (i != randomNumber) {
				System.out.println("猜錯囉!");
				i = sc.nextInt();//繼續下一次猜測
			} else {
				System.out.println("答對囉!答案就是" + i);
				break;//猜對就跳出迴圈
			}
		}

		System.out.println("====================================================");

//		進階功能:0-100的亂數，每次猜會提示該數大於 或 小於正確答案
		int random100 = (int) (Math.random() * 101);// 隨機數(0-100共101個數)

		System.out.println("開始猜數字吧!範圍介於0-100");
		int input = sc.nextInt();// 使用者輸入值

		while (true) {
			if (input != random100) {
				System.out.println("猜錯囉!");
				//給予提示語
				if (input < random100) {
					System.out.println("正確數字大於" + input);
				} else {
					System.out.println("正確數字小於" + input);
				}
				// 繼續下一次猜測
				input = sc.nextInt();
			} else {
				System.out.println("答對囉!答案就是" + input);
				break;
			}
		}

		System.out.println("====================================================");
//	第三題
//	阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
//	厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇
//	的號碼與總數,如圖:

		System.out.println("阿文，你討厭哪個數字?");
		int unlike = sc.nextInt(); //使用者輸入數字

//	獲得使用者輸入的數字並輸出可選擇的號碼和總數
		int count = 0; // 計次

		for (int tens = 0; tens < 50; tens += 10) { // 外迴圈代表十位數，以10為單位做累加
			for (int unit = 0; unit < 10; unit++) { // 內迴圈表示個位數，0-9
				int ableNumber = tens + unit; // 十位數加個位數總和
				// 跳過數字0
				if (ableNumber == 0) {
					continue;
				}
				// 若使用者討厭的數為x，則跳過介於x*10~x*10+9的數
				if (ableNumber >= unlike * 10 && ableNumber <= unlike * 10 + 9) {
					continue;
				}
				// 跳過個位數為unlike的數
				if (unit == unlike) {
					continue;
				}
				// 不符合以上條件者代表可以選擇的數，印出
				System.out.print(ableNumber + " ");
				count += 1; // 印出一個就累加1，計算總數

			}
		}
		System.out.println();
		System.out.println("總共有:" + count + "個數字可以選");
		
		
		System.out.println("====================================================");

//		進階挑戰:輸出不要的數字後，直接印出六個號碼且不重複
		System.out.println("阿文，你討厭哪個數字?");
		int unlikeNum = sc.nextInt();

		int counting = 0; // 計次
		//創建arraylist，動態陣列可以在未知長度下建立陣列，<>內為陣列型別
		ArrayList<Integer> list =new ArrayList<Integer>();
		
		//找到可選數字
		for (int tens = 0; tens < 50; tens += 10) { // 外迴圈代表十位數，以10為單位做累加
			for (int unit = 0; unit < 10; unit++) { // 內迴圈表示個位數，0-9
				int ableNumber = tens + unit; // 寫在內迴圈中才可得總和
				// 跳過數字0
				if (ableNumber == 0) {
					continue;
				}
				// 使用者討厭的數為x，跳過介於x*10~x*10+9的數
				if (ableNumber >= unlikeNum * 10 && ableNumber <= unlikeNum * 10 + 9) {
					continue;
				}
				// 跳過個位數為x的數
				 if(unit == unlikeNum) {
					continue;
				}
				counting += 1;
				// 每次找到可選的值就加到陣列內
				list.add(ableNumber);
			

				}
			}

		
//		隨機從陣列中取出6個不重複的元素放於另一個陣列
			int[] array = new int[6];
			for (int j = 0; j < 6; j++) {
				//從陣列的長度隨機取出數字作為array的index
				int index =(int)(Math.random()*list.size());
				array[j]=list.get(index);//透過get()，取得list的元素，再賦予給array
				System.out.print(array[j]+"\t");
				list.remove(index);//從list中移除以被選到的元素，避免重複選取
			}
					
			  sc.close();//程式都跑完之後，關閉鍵盤輸入，釋放資源
	}
}
