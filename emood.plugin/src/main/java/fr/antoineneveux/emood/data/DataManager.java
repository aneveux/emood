package fr.antoineneveux.emood.data;

import java.util.ArrayList;
import java.util.Collection;

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

	protected void test() {
		Collection<People> people = new ArrayList<People>();
		for (int i = 0; i < 10; i++) {
			people.add(new People().setId("" + i).setName("name" + i)
					.setMood(Mood.HAPPY));
		}
		this.team.setId("test");
		this.team.setName("Test Team");
		this.team.setPeople(people);
	}

}
