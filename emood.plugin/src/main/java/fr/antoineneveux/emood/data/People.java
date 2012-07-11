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

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mood getMood() {
		return this.mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

}
