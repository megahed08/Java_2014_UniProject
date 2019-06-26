package eg.edu.guc.parkei.utilities;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.AmuserCanNotPassException;
import eg.edu.guc.parkei.park.rides.FunRide;

public abstract class Scale {
	private FunRide location = null;
	private int price;

	public Scale() {

	}

	public Scale(int price) {
		this.price = price;
	}

	public void installAt(FunRide location) {
		this.location = location;
	}

	public abstract boolean passAmuser(Amuser amuser)
			throws AmuserCanNotPassException;

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public FunRide getLocation() {
		return location;
	}
}
