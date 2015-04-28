package com.wrox.algorithms.iteration;

import java.io.File;

/**
 * A recursive directory printer.
 * 
 * @author David Nelson
 *
 */
public final class RecursiveDirectoryTreePrinter {
	
	/** the indentation character to use in our printout */
	private static final String INDENTATION = "---";
	
	/** hide the constructor of this utility class */
	private RecursiveDirectoryTreePrinter(){}

	/**
	 * The Main.
	 * @param args the directory to recursively print
	 */
	public static void main(String[] args) {
		
		// validate the input
		if (args.length < 1) {
			throw new IllegalArgumentException("args cannot be null");
		}
		
		print(new File(args[0]), "");
	}
	
	/**
	 * Recursively prints a given directory
	 * @param file the file or directory to print
	 * @param indent the desired input text
	 */
	private static void print(File file, String indent) {
		assert(file != null) : "file cannot be null";
		assert(indent != null) : "indentation cannot be blank string";
		
		System.out.print(indent);
		System.out.println(file.getName());
		
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			ArrayIterator<File> ai = new ArrayIterator<File>(files);
			ai.first();
			while (!ai.isDone()) {
				File nextFile = (File)ai.current();
				print(nextFile, indent + INDENTATION);
				ai.next();
			}
		}
	}
}
