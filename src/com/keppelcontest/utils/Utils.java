package com.keppelcontest.utils;

public final class Utils {
	public static void log(Object o){
		if (o != null)
			System.out.println(o.toString());
		System.out.println("--");
	}
}
