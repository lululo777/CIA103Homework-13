package hw9;

//第一步:繼承thread類別
public class Homework9 extends Thread {

//	包含兩個實體變數:存名稱的變數、計數器變數
	private String name;
	private int counter = 1;

//	建構子，初始化執行緒的名稱
	public Homework9(String name) {
		this.name = name;
	}

	public Homework9() {
	}

//	第二步:override run，並在裡面寫入要執行的內容
	@Override
	public void run() {
		while (counter <= 10) {
			System.out.println(name + "吃第" + counter + "碗飯");

//				產生隨機執行緒睡眠時間
			int randomNum = (int) (Math.random() * 2501) + 500;

//				使執行緒暫停執行
			try {
				Thread.sleep(randomNum); // 暫停0.5-3之間隨機秒數
			} catch (Exception e) {

			}
			counter++;
		}

		System.out.println(name + "吃完了!");
	}

//	main thread
	public static void main(String[] args) {

		System.out.println("-----大胃王快食比賽開始!-----");
//		生成兩個執行緒物件
		Homework9 t1 = new Homework9("饅頭人");
		Homework9 t2 = new Homework9("詹姆士");
		t1.start();
		t2.start();

//		呼叫join()，讓main thread暫停，待t1、t2物件執行完才繼續
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {

		}

		System.out.println("-----大胃王快食比賽結束!-----");
	}

}
