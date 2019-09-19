import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PrimitiveIterator.OfInt;
import java.util.Scanner;
public class solution_1157 {

    static int[] testn = new int[10];
	private static int result;
	public static void main(String[] args) {
		//1157 backjoon
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String str = null;
		str = sc.next();
		solution(str);
//		System.out.println(factorial(sc.nextInt()));
	}// main

	
	private static void solution(String str) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> solmap = new HashMap<String, Integer>();
		String stru = str.toUpperCase();
		char[] chartoarray = stru.toCharArray();
		
		for (char output : chartoarray) {
			
			if(solmap.containsKey(Character.toString(output))){
				int count=0;		
//				System.out.println(Character.toString(output)+ " " +(solmap.get(Character.toString(output)).intValue()+1));
				count = solmap.get(Character.toString(output)).intValue()+1;
				solmap.put(Character.toString(output), count);
			}else{
				solmap.put(Character.toString(output), 1);
			}
			
		
		}

//		System.out.println(solmap.toString());

		Iterator<String> keys = solmap.keySet().iterator();
		int Max = 0;
		String finalx = "";
		StringBuffer aa = new StringBuffer();
		while(keys.hasNext()){
			String key = keys.next();
//			System.out.println(key + " // "+ solmap.get(key));
			if(solmap.get(key) > Max){
				Max = solmap.get(key);
				finalx = key;
			}else if(solmap.get(key) == Max){
				finalx = "0";
			}
		}
		if("0".equals(finalx)){
			System.out.println("?");
		}else{
			System.out.println(finalx); //가장 많이 들어간 알파벳 고르도록 설정
		}
	}
	

}
