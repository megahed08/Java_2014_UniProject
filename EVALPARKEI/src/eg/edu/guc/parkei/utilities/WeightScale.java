package eg.edu.guc.parkei.utilities;

import eg.edu.guc.parkei.amusers.*;
import eg.edu.guc.parkei.exceptions.AmuserCanNotPassException;

public class WeightScale extends Scale {
	public WeightScale() {
		super(100);
	}

	public boolean passAmuser(Amuser amuser) throws AmuserCanNotPassException {

		if (this.getLocation() != null && amuser instanceof Baby
				|| this.getLocation() != null && amuser instanceof Kid) {
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
