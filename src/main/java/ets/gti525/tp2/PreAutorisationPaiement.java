package ets.gti525.tp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class PreAutorisationPaiement implements IPaiementDAO{

	private Gson gson = new Gson();
	
	@Override
	public ReponseSystemePaiementTO approuverTransaction(
			RequeteAuthorisationTO info_authorisation) {
		
		// TODO: Optimisation pour ne pas dupliquer le code pour obtenir la clé d'API
		Properties props = new Properties();
		InputStream resources = this.getClass().getClassLoader().getResourceAsStream("api.properties");
		
		try {
			props.load(resources);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = (String)props.get("url");
		String apikey = (String)props.get("apikey");
		
		info_authorisation.setStore_id(Integer.parseInt((String)props.get("store_id")));;
		info_authorisation.setApi_key(apikey);
		
		String api_response = null;
		
		try {
			HttpResponse res = HTTPHelper.getInstance().doPost(url + "transactions.json", gson.toJson(info_authorisation));
			api_response = EntityUtils.toString(res.getEntity());
			System.out.println(api_response);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return gson.fromJson(api_response, ReponseSystemePaiementTO.class);
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(
			InformationsPaiementTO info_paiement) {
		
		Properties props = new Properties();
		InputStream resources = this.getClass().getClassLoader().getResourceAsStream("api.properties");
		
		try {
			props.load(resources);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = (String)props.get("url");
		String apikey = (String)props.get("apikey");
		
		info_paiement.setStore_id(Integer.parseInt((String)props.get("store_id")));
		info_paiement.setOrder_id(6);
		info_paiement.setApi_key(apikey);
		
		String api_response = null;
		
		try {
			HttpResponse res = HTTPHelper.getInstance().doPost(url + "transactions.json", gson.toJson(new InformationsPaiementTOAPI(info_paiement)));
			api_response = EntityUtils.toString(res.getEntity());
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO: Supprimer le root element, parce que le parsing marche pas.
		return gson.fromJson(api_response, ReponseSystemePaiementTO.class);
	}

}
