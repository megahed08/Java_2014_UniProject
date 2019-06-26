package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.NoRidersException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;
import eg.edu.guc.parkei.utilities.Effect;

public abstract class FunRide extends Ride {

	public FunRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	/**
	 * Only amusers eligible to take a ride can board it.
	 */
	public boolean board(Amuser boarder) throws CannotBoardException,
			OutOfOrderException {
		if (!eligibleToRide(boarder)) {
			throw new CannotBoardException("You cannot take this ride");
		}
		return super.board(boarder);
	}

	/**
	 * @return
	 * 
	 *         A fun ride can only run if it is not being maintained and
	 *         somebody is boarding it. All amusers on board get affected by the
	 *         ride's effects.
	 */
	public boolean start() throws CannotOperateException {
		if (getCurrentAmusers().isEmpty()) {
			throw new NoRidersException();
		}
		super.start();
		ArrayList<Amuser> efAmusers = getCurrentAmusers();
		for (Amuser am : efAmusers) {
			ArrayList<Effect> effs = affects(am);
			am.setEffects(new ArrayList<Effect>());
			for (Effect effect : effs) {
				am.applyEffects(effect);
			}

		}
		return true;
	}

	public abstract boolean eligibleToRide(Amuser first)
			throws CannotBoardException;

	public abstract ArrayList<Effect> affects(Amuser am);

	protected boolean correctLocation(Amuser boarder) {
		return boarder.getLocation() != null
				&& boarder.getLocation().equals(this);
	}

}
