package test.java.maven;

import java.util.ArrayList;

import pkgScalaTour.DemoArrayList;

public class CallScalaJar {
	public static void main(String[] args) {
		System.out.println("Java started.\n");
		ArrayList<String> argList = new ArrayList<String>();
		argList.add("fully.qualified.ClassName");
		for (String s : args) {
			argList.add(s);
		}
		// MainGenericRunner.main(argList.toArray(new String[0]));
		DemoArrayList.main(args);

		System.out.println("\nJava finished.");
	}
}