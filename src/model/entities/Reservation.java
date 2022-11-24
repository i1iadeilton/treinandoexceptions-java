package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		//criando uma variavel para pegar a data de agora
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			//quandos os argumentos são invalidos
			throw new DomainException("Reservation dates for update most be future dates");
		}
		
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Rom "
		+ roomNumber
		+", check-in: "
		+ sdf.format(checkIn)
		+ ", check-out: "
		+ sdf.format(checkOut)
		+ ", " 
		+ duration()
		+ " nights";
	}
	
}
