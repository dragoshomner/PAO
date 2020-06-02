package dao;

public final class DaoCredentials {
    final static String DB_URL = "jdbc:mysql://localhost/pao";
    final static String USER = "root";
    final static String PASS = "root";

    public static DaoCredentials instance = null;

    private DaoCredentials() { }

    public static DaoCredentials getInstance() {
        if (instance == null) {
            instance = new DaoCredentials();
        }
        return instance;
    }
}
