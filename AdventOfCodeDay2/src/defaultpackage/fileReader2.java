package defaultpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class fileReader2 {
	
	public static boolean increasing(String[] list) {
		
		for(int i = 1; i < list.length; i++) {
			
			//check i doesn't meet requirements, exit right away
			int el1 = Integer.valueOf(list[i]);
			int el0 = Integer.valueOf(list[i-1]);
			
			if(el1 <= el0) {
				return false;
			}else if(el1 - el0 > 3) { //if the difference is > 3
				return false;
			}
			
			
		}
		return true;
		
	}
	public static boolean decreasing(String[] list) {
			
			for(int i = 1; i < list.length; i++) {
				
				//check i doesn't meet requirements, exit right away
				int el1 = Integer.valueOf(list[i]);
				int el0 = Integer.valueOf(list[i-1]);
				
				if(el1 >= el0) {
					return false;
				}else if(el0 - el1 > 3) { //if the difference is > 3
					return false;
				}
				
				
			}
			return true;
			
	}
	
	
	public static boolean isSafeWithDampener(String[] list) {
        // Check if the list is already safe
        if (increasing(list) || decreasing(list)) {
            return true;
        }

        // Try removing each element and check if the resulting list is safe
        for (int i = 0; i < list.length; i++) {
        	
            String[] listRemoveOneTerm = new String[list.length - 1];
            
            int k = 0;
            for (int j = 0; j < list.length; j++) {
                if (j == i) {
                    continue;
                }
                listRemoveOneTerm[k] = list[j];
                k++;
            }


            if (increasing(listRemoveOneTerm) || decreasing(listRemoveOneTerm)) {
                return true;
            }
            
        }

        return false;
    }
	
	
	
	public static void main(String[] args) {
		
		File file = new File("input2.txt");
		
		try {
			
			Scanner scanner = new Scanner(file);
			int count = 0;
			while(scanner.hasNext()) {
				
				String line = scanner.nextLine();
				//split the line into a string array
				String[] elements = line.split(" ");
				if(isSafeWithDampener(elements)) {
					count++;
				}else {
					System.out.println(Arrays.toString(elements));
				}
				
				
				
			}
			System.out.println("Total Safe " + count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
