package fiap.nac2.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiap.nac2.dao.Dao;
import fiap.nac2.dao.PacienteDao;
import fiap.nac2.modelo.Paciente;
public class PacienteBO {
	Dao<Paciente> dao = null;
	public PacienteBO() {
		dao =  new PacienteDao();
	}
	
	public List<Paciente> pesquisa(String pesquisa) throws Exception{
		
		Map<String, Object> param = new HashMap();
		param.put("pesquisa", pesquisa);
		return dao.recupera(param);
	}
			
	public void inclui(Paciente pac) throws Exception {
		//validar as regras de negócio
		
		dao.salva(pac);
		
	}
}
