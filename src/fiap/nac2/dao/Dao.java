package fiap.nac2.dao;

import java.util.List;
import java.util.Map;

public interface Dao<E> {
	public E recuperaPorId(long id) throws Exception;

	public List<E> recupera(Map<String, Object> param) throws Exception;
	
	public void altera(E entidade) throws Exception;
	
	public void apaga(long id) throws Exception;
	
	public void salva(E entidade) throws Exception;
}
