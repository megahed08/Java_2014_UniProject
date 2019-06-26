package eg.edu.guc.parkei.utilities;

import eg.edu.guc.parkei.amusers.*;
import eg.edu.guc.parkei.exceptions.AmuserCanNotPassException;

public class HeightScale extends Scale {

	public HeightScale() {
		super(150);
	}

	public boolean passAmuser(Amuser amuser) throws AmuserCanNotPassException {
		if (this.getLocation() != null && amuser instanceof Senior
				&& amuser.getHeight() >= 150) {
			return true;
		} else {
			if (amuser instanceof Adult && this.getLocation() != null) {
				return true;
			} else {
				if (this.getLocation() != null) {
					throw new AmuserCanNotPassException(
							"scale does not allow an amuser to take a ride");
				} else {
					return false;
				}
			}
		}
	}
}
