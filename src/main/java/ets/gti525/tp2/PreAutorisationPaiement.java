package ets.gti525.tp2;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class PreAutorisationPaiement implements IPaiementDAO{

	@Override
	public ReponseSystemePaiementTO approuverTransaction(
			RequeteAuthorisationTO arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(
			InformationsPaiementTO info_paiement) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
		
		//this is just for demo, a cvv code of 999 will result in a faillure
		if(info_paiement.getSecurity_code() == 999) {
			//faillure
			reponse.setCode(0);
		}
		else{
			//success
			reponse.setCode(1);
		}	
		return reponse;
	}

}
