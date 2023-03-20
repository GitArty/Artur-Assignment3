package com.codersbootcamp.Assignment3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserLoginApplication {
	private static final int MAX_LOGIN_ATTEMPTS = 5;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserService userService = new UserService();

		try {
			userService.dataUsers("data.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Failed to load users from file.");
			scanner.close();
			return;

		}
		int attempts = 0;

		while (attempts < MAX_LOGIN_ATTEMPTS) {
			System.out.println("Enter Username: ");
			String username = scanner.nextLine();

			System.out.println("Enter Password: ");
			String password = scanner.nextLine();

			User user = userService.validateUser(username, password);

			if (user != null) {
				System.out.println("Welcome " + user.getName());
				scanner.close();
				return;

			} else {
				attempts++;
				System.out.println("Invalid login, please try again.");

			}
		}
		System.out.println("Too many failed loging attempts, you are now locked out.");
		scanner.close();
		;

	}
}
