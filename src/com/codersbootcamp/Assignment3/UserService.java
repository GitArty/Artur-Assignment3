package com.codersbootcamp.Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
	private ArrayList<User> users;

	public UserService() {
		this.users = new ArrayList<>();
	}

	public void dataUsers(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] comp = line.split(",");

			String username = comp[0];
			String password = comp[1];
			String name = comp[2];

			User user = new User(username, password, name);
			this.users.add(user);
		}
		scanner.close();
	}

	public User validateUser(String username, String password) {
		for (User user : this.users) {

			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;

	}

}
