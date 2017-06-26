package quest.eni.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

    public static final String FICHIER_PROPERTIES        = "/app/ajn/login/dao/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_NOM_UTILISATEUR = "nom_utilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "mdp";

    private String url;
    private String username;
    private String password;

    DAOFactory(String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * M�thode de r�cup�ration de l'instance
     * 
     * @return Retourne une instance de DAOFactory
     * @throws DAOException
     */
    public static DAOFactory getInstance() throws DAOException {
    	Properties properties = new Properties();
        String url;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
        //local test
        //fichierProperties = new FileInputStream( "C:/Users/eddayanih/workspace/DashboardManager/src/com/dev/dao/dao.properties" );
        if ( fichierProperties == null ) {
            throw new DAOException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
        	//Chargement du ficher properties
            properties.load( fichierProperties );
            //R�cup�ration des informations
            url = properties.getProperty( PROPERTY_URL );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }

        DAOFactory instance = new DAOFactory(url, nomUtilisateur, motDePasse );
        return instance;
    }

    Connection getConnection() throws SQLException, ClassNotFoundException {
    	// chargement du pilote
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection( url, username, password );
    }

    /**
     * Récupération d'un instance de UserDao
     * 
     * @return : Retourne une instance de UserDao
     */
    public PersonneDAO getPersonneDAO() {
        return PersonneDAOImpl.getInstance();
    }

}