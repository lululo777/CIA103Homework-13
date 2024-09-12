package hw8;

import java.math.BigInteger;
import java.util.*;

public class Homework8 {
	
	public static void main(String[] args) {
		
//		第一題
		List list = new ArrayList();
		
		list.add(new Integer(100));
		list.add(new Double(3.14));
		list.add(new Long(21L));
		list.add(new Short("100"));
		list.add(new Double(5.1));
		list.add(new String("Kitty"));
		list.add(new Integer(100));
		list.add(new Object());
		list.add(new String("Snoopy"));
		list.add(new BigInteger("1000"));
		
//		for-loop
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"\t");
		}
		
		System.out.println();
		System.out.println("==========================================================================================================");
		
//		Iterator迭代器
//		list呼叫迭代器方法，取得迭代器
		Iterator iterator =list.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+"\t");
		}
		
		System.out.println();
		System.out.println("==========================================================================================================");
		
//		for-each
//		型別使用Object，因為list內的元素類型都不同，將取出元素放在Obj變數裡
		for(Object obj:list) {
			System.out.print(obj+"\t");
		}
		
		System.out.println();
		System.out.println("==========================================================================================================");
		
//		使用iterator移除非Number的元素
		Iterator it2 =list.iterator();
		while(it2.hasNext()) {
			if(!(it2.next() instanceof Number)) {
				it2.remove();
			}
		}
		
		
		System.out.println();
		System.out.println("==========================================================================================================");
	    System.out.println(list);
		
	}
	
	
	
}
