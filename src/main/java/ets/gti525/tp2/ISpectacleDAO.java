package ets.gti525.tp2;

import java.util.HashMap;

/**
 * This class make sure that SpectacleDAO implements these methods
 * @author dannyboyer
 *
 */
public interface ISpectacleDAO {
	
	public HashMap<Integer, Spectacle> getSpectacles(String nomSpectacle);
	
	public Spectacle getSpectacle(int id);
	
	public HashMap<Integer, Representation> getRepresentations(int idSpectacle);
	
	public Representation getRepresentation(int idSpectacle, int idRepresentation);
}
