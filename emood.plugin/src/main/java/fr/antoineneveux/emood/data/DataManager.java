package fr.antoineneveux.emood.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class DataManager {

	private static DataManager _instance = new DataManager();

	private Team team;

	private DataManager() {
		this.team = new Team();
		test();
	}

	public static DataManager getInstance() {
		return _instance;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void create(String name) {
		this.team.getPeople().add(
				new People().setName(name).setMood(Mood.UNCERTAIN));
	}

	protected void test() {
		Collection<People> people = new ArrayList<People>();
		for (int i = 0; i < 10; i++) {
			People p = new People().setId("" + i).setName("name" + i)
					.setMood(getRandomMood());
			people.add(p);
			System.out.println(p.toString());
		}
		this.team.setId("test");
		this.team.setName("Test Team");
		this.team.setPeople(people);
	}

	protected Mood getRandomMood() {
		return Mood.values()[new Random().nextInt(8)];
	}

}
