package com.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//import junit.framework.Assert;

public class Sample_java_Prog {

	public static void main(String[] args) {
		String a[]= {"Future","New","Old","Past"};
		List<String> list = Arrays.asList(a);
		ArrayList<String> a1=new ArrayList<String>(list);
		Collections.sort(a1);
		
		//Assert.assertEquals(list, a1);
		for(String str1:a1)
		{
			System.out.print("\\n"+str1);
		}

	}

}
