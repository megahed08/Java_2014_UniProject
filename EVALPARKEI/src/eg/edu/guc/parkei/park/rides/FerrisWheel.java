package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.utilities.Effect;

public class FerrisWheel extends FunRide {

	public FerrisWheel(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	@Override
	public boolean eligibleToRide(Amuser first) {
		return true;
	}

	@Override
	public ArrayList<Effect> affects(Amuser am) {
		ArrayList<Effect> effects = new ArrayList<Effect>();
		if (am instanceof Baby) {
			effects.add(Effect.Thrilled);
		} else {
			if (am instanceof Adult) {
				effects.add(Effect.Bored);
			} else {
				effects.add(Effect.Happy);
			}
		}
		return effects;

	}
}
