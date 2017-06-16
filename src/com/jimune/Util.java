package com.jimune;

public class Util {

	public static String build(Object... objs) {
		StringBuilder sb = new StringBuilder();
		
		for (Object obj : objs) {
			sb.append(obj).append(" ");
		}
		
		return sb.toString();
	}
	
}
