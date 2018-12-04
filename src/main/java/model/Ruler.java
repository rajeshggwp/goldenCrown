package model;

import java.util.HashSet;
import java.util.Set;

public class Ruler {
	private boolean rule;
	private String name;
	private Set<Kingdom> supporters = new HashSet<>();

	public Ruler(boolean rule, String name, Set<Kingdom> supporters) {
		super();
		this.rule = rule;
		this.name = name;
		this.supporters = supporters;
	}

	public void addSupporter(Kingdom kingdom) {
		supporters.add(kingdom);
	}

	public String getName() {
		return name;
	}

	public Set<Kingdom> getSupporters() {
		return supporters;
	}

	public boolean isRule() {
		return rule;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRule(boolean rule) {
		this.rule = rule;
	}

	public void setSupporters(Set<Kingdom> supporters) {
		this.supporters = supporters;
	}

}
