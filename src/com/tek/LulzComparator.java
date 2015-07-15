package com.tek;

import java.util.Comparator;


public class LulzComparator implements Comparator<MemesObj> {

	@Override
	public int compare(MemesObj o1, MemesObj o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}