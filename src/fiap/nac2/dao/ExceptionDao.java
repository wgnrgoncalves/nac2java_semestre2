package fiap.nac2.dao;

public class ExceptionDao extends Exception{
	public ExceptionDao(Throwable cause) {
        super(cause);
    }

    public ExceptionDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDao(String message) {
        super(message);
    }

    public ExceptionDao() {
        super();
    }
}
