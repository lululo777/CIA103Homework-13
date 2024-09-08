package hw7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Serializable;

public class Homework7 implements Serializable {
	private static final long serialVersionUID = 1L;

//	判斷傳入的檔案是否為字元資料或位元資料
	public static boolean isTextFile(File file) {
		String fileName = file.getName().toLowerCase();
//		endsWith()為String類別之方法，可檢查字串是否以""結尾
//		檢查檔名為文字檔，返回true
		if (fileName.endsWith(".txt") || fileName.endsWith(".csv") || fileName.endsWith(".json")
				|| fileName.endsWith(".xml")) {
			return true;
		}
		return false;
	}

//	第三題
//	請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
//	代表的檔案會複製到第二個參數代表的檔案

	public static void copyFile(File f1, File f2) throws IOException {
//			若輸入的file為字元檔，使用Reader、Writer
		if (isTextFile(f1)) {
//			input
			FileReader fs = new FileReader(f1);
			BufferedReader isr = new BufferedReader(fs);
//			output
			FileWriter fos = new FileWriter(f2);
			BufferedWriter osw = new BufferedWriter(fos);

//			資料寫入f2
			int i;
			while ((i = isr.read()) != -1) {
				osw.write(i);
			}
//				關閉資源
			isr.close();
			fs.close();

			osw.close();
			fos.close();

			System.out.println("已複製檔案" + f1.getName() + "至" + f2.getName());

//				若不是字元資料，就使用InputStream、OutputStream
		} else {
//				input
			FileInputStream fs = new FileInputStream(f1);
			BufferedInputStream bis = new BufferedInputStream(fs);
//				output
			FileOutputStream fos = new FileOutputStream(f2);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

//				資料寫入f2
			int i;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}

			bis.close();
			fs.close();

			bos.close();
			fos.close();

			System.out.println("已複製檔案" + f1.getName() + "至" + f2.getName());
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		第一題
//		請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
//		Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料
		
		File file = new File("src\\hw7\\Sample.txt");

		int countChar = 0;
		int countLine = 0;

//			第一組reader讀取字元數
		FileReader fr1 = new FileReader(file);
		BufferedReader br1 = new BufferedReader(fr1);

//			計算字元數
		while (br1.read() != -1) { // .read回傳為數值
			countChar++;
		}
//			使用完關閉資料流
		br1.close();
		fr1.close();

//			第二組reader讀取列數
//			一組reader只能讀取一次，所以用兩種方式讀取要用兩個reader
		FileReader fr2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(fr2);

//			計算列數
		while (br2.readLine() != null) { // readline()每次讀取一行，回傳字串，若為null代表讀取完畢
			countLine++;
		}
//			關閉資料流
		br2.close();
		fr2.close();
		System.out.println(file.getName() + "檔案共有" + file.length() + "位元組," + countChar + "個字元," + countLine + "列資料");

		
		System.out.println("===========================================");
//		第二題
//		請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 
//		(請使用append功能讓每次執行結果都能被保存起來)->append=true

		FileOutputStream fos = new FileOutputStream("src//hw7//Data.txt", true);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		PrintStream ps = new PrintStream(bos);

		for (int j = 0; j < 10; j++) {
			ps.print((int) ((Math.random() * 1000) + 1) + "\t");
		}

		ps.close();
		bos.close();
		fos.close();

//			第三題
//			呼叫copyFile method，複製Sample檔案
		File copyFile = new File("src//hw7//copy.txt");
		copyFile(file, copyFile);
		
		System.out.println("===========================================");
//			第四題
//			請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。注
//			意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾

		Animal[] animal = new Animal[4];
		animal[0] = new Dog("jimmy");
		animal[1] = new Dog("Momo");
		animal[2] = new Cat("Lucy");
		animal[3] = new Cat("Nina");

		File f = new File("C:\\data\\Object.ser");
//			取得f之父資料夾，若資料夾不存在，就新增資料夾
		File parentDir = f.getParentFile();
		if (!parentDir.exists()) {
			parentDir.mkdirs();
		}

		FileOutputStream output = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(output);

//			使用for-each將物件寫入檔案，以共同父類別Animal為資料型別
		for (Animal a : animal) {
			oos.writeObject(a);
		}

		oos.close();
		output.close();

//			第五題
//			承上題,請寫一個程式,能讀取Object.ser這四個物件,並執行speak()方法觀察結果如何 
//			(請利用多型簡化本題的程式設計)

		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println(f.getName() + "檔案讀取回來的物件資料如下:");

		try {
			while (true) {
				((Animal) ois.readObject()).speak(); //將讀回來的物件資料型別從Object轉回Animal
			}
		} catch (EOFException e) {
//			如果檔案已經結束仍想讀取更多資料時，會拋出 EOFException，透過catch異常，來停止無窮迴圈
			System.out.println();
		} finally {
			ois.close();
			fis.close();
		}

	}
}
