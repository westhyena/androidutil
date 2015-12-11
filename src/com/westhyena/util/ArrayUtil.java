package com.westhyena.util;

import java.util.ArrayList;

public class ArrayUtil {
	
	public static long[] ArrayListToLongArray(ArrayList<Long> list) {
		long[] ary = new long[list.size()];
		for (int i = 0; i < list.size(); ++i) {
			ary[i] = list.get(i);
		}
		return ary;
	}
}
