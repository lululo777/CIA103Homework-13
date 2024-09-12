package hw8;

//實作Comparable介面，才可自訂物件的大小比較進行排序
//記得要有泛型，指定比較器要比得對象，沒寫得預設對象為Object
public class Train implements Comparable<Train> {
//	五個實體變數
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;

//	建構子
	public Train(int number, String type, String start, String dest, double price) {
		this.number = number;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.price = price;
	}

//	每個實體變數的setter、getter
	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStart() {
		return start;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDest() {
		return dest;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

//	若要用set將重複物件排除，需要去定義什麼叫作重複的物件
//	(1)進行模糊比對，override hashcode()，回傳一數值代表該物件
//	(2)進行明確比對，override equals()，定義什麼是相同的物件，返回布林值
//	(3)set才可根據覆寫的定義，發揮其特性，在使用集合加入元素時排除重複的自訂物件
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj != null && this.getClass() == obj.getClass()) {
			Train o = (Train) obj;
			if (this.dest == o.dest && this.number == o.number && this.price == o.price && this.start == o.start
					&& this.type == o.type) {
				return true;
			}
		}
		return false;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int a = 31;
		int result = 1;
		result = result * a + number;
		result = result * a + ((start != null) ? start.hashCode() : 0);
		result = result * a + ((dest != null) ? dest.hashCode() : 0);
		result = result * a + ((type != null) ? type.hashCode() : 0);
		result = result * a + (int) price;
		return result;
	}

//	印出物件資訊的方法
	public void showInfo() {
		System.out.print("車次:" + number + " ");
		System.out.print("車種:" + type + " ");
		System.out.print("出發地:" + start + " ");
		System.out.print("目的地:" + dest + " ");
		System.out.print("票價:" + price);
	}

//	若使用(1)ArrayList要將物件作排序，或是使用(2)TreeSet要發揮其特性，排除重複且進行排序
//	需要implement Comparable + override compareTo()
	@Override
	public int compareTo(Train t) {
		if (this.number > t.number) {
			return -1; // 使用-1，使排序時由大到小作排序
		} else if (this.number == t.number) {
			return 0; // 返回0，可排除重複值
		} else {
			return 1;
		}
	}

}
