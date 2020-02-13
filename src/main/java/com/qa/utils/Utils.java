/**
 * This package is used to provide utilities which can be reused through the application.
 */
package com.qa.utils;

import java.util.Scanner;

public class Utils {

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
