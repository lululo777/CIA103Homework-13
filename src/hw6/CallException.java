package hw6;

public class CallException extends Exception{
	
//	無參數之建構子
	public CallException() {}
	
//	super()將參數傳入父類別之建構子
	public CallException(String message) {
		super(message);
	}
	
	
}
