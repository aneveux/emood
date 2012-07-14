package fr.antoineneveux.emood.data;

public class People {

	private String id;
	private String name;
	private Mood mood;

	public People() {

	}

	public String getId() {
		return this.id;
	}

	public People setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public People setName(String name) {
		this.name = name;
		return this;
	}

	public Mood getMood() {
		return this.mood;
	}

	public People setMood(Mood mood) {
		this.mood = mood;
		return this;
	}

}
