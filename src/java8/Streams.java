package java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		System.out.println("Using Java 7: ");
		
	      // Count empty strings
	      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
	      List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
	      System.out.println("List: " +strings);
	      
			
	      //print ten random numbers
	      Random random = new Random();
			
	      for(int i = 0; i < 10; i++) {
	         System.out.println(random.nextInt());
	      }
			
	      System.out.println("Using Java 8: ");
	      System.out.println("List: " +strings);
			
	    long  count = strings.stream().filter(string->string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);
			
	      count = strings.stream().filter(string -> string.length() == 3).count();
	      System.out.println("Strings of length 3: " + count);
			
	  List<String>    filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
	      System.out.println("Filtered List: " + filtered);
			
	     
			
	      List<Integer>    squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
	      System.out.println("Squares List: " + squaresList);
			
	      IntSummaryStatistics stats = numbers.stream().mapToInt((x) ->x).summaryStatistics();
			
	      System.out.println("Highest number in List : " + stats.getMax());
	      System.out.println("Lowest number in List : " + stats.getMin());
	      System.out.println("Sum of all numbers : " + stats.getSum());
	      System.out.println("Average of all numbers : " + stats.getAverage());
	      System.out.println("Random Numbers: ");
			
	      random.ints().limit(10).sorted().forEach(System.out::println);
			
	      //parallel processing
	      count = strings.parallelStream().filter(string -> string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);
	   }
		
	   
}
