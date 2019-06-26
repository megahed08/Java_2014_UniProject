package eg.edu.guc.parkei.amusers;

import java.util.ArrayList;

import eg.edu.guc.parkei.park.rides.FunRide;
import eg.edu.guc.parkei.utilities.Effect;
import eg.edu.guc.parkei.utilities.Ticket;

public abstract class Amuser implements Rider {

	private String name;
	private int age;
	private double height;
	private FunRide location;
	private boolean riding;
	private Ticket ticket;
	private ArrayList<Effect> effects;

	public Amuser(String name, int age, double height) {
		this.setName(name);
		this.setAge(age);
		this.setHeight(height);
		effects = new ArrayList<Effect>();
		
	}

	public boolean move(FunRide newLocation) {
		this.setLocation(newLocation);
		return true;
	}

	public void setLocation(FunRide location) {
		this.location = location;
	}

	public FunRide getLocation() {
		return location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setRiding(boolean riding) {
		this.riding = riding;
	}

	public boolean isRiding() {
		return riding;
	}

	public void applyEffects(Effect effect) {
		effects.add(effect);
	}

	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	public void setEffects(ArrayList<Effect> effects) {
		this.effects = effects;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Ticket getTicket() {
		return ticket;
	}

}
