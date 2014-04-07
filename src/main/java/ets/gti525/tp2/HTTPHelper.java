package ets.gti525.tp2;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

// La classe est final, car un singleton n'est pas censé avoir d'héritier.
// En effet, en Java il n'y a pas de polymorphisme sur les méthodes static, il est
// donc préférable de verrouiller la classe.
public final class HTTPHelper {

    // L'utilisation du mot clé volatile permet, en Java version 5 et supérieur, 
    // permet d'éviter le cas où "Singleton.instance" est non-nul,
    // mais pas encore "réellement" instancié.
    // De Java version 1.2 à 1.4, il est possible d'utiliser la classe ThreadLocal.
    private static volatile HTTPHelper instance = null;

    // D'autres attributs, classiques et non "static".
    private String xxx;
    private int zzz;

    /**
     * Constructeur de l'objet.
     */
    private HTTPHelper() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        // De plus, seul le singleton peut s'instancier lui même.
        super();
    }

    /**
     * Méthode permettant de renvoyer une instance de la classe Singleton
     * @return Retourne l'instance du singleton.
     */
    public final static HTTPHelper getInstance() {
        //Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet 
        //d'éviter un appel coûteux à synchronized, 
        //une fois que l'instanciation est faite.
        if (HTTPHelper.instance == null) {
           // Le mot-clé synchronized sur ce bloc empêche toute instanciation
           // multiple même par différents "threads".
           // Il est TRES important.
           synchronized(HTTPHelper.class) {
             if (HTTPHelper.instance == null) {
            	 HTTPHelper.instance = new HTTPHelper();
             }
           }
        }
        return HTTPHelper.instance;
    }

    public HttpResponse doPost(String hostname, String payload) throws HttpException, IOException, URISyntaxException
    {
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpPost request = new HttpPost(hostname);
    	request.addHeader("content-type", "application/json");

    	StringEntity userEntity = new StringEntity(payload);
    	request.setEntity(userEntity);
    	
    	return httpClient.execute(request);
    }
    public HttpResponse doGet(String hostname) throws HttpException, IOException, URISyntaxException
    {
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpGet request = new HttpGet(hostname);
    	request.addHeader("content-type", "application/json");
    	
    	return httpClient.execute(request);
    }

}