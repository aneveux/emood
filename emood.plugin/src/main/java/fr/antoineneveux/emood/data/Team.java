package fr.antoineneveux.emood.data;

import java.util.Collection;

public class Team {

	private String id;
	private String name;
	private Collection<People> people;

	public Team() {

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

	public Collection<People> getPeople() {
		return this.people;
	}

	public void setPeople(Collection<People> people) {
		this.people = people;
	}

	public long getGlobalMood() {
		long moods = 0;
		for (People p : this.people)
			moods += p.getMood().getValue();
		return moods / this.people.size();
	}
}
