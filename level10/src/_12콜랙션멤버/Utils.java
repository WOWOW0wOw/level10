package _12콜랙션멤버;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Utils {

	private static Scanner sc = new Scanner(System.in);
	private static final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName()
			+ "\\";
	private static String fileName = CUR_PATH + "member.txt";

	private Utils() {};

	public static int getIntVelue(String msg) {
		System.out.println(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	public static String getStringVelue(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	public static String loadMemberDataFile() {
		String data = "";
		try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr);) {
			while (true) {
				int read = fr.read();
				if (read == -1) {
					break;
				}
				data += (char) read + "";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return data;
	}
	
	public static void saveMemberDataFile(String data) {
		try (FileWriter fw = new FileWriter(fileName)) {

			fw.write(data);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
