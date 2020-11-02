package fiap.nac2.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiap.nac2.dao.Dao;
import fiap.nac2.dao.InternacaoDao;
import fiap.nac2.modelo.Internacao;
import fiap.nac2.modelo.Paciente;

public class InternacaoBO {
	Dao<Internacao> dao = null;
	public InternacaoBO() {
		dao  = new InternacaoDao();
	}
	
	public List<Internacao> getInternacaoPorPaciente(long id) throws Exception{
		
		Paciente p = new Paciente();
		p.setId(id);
		
		
		Map<String, Object> param = new HashMap();
		param.put("paciente", p);
		return dao.recupera(param);
		
		
	}

}
