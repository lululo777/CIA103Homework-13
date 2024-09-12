package hw8;

import java.awt.List;
import java.util.*;

public class TestTrain {

	public static void main(String[] args) {
		
//		使用固定長度的陣列存放資料，以Train為資料型別
		Train[] train =new Train[7];
		train[0]=new Train(202,"普悠瑪","樹林","花蓮",400);
		train[1]=new Train(1254,"區間","屏東","基隆",700);
		train[2]=new Train(118,"自強","高雄","台北",500);
		train[3]=new Train(1288,"區間","新竹","基隆",400);
		train[4]=new Train(122,"自強","台中","花蓮",600);
		train[5]=new Train(1222,"區間","樹林","七堵",300);
		train[6]=new Train(1254,"區間","屏東","基隆",700);
		
		
//		使用HashSet，加入元素不重複
		Set<Train>mySet =new HashSet<Train>();
		
		for(int i=0;i<7;i++) {
			mySet.add(train[i]);
		}
		
		System.out.println("以下顯示出不重複的元素:");
		
//		Iterator迭代器
		Iterator<Train>it = mySet.iterator();
		while(it.hasNext()) {
			it.next().showInfo(); //每個取出元素(物件)再去呼叫其showInfo()，印出該物件之資訊
			System.out.println();
		}
		
		System.out.println("====================================================");
		
		System.out.println("以下顯示出按照車次大小順序排列的元素:");
		
//		使用ArrayList，做大小排序
		ArrayList<Train>list=new ArrayList<Train>();
		
		for(int i=0;i<7;i++) {
			list.add(train[i]);
		}
		
//		呼叫sort()將集合作排序，會依照類別覆寫的compareTo()內容，決定排序順序
		Collections.sort(list);
		
//		for-each
		for(Train t:list) {
			t.showInfo();
			System.out.println();
		}
		
		System.out.println("====================================================");
		System.out.println("以下顯示出按照車次大小排序且不重複的元素");
		
//		使用TreeSet，具有不重複的特性且可依大小排序
//		TreeSet會參考類別覆寫的compareTo()來進行排序&排除重複(return 0的時候)
		Set<Train>set =new TreeSet<Train>();
		
		for(int i=0;i<7;i++) {
			set.add(train[i]);
		}
		
//		Iterator迭代器
		Iterator<Train>it3 =set.iterator();
		
		while(it3.hasNext()) {
			it3.next().showInfo();
			System.out.println();
		}
		
	}
}
