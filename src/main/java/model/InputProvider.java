package model;

public class InputProvider {

	private Kingdom kingdom;

	private String message;

	public InputProvider(Kingdom kingdom, String message) {
		this.kingdom = kingdom;
		this.message = message;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public String getMessage() {
		return message;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
