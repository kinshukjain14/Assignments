package Max_Array_Interface;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] {34,21,32,556,3,2,76,23,9,200,675,3};
		System.out.println("Given Array : ");
		System.out.println(Arrays.asList(arr));
		ComputeMaxElement cme=(x)->{
			Integer[] copy = Arrays.copyOf(x, x.length);
			Arrays.sort(copy);
			return copy[x.length-1];
		};
		Integer max = cme.max(arr);
		System.out.println("\nMax element : "+max);
	}
}
