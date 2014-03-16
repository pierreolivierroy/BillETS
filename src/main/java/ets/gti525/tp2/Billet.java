package ets.gti525.tp2;

import java.util.Date;

import org.exolab.castor.types.DateTime;

public class Billet {
	private int id;
	private int id_spectacle;
	private int id_representation;
	private Date dateReserve;
	
	public Billet(int id, int id_spectacle, int id_representation,
			boolean reserve) {
		super();
		this.id = id;
		this.id_spectacle = id_spectacle;
		this.id_representation = id_representation;
		this.dateReserve = null;
	}
	
	public Date getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(Date dateReserve) {
		this.dateReserve = dateReserve;
	}


	public Billet(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isReserve() {
		if (dateReserve != null)
		{
			return true;
		}
		return false;
	}

	public int getId_spectacle() {
		return id_spectacle;
	}

	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}

	public int getId_representation() {
		return id_representation;
	}

	public void setId_representation(int id_representation) {
		this.id_representation = id_representation;
	}
	
}
