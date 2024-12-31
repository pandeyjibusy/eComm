package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams {	
	@Test
	public void regular() {
		ArrayList<String>  names  = new ArrayList<String>();
		names.add("Abhi");
		names.add("Don");
		names.add("Alekh");
		names.add("Adam");
		names.add("Ram");
		names.add("krish");
		names.add("Shivas");
		int count = 0;
		for(int i = 0; i<names.size();i++) 
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println("This is the output of regular : "+count);
		
	}
	@Test
	public void streamFilter() {
		ArrayList<String>  names  = new ArrayList<String>();
		names.add("Abhi");
		names.add("Don");
		names.add("Alekh");
		names.add("Adam");
		names.add("Ram");
		names.add("krish");
		names.add("Shivas");
	
			Long c = names.stream().filter(s->s.startsWith("A")).count();
			System.out.println("This is the output of streamFilter : "+c);
			
			Long d = Stream.of("Abhi","Don","Alekh","Adam","Ram","krish")
			.filter(s->
					{
					s.startsWith("A");
					return false;
					}
			).count();
			System.out.println("This is the output of streamFilter second result : "+d);
			names.stream().filter(s->s.length()>4).forEach(s->System.out.println("This is the output of streamFilter third result : "+s));
			names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println("This is the output of streamFilter fourth result : "+s));
	}
	
	
	@Test
	public void streamMap()
	{
			Stream.of("Abhi","Don","Alekha","Adam","Ram","krisha").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.forEach(s->System.out.println("This is the output of streamMap first result : "+s));
			//print names which have first letter as a with uppercase and sorted
			

			List<String> names1 = Arrays.asList("Abhi","Don","Alekha","Adam","Ram","krisha");
			names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("This is the output of streamMap second result : "+s));
			
			//Merge 2 list
			ArrayList<String>  names  = new ArrayList<String>();
			names.add("Ranvir");
			names.add("rajkuma");
			names.add("Amitabh");
			names.add("Hrithik");
			names.add("Alakh");
			names.add("anduPandu");
			names.add("Sherkan");
			
			Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
			//newStream.sorted().forEach(s->System.out.println(s));
			
			boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
			System.out.println("This is the output of streamMap third result : "+flag);
			Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		//list
		List<String> ls = Stream.of("Abhi","Don","Alekha","Adam","Ram","krisha").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println("this is output of streamCollect : "+ls.get(0));
		
		//print unique number from this array
		
		List<Integer> values = Arrays.asList(3,2,2,7,8,1,9,7);
		values.stream().distinct().forEach(s->System.out.println("This is the output of streamMap second result : "+s));
		values.stream().distinct().sorted()
		.forEach(s->System.out.println("This is the output of streamMap third result : "+s));
		
		List<Integer> values1 = Arrays.asList(3,2,2,7,8,1,9,7);
		
		List<Integer> ls1 = values1.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("This is the output of streamMap fifth result : "+ls1.get(3));
		

		
	}
	
	
	
	
	
	

}
