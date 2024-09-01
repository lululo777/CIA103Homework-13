package hw5;

public class MyRectangleMain {
	public static void main(String[] args) {
//		呼叫無參數之建構子，再用setter設定初始值
		MyRectangle rectangle1 =new MyRectangle();
		rectangle1.setWidth(10);
		rectangle1.setDepth(20);
		System.out.println(rectangle1.getArea());
		
//		產生物件，呼叫有參數之建構子，直接初始化物件
		MyRectangle rectangle2 =new MyRectangle(10,20);
		System.out.println(rectangle2.getArea());
	}
}
