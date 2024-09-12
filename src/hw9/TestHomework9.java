package hw9;

//帳戶類別，可以進行匯款、提款並顯示戶頭金額
class Account {
//	實體變數-帳戶金額，初始值為0
	private int accountMoney = 0;

//	可以匯款的方法
	synchronized public void remit(int money) {

//		當帳戶餘額大於3000時，停止匯款給熊大，使執行緒進入等待區等待，直到被通知才繼續執行
		while (accountMoney > 3000) {
			System.out.println("媽媽看到餘額在3000以上，暫停匯款");
			System.out.println("熊大被老媽告知帳戶已經有錢!");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		若帳戶金額沒有超過3000，則可以進行匯款，將匯入的金額存到帳戶金額的實體變數當中
		accountMoney += money;
		System.out.println("媽媽存了" + money + "，帳戶共有:" + accountMoney);
//		帳戶有錢所以通知其他執行緒(child)執行
		notify();
	}

//	可以提款的方法
	synchronized public void withdraw(int money) {
		while (accountMoney < money) {
			System.out.println("熊大看到帳戶沒錢，暫停提款");
			System.out.println("媽媽被熊大要求匯款!");
//			暫停執行緒，直到被呼叫才可執行
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		變更帳戶金額，顯示當前帳戶金額
		accountMoney -= money;
		System.out.println("熊大領了" + money + "，帳戶共有:" + accountMoney);

//		當金額少於2000時，印出要求匯款通知
		if (accountMoney <= 2000) {
			System.out.println("熊大看到餘額在2000以下，要求匯款");
			//帳戶餘額不足通知其他執行緒(mom)執行
			notify(); 
		}
	}

}

//小孩類別，動作為提款，具有帳號的屬性
//繼承thread，可產生執行緒物件
class Child extends Thread {

//	 擁有一個型別為Account的實體變數，可以將account物件存入，擁有一個帳戶的變數
	Account account;

//	 建構子將拿到的帳戶物件存入小孩類別的屬性中，使小孩獲得帳戶，進而可以存取帳戶類別內的方法
	public Child(Account account) {
		this.account = account;
	}

//	當執行緒執行此區時，每次都會呼叫account的withdraw()，從帳戶中提出1000元	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.withdraw(1000);
		}

	}

}

// 媽媽類別，動作為匯款，具有帳戶的屬性
//繼承thread，可產生執行緒物件
class Mom extends Thread {
	Account account;

//	 建構子將拿到的帳戶存入媽媽類別的屬性中，使媽媽可以獲得帳戶，進而可以存取帳戶類別內的方法
	public Mom(Account account) {
		this.account = account;
	}

//	當執行緒執行此區時，每次都會呼叫account物件的remit方法，執行將2000元存入帳戶的動作
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.remit(2000);
		}

	}

}

// 測試區域
public class TestHomework9 {
	public static void main(String[] args) {

//先產生帳戶物件，並分別存入小孩和媽媽的屬性當中
		Account account = new Account();

//	透過建構子，初始化小孩和媽媽物件的屬性資料，使兩個人都具有account這個屬性資料
		Child child = new Child(account);
		Mom mom = new Mom(account);

//	由於child、mom都有繼承thread父類別，所以兩個都是執行緒物件
//		透過start()使兩個執行緒開始執行
		mom.start();
		child.start();
	}

}
