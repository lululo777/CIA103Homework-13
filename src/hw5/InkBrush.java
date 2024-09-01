package hw5;

public class InkBrush extends Pen{
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("沾墨汁再寫");
	}
	
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return (int)(super.getPrice()*0.9);
	}
}
