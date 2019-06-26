package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.NoRouteException;

public abstract class TransportRide extends Ride {
	private ArrayList<FunRide> routeLocations;
	private ArrayList<FunRide> moveLocations;

	public TransportRide(String name, int duration, int batchSize,
			ArrayList<FunRide> locations) {
		super(name, duration, batchSize);
		routeLocations = new ArrayList<FunRide>();
		setRouteLocations(locations);
		moveLocations = new ArrayList<FunRide>();
		for (FunRide funRide : locations) {
			moveLocations.add(funRide);
		}
	}
	
	public boolean availableForAll() {
		return true;
	}

	/**
	 * @return
	 * 
	 *         A ride in maintenance cannot start. When a transport ride starts,
	 *         it decreases the rides to maintain. Also it moves.
	 */
	public boolean start() throws CannotOperateException {
		if (routeLocations == null || routeLocations.size() == 0) {
			throw new NoRouteException();
		}
		super.start();
		move();
		return true;
	}

	public void unBoard() {
		for (Amuser am : getCurrentAmusers()) {
			am.setLocation(routeLocations.get(0));
		}
		super.unBoard();
	}

	public abstract void move();

	public void setRouteLocations(ArrayList<FunRide> routeLocations) {
		this.routeLocations = routeLocations;
	}

	public ArrayList<FunRide> getRouteLocations() {
		return routeLocations;
	}

	public FunRide getCurrentLocation() {
		return getMoveLocations().get(0);
	}

	/**
	 * @return
	 * 
	 *         The method returns a string representation of all the locations
	 *         in the route.
	 */
	public String getFullRoute() {
		String route = "The followed route is: ";
		ArrayList<FunRide> locations = getRouteLocations();
		for (FunRide location : locations) {
			route += location.getName() + ", ";
		}
		return route;
	}

	protected boolean eligible(Amuser boarder) {
		return true;
	}

	protected boolean correctLocation(Amuser boarder) {
		return boarder.getLocation() != null
				&& boarder.getLocation().equals(getCurrentLocation());
	}

	public void setMoveLocations(ArrayList<FunRide> moveLocations) {
		this.moveLocations = moveLocations;
	}

	public ArrayList<FunRide> getMoveLocations() {
		return moveLocations;
	}

}
