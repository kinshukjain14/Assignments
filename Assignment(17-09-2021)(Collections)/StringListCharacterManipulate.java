package com.yash.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StringListCharacterManipulate {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			List<String> stringList = new ArrayList<>();
			System.out.println("Enter 5 Names : ");
			for (int i = 0; i < 5; i++) {
				System.out.print("Enter Name "+(i+1)+ " : ");
				stringList.add(sc.nextLine());
			}
			System.out.println("\n==== Before Manipulation ====");
			System.out.println(stringList);
			
			System.out.print("\nEnter index number to change : ");
			int index = sc.nextInt();
			convertCharToupper(index-1, stringList);
			System.out.println("\n==== After Manipulation ====");
			System.out.println(stringList);
		}
	}
	
	public static void convertCharToupper(int index,List<String> list) {
		Iterator<String> itr=list.iterator();
		List<String> tempList = new ArrayList<>();
		while(itr.hasNext()) {
			String str = itr.next();
			if(str.length()<index+1) {
				continue;
			}
			char[] charArray = str.toCharArray();
			charArray[index] = Character.toUpperCase(charArray[index]);
			tempList.add(new String(charArray));
			itr.remove();
		}
		list.addAll(tempList);
	}
}
