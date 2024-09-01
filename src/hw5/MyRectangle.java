package hw5;

public class MyRectangle {
	private double width;
	private double depth;
	
//	設定寬
	public void setWidth(double width) {
		this.width=width;
	}
	
//	設定長
	public void setDepth(double depth) {
		this.depth=depth;
	}
	
//	取得面積
	public double getArea() {
		return width*depth;
	}
	
//	不帶參數之建構子-保留原本預設無參數之建構子，使之不被Java移除
	public MyRectangle() {
		
	}
	
//	帶兩個參數的建構子，做物件初始化
	public MyRectangle(double width,double depth) {
		this.width=width;
		this.depth=depth;
	}
	
	
}
