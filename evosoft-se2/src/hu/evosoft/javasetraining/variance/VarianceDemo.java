package hu.evosoft.javasetraining.variance;

import java.util.ArrayList;
import java.util.List;

public class VarianceDemo {

	
	public static void main(String[]args) {
		
		Number[] nums = new Number[5];
		nums[0] = Integer.valueOf(1); // Ok
		nums[1] = Double.valueOf(2.0); // Ok
		
		
		Integer[] intArr = new Integer[5];
		Number[] numArr = intArr; // Ok
		
		numArr[0] = 1.23; // Not ok
		
		
		
		List<Integer> intArrList = new ArrayList<>();
		//List<Number> numArrList = intArrList; // Not ok
		List<Integer> anotherIntArrList = intArrList; // Ok
		
		
		
		List<Integer> ints = new ArrayList<>();
		List<? extends Number> nums2 = ints;
        
        ints.add(Integer.valueOf(1)); // Ok
        Number n = nums2.get(0); // Ok
        
        // READ ONLY
        //nums2.add(Integer.valueOf(2)); // Not ok
        
        
        
        ints = new ArrayList<>();
        List<? super Integer> nums3 = ints;
        
        ints.add(Integer.valueOf(1)); // Ok
        nums3.add(Integer.valueOf(2)); // Ok
        // WRITE ONLY
        //Integer n = nums3.get(0); // Not ok
	}
}
