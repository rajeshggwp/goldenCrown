package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import model.InputProvider;
import model.Kingdom;

public class InputGatherer {

	private boolean alreadyExists(String name, Set<InputProvider> ip) {
		if (name == null || name.isEmpty()) {
			return false;
		}
		return ip.stream().anyMatch(input -> name.equalsIgnoreCase(input.getKingdom().getName()));
	}

	public Set<InputProvider> gather() {
		Set<InputProvider> ip = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String input;
			while ((input = br.readLine()) != null) {
				if (input.isEmpty()) {
					break;
				}
				if (!input.contains(",")) {
					System.out.println("Not a valid format");
					continue;
				}
				String data[] = input.split(",", 2);
				if (alreadyExists(data[0], ip)) {
					System.out.println("Data for the kingdom already exists. Provide input for a different one.");
					continue;
				} else if (isUnknownKingdom(data[0])) {
					System.out.println("Unknown kingdom.");
					continue;
				} else if (data[1] == null || data[1].isEmpty()) {
					System.out.println("Secret message cannot be empty");
					continue;
				}
				InputProvider inputObject = new InputProvider(Kingdom.valueOf(data[0].toUpperCase()),
						data[1].toUpperCase());
				ip.add(inputObject);
			}

		} catch (IOException e) {
			System.out.println("Oops, Something went wrong while receiving input.");
		}
		return ip;
	}

	private boolean isUnknownKingdom(String name) {
		if (name == null || name.isEmpty()) {
			return true;
		}
		for (Kingdom kingdom : Kingdom.values()) {
			if (name.equalsIgnoreCase(kingdom.getName())) {
				return false;
			}
		}
		return true;
	}
}
