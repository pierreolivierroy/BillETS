package ets.gti525.tp2;

import java.util.ArrayList;

public interface ISpectacleDAO {
	public ArrayList<Spectacle> getListeSpectacles();
	public Spectacle getSpectacleID(int id);
	public ArrayList<Spectacle> getSpectacleNom(String spectacleNom);
}