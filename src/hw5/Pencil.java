package hw5;

public class Pencil extends Pen {
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("削鉛筆再寫");
	}
	
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return (int)(super.getPrice()*0.8);
	}
}
