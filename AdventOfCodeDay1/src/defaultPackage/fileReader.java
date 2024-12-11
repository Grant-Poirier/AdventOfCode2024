package defaultPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> left    = new ArrayList<Integer>();
		ArrayList<Integer> right   = new ArrayList<Integer>();
		
		File file = new File("input.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				
				//read in 2 ints per iteration
				int first = scanner.nextInt();
				int second = scanner.nextInt();
				
				//add the two numers to their respecive lists
				left.add(first); //add first column num to left list
				right.add(second);
				
			}
			
			int sum = 0;
			
			while(left.size() > 0) {
				//perform a sequential searhc in the left list to find the smallest element in the list.
				int smallest = left.get(0);
				int smallestIndex= 0;
				for(int i= 0; i < left.size(); i++) {
					if(left.get(i)<smallest) {
						smallest      = left.get(i);
						smallestIndex = i;
					}
				}
				
				//remove smallest value you found
				left.remove(smallestIndex);//so next time its not in the list
			
			
				//find smallest in right list
			
				int small = right.get(0);
				int smallIndex = 0;
				for(int i = 0; i < right.size(); i++) {
					if(right.get(i) < small) {
						small      = right.get(i);
						smallIndex = i;
					}
				}
				
				right.remove(smallIndex);
				
				System.out.println("difference is "+ Math.abs(small- smallest));
				sum += Math.abs(small - smallest);
				
			}
			System.out.println("sum is "+ sum);
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
