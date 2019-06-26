package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.parkei.utilities.Ticket;

public class Baby extends Amuser {

	public Baby(final String name, final int age, final double height)
			throws WrongAgeException {
		super(name, age, height);
		if (age < 0) {
			throw new WrongAgeException("An amuser can never have negative age");
		}
		if (age >= 4) {
			throw new WrongAgeException(
					"An amuser older than 3 years is not considered a baby anymore");
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
		if (!ticket.equals(Ticket.Micro)) {
			throw new WrongTicketException("Babies can only get Micro tickets");
		}
		setTicket(ticket);
	}

}
