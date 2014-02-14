package ets.gti525.tp2;

import java.util.ArrayList;

public interface ISpectacleDAO {
	public ArrayList<Spectacle> getSpectacles();
	public Spectacle getSpectacle(int id);
	public ArrayList<Spectacle> getSpectacleNom(String spectacleNom);
}