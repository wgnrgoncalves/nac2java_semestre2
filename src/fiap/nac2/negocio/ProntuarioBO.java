package fiap.nac2.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fiap.nac2.dao.Dao;
import fiap.nac2.dao.ExceptionDao;
import fiap.nac2.dao.FuncionarioDao;
import fiap.nac2.dao.InternacaoDao;
import fiap.nac2.dao.LeitoDao;
import fiap.nac2.dao.ProntuarioDao;
import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Internacao;
import fiap.nac2.modelo.Leito;
import fiap.nac2.modelo.LiberacaoLeito;
import fiap.nac2.modelo.Paciente;
import fiap.nac2.modelo.Prontuario;
import fiap.nac2.modelo.StatusLeito;
import fiap.nac2.modelo.TipoLeito;

public class ProntuarioBO {

	Dao<Prontuario> pdao = null;
	Dao<Leito> ldao = null;
	Dao<Internacao> idao = null;
	
	public ProntuarioBO() {
		pdao = new ProntuarioDao();
		ldao = new LeitoDao();
		idao = new InternacaoDao();
		
		
	}
	
	public void AtendimentoFake(long id_paciente, long id_funcionario) throws ExceptionDao {
		
		Funcionario func = new Funcionario();
		func.setId(id_funcionario);
		
		Paciente pac = new Paciente();
		pac.setId(id_paciente);
		//insere leito
		
		Leito l = new Leito();
		l.setNumero("0001");
		l.setLiberacao(LocalDate.now());
		l.setTipo(TipoLeito.ENF_ADULTO);
		l.setStatus(StatusLeito.OCUPADO);
		
		try {
			ldao.salva(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionDao("Erro para inserir leito");
		}
		
		
		
		Prontuario p = new Prontuario();
		p.setData(LocalDateTime.now());
		p.setObservacoes("observacoes");
		p.setPaciente(pac);
		p.setResponsavel(func);
		
		try {
			pdao.salva(p);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ExceptionDao("Erro para inserir Prontuario");
		}
		
		
		
		Internacao i = new Internacao();
		i.setEntrada(LocalDateTime.now());
		i.setSaida(LocalDateTime.now());
		i.setPaciente(pac);
		i.setLeito(l);
		i.setFuncionario(func);
		i.setMotivo(LiberacaoLeito.TRANSFERENCIA);
		
		try {
			idao.salva(i);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDao("Erro para inserir internação");
		}

		


		
		
	}
   
}
