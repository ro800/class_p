import java.util.ArrayList;
import java.util.Timer;
import java.util.Collections;
import java.util.Scanner;
public class C_Project {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter the number of Random num: ");
		int RanNum = in.nextInt();
		System.out.println("Set range for random number: ");
		int range = in.nextInt();
		for(int i = 0; i < RanNum; i++)
		{
			int ran = (int)(Math.random()*range);
			list.add(ran);
		}
		//System.out.println(list);
		//list = Oeder(list);
		//System.out.println(list);
		
		//System.out.println(list);
		//long startTime = System.nanoTime();
		//QuickSort(list);
		//long endTime = System.nanoTime();
		//System.out.println("Took "+(endTime - startTime) + " ns"); 
		System.out.println(list);
		Sequential(list);
		
		
		
	}
	public static ArrayList<Integer> Oeder(ArrayList<Integer> list){
		Collections.sort(list);
		return list;
	}
	public static ArrayList<Integer> QuickSort(ArrayList<Integer> list){
		
		if(list.size() <= 1){
			return list;
		}
		int middle = (int) Math.ceil((double)list.size() / 2);
		int pivot = list.get(middle);

		ArrayList<Integer> less = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		
		for (int i = 0; i < list.size(); i++){
			if(list.get(i) <= pivot){
				if(i == middle){
					continue;
				}
				less.add(list.get(i));
			}
			else{
				greater.add(list.get(i));
			}
		}
		return concatenate(QuickSort(less), pivot, QuickSort(greater));
	}
	public static ArrayList<Integer> concatenate(ArrayList<Integer> less, int pivot, ArrayList<Integer> greater){
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for (int i = 0; i < less.size(); i++) {
				list.add(less.get(i));
			}
			
			list.add(pivot);
			
			for (int i = 0; i < greater.size(); i++) {
				list.add(greater.get(i));
			}
			System.out.println(list);
			return list;
		}
		
	
	public static void Sequential(ArrayList<Integer> list){
		Scanner enter = new Scanner(System.in);
		System.out.println("Enter number you want to find: ");
		int look = enter.nextInt();
		boolean bool = false;
		for(int i = 0; i < list.size(); i++){
			if(look == list.get(i)){
				System.out.println("number " + look + " is located in positon: " + i);
				 bool = true;
			}
		}
		if(bool==false){
			System.out.println("Number " + look + " is not located in the array.");
		}
	}
	
	
	
	
	
	
	
	
}