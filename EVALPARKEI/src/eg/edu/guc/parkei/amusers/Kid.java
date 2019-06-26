package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.parkei.utilities.Ticket;

public class Kid extends Amuser {

	public Kid(final String name, final int age, final double height) throws WrongAgeException {
		super(name, age, height);
		if (age < 4) {
			throw new WrongAgeException(
					"An amuser younger than 4 years is not considered a kid yet");
		}
		if (age > 14) {
			throw new WrongAgeException(
					"An amuser older than 4 years is not considered a kid anymore");
		}
	}

	@Override
	public Ticket getTicket() {
		return super.getTicket();
	}

	/* (non-Javadoc)
	 * @see eg.edu.guc.parkei.amusers.Rider#buyTicket(eg.edu.guc.parkei.utilities.Ticket)
	 */
	@Override
	public void buyTicket(Ticket ticket) throws WrongTicketException {
		if (!ticket.equals(Ticket.Mini)) {
			throw new WrongTicketException("Kids can only get Mini tickets");
		}
		setTicket(ticket);
	}
}
