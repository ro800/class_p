import java.util.ArrayList;
import java.util.Timer;
import java.util.Collections;
import java.util.Scanner;
public class C_Project {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		long startTime;
		long endTime;
		System.out.println("Enter the range of the list: ");
		int RanNum = in.nextInt();
		System.out.println("Set range for numbers: ");
		int range = in.nextInt();
		startTime = System.nanoTime();
		for(int i = 0; i < RanNum; i++)
		{
			int ran = (int)(Math.random()*range);
			list.add(ran);
		}
		
		System.out.println(list);
		endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
		System.out.println((endTime - startTime)/1000000000);
		
		boolean flag = true;
		
			System.out.println("menu: ");
			int menu = in.nextInt();
			switch (menu){
			case 1:
				startTime = System.nanoTime();
				QuickSort(list);
				endTime = System.nanoTime();
				System.out.println("Took "+(endTime - startTime) + " ns");
				System.out.println((endTime - startTime)/1000000000);
				break;
			case 2: //Not Valid part!!!!!!
				startTime = System.nanoTime();
				list = Oeder(list);
				System.out.println(list);
				endTime = System.nanoTime();
				System.out.println("Took "+(endTime - startTime) + " ns");
				System.out.println((endTime - startTime)/1000000000);
				break;
			case 3:
				startTime = System.nanoTime();
				bubble(list);
				endTime = System.nanoTime();
				System.out.println("Took "+(endTime - startTime) + " ns");
				System.out.println((endTime - startTime)/1000000000);
				break;
			case 4:
				System.out.println("Enter number you want to find: ");
				int lookFor = in.nextInt();
				startTime = System.nanoTime();
				Sequential(list, lookFor);
				endTime = System.nanoTime();
				System.out.println("Took "+(endTime - startTime) + " ns");
				System.out.println((endTime - startTime)/1000000000);
				break;
			case 5:
				startTime = System.nanoTime();
				InsertionSort(list);
				endTime = System.nanoTime();
				System.out.println("Took "+(endTime - startTime) + " ns");
				System.out.println((endTime - startTime)/1000000000);
				break;
			}
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
	public static void Sequential(ArrayList<Integer> list, int lookFor){
		int look = lookFor;
		boolean bool = false;
		for(int i = 0; i < list.size(); i++){
			if(look == list.get(i)){
				System.out.println("number " + look + " is located in positon: " + i);
				 bool = true;
			}
		}
		if(bool==false){
			System.out.println("Number " + look + " is NOT located in the array.");
		}
	}
	
	public static void bubble(ArrayList<Integer> list){
		boolean x = true;
		while(x){
			x=false;
			for(int i = 0; i < list.size()-1; i++){
				if(list.get(i) > list.get(i+1)){
					int big = list.get(i);
					int small = list.get(i+1);
					list.set(i+1, big);
					list.set(i, small);
					x=true;
				}
			}
		}
		System.out.println(list);
	}
	public static void InsertionSort(ArrayList<Integer> list){
		int pull;
		for(int i = 1; i < list.size(); i++){
			for(int j = i-1; j > 0; j--){
				if(list.get(j) < list.get(j - 1)){
					pull =list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j-1, pull);
				}
			}
		}
		System.out.println(list);
	}
}
