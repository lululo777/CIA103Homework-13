package hw6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Calculator c = new Calculator();

		int x;
		int y;

//		使用無窮迴圈，直到使用者輸入非例外事件的值，就可印出值，結束迴圈
		while (true) {
			try {
//			執行可能發生錯誤的程式碼
				System.out.println("請輸入x的值");
				x = sc.nextInt();
				System.out.println("請輸入y的值");
				y = sc.nextInt();
				System.out.println(x + "的" + y + "次方等於" + c.powerXY(x, y));
				break; //若都沒發生例外事件就離開迴圈
				
// 當使用者輸入非數字時，catch InputMismatchException，為Java API類別，代表輸入值非預期類型
			} catch (InputMismatchException e) { 
				System.out.println("輸入格式不正確");
				sc.nextLine(); //清除輸入區暫存的字串
				
// x=0且y=0或是y<0的時候，catch自訂的例外事件，CallException繼承exception，位階大於InputMismatchException，所以寫在後面
//           例外類別位階低的寫前面，位階高寫後面
			}catch (CallException e) {
				System.out.println(e.getMessage());
				continue; //繼續下一次迴圈，直到輸入合理的數值
			}

		}
		
		
//		關閉資源
		sc.close();

	}

}
