package quest.eni.dao;

public class PersonneDAOImpl implements PersonneDAO{

	private static PersonneDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_VERIFY_USER = "SELECT COUNT(*) FROM user "
										+ "WHERE username = ? "
										+ "AND password = ?";
	
	public PersonneDAOImpl() {
	
	}

	public static PersonneDAO getInstance() {
		if (instance == null) {
			instance = new PersonneDAOImpl();
		}
		return instance;
	}
	
}
