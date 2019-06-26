package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.AlreadyBoardingException;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.CannotUnboardException;
import eg.edu.guc.parkei.exceptions.FullRideException;
import eg.edu.guc.parkei.exceptions.LocationException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;

public abstract class Ride {
	private String name;
	private int duration;
	private int batchSize;
	private int ridesToMaintain;
	private ArrayList<Amuser> currentAmusers;

	public Ride(String name, int duration, int batchSize) {
		this.setName(name);
		this.setDuration(duration);
		this.setBatchSize(batchSize);
		setCurrentAmusers(new ArrayList<Amuser>());
		setRidesToMaintain(10);

	}

	/**
	 * @param boarder
	 * @return
	 * 
	 *         Nobody can board a ride that is being maintained. A full ride can
	 *         not be boarded by someone else. An amuser riding this/or
	 *         different ride can not ride this one. Only amusers in same
	 *         location as the ride can board it.
	 */
	public boolean board(Amuser boarder) throws CannotBoardException,
			OutOfOrderException {
		if (inMaintenance()) {
			throw new OutOfOrderException("The ride is being maintained");
		}
		if (getCurrentAmusers().size() == getBatchSize()) {
			throw new FullRideException();
		}
		if (boarder.isRiding()) {
			throw new AlreadyBoardingException(
					"You are already boarding a different ride");
		}
		if (getCurrentAmusers().contains(boarder)) {
			throw new AlreadyBoardingException(
					"You are already boarding this ride");
		}
		if (!correctLocation(boarder)) {
			throw new LocationException(
					"You should move to the ride to board it");
		}
		getCurrentAmusers().add(boarder);
		boarder.setRiding(true);
		return true;
	}

	protected abstract boolean correctLocation(Amuser am);

	public void unBoard() {
		setCurrentAmusers(new ArrayList<Amuser>());
	}

	public boolean unBoard(Amuser boarder) throws CannotUnboardException {
		if (!getCurrentAmusers().contains(boarder)) {
			throw new CannotUnboardException();
		}
		getCurrentAmusers().remove(boarder);
		return true;
	}

	public boolean start() throws CannotOperateException {
		if (inMaintenance()) {
			throw new OutOfOrderException(
					"This ride is being maintained! You can not ride it");
		}
		setRidesToMaintain(getRidesToMaintain() - 1);
		return true;
	}

	public boolean inMaintenance() {
		return (getRidesToMaintain() == 0);
	}

	public void endMaintenance() {
		setRidesToMaintain(10);
	}

	public boolean availableForAll() {
		return false;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setCurrentAmusers(ArrayList<Amuser> currentAmusers) {
		this.currentAmusers = currentAmusers;
	}

	public ArrayList<Amuser> getCurrentAmusers() {
		return currentAmusers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setRidesToMaintain(int ridesToMaintain) {
		this.ridesToMaintain = ridesToMaintain;
	}

	public int getRidesToMaintain() {
		return ridesToMaintain;
	}
}
