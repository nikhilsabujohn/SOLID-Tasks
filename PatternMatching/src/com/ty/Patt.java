package com.ty;
import java.util.regex.*;
public class Patt {
	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("nik",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher("my name is nikhil sabu john");
		boolean k=matcher.find();
		System.err.println(k);

}
}