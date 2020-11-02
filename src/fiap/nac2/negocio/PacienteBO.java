package fiap.nac2.negocio;

import fiap.nac2.dao.Dao;
import fiap.nac2.dao.PacienteDao;
import fiap.nac2.modelo.Paciente;
public class PacienteBO {
	public void inclui(Paciente pac) throws Exception {
		//validar as regras de negócio
		Dao<Paciente> dao = new PacienteDao();
		dao.salva(pac);
		
	}
}
