 package com.ty.listDupe;


import java.util.LinkedList;
import java.util.List;

public class ListDupeDeletion {
	
	public static void main(String[] args) {
		
		List<Integer> l1= new LinkedList<Integer>();
		l1.add(1);
		l1.add(1);
		l1.add(1);
		l1.add(1);
		l1.add(1);
		l1.add(2);
		l1.add(2);
		l1.add(2);
		l1.add(2);
		l1.add(2);
		l1.add(3);
		l1.add(3);
		l1.add(4);
		l1.add(4);
		l1.add(5);
		l1.add(5);
		for(int i=0;i<l1.size();i++)
		{
			for(int j=i+1;j<l1.size();j++)
			{
				if(l1.get(i).equals(l1.get(j)))
				{
					l1.remove(j);
					j--;
				}
			}
		}
		
		for (Integer integer : l1) {
			System.err.println(integer);
		}
		
	}

}
