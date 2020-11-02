package fiap.nac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Internacao;
import fiap.nac2.modelo.Leito;
import fiap.nac2.modelo.LiberacaoLeito;
import fiap.nac2.modelo.Paciente;
import fiap.nac2.modelo.TipoLeito;

public class InternacaoDao implements Dao<Internacao> {

	@Override
	public Internacao recuperaPorId(long id) throws Exception {
		String sql = "SELECT i.entrada, i.saida, i.motivo, i.paciente_id, i.leito_id, i.funcionario_id, "
				+ " p.nome, l.numero, l.tipo, f.nome as medico "
				+ "FROM TBL_INTERNACAO i JOIN TBL_PACIENTE p ON (i.paciente_id = p.id) "
				+ "JOIN TBL_LEITO l ON (i.leito_id = l.id) "
				+ "JOIN TBL_FUNCIONARIO f ON (i.funcionario_id = f.id) "
				+ "WHERE id = ?";
		try(Connection con = new ConectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Internacao inter = new Internacao();
				inter.setId(id);
				inter.setMotivo(LiberacaoLeito.values()[rs.getInt("motivo")]);
				
				Paciente pac = new Paciente();
				pac.setId(rs.getLong("paciente_id"));
				pac.setNome(rs.getString("nome"));
				inter.setPaciente(pac);
				
				Leito leito = new Leito();
				leito.setId(rs.getLong("leito_id"));
				leito.setNumero(rs.getString("numero"));
				leito.setTipo(TipoLeito.valueOf(rs.getString("tipo")));
				inter.setLeito(leito);
				
				Funcionario func = new Funcionario();
				func.setId(rs.getLong("funcionario_id"));
				func.setNome(rs.getString("medico"));
				inter.setFuncionario(func);
								
				inter.setEntrada(UtilBanco.converte(rs.getDate("entrada")));
				inter.setSaida(UtilBanco.converte(rs.getDate("saida")));
				
				return inter;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public List<Internacao> recupera(Map<String, Object> parametro)	throws Exception {
		
		if (parametro.containsKey("paciente")) {
			Paciente paciente = (Paciente)parametro.get("paciente");
			return recuperaPorPaciente(paciente);
		}
		else if (parametro.containsKey("motivo")) {
			LiberacaoLeito ll = (LiberacaoLeito)parametro.get("motivo");
			return recuperaPorTipoLiberacao(ll);
		}	
		return null;
	}

	private List<Internacao> recuperaPorTipoLiberacao(LiberacaoLeito ll) throws Exception {
		List<Internacao> retorno = new ArrayList<>();
		String sql = "SELECT * FROM TBL_INTERNACAO WHERE motivo = ?";
		try(Connection con = new ConectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, ll.ordinal());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Internacao inter = new Internacao();
				inter.setId(rs.getLong("id"));
				inter.setMotivo(ll);
				
				Paciente pac = new Paciente();
				pac.setId(rs.getLong("paciente_id"));
				inter.setPaciente(pac);
				
				Leito leito = new Leito();
				leito.setId(rs.getLong("leito_id"));
				inter.setLeito(leito);
				
				Funcionario func = new Funcionario();
				func.setId(rs.getLong("funcionario_id"));
				inter.setFuncionario(func);
				
				inter.setEntrada(UtilBanco.converte(rs.getDate("entrada")));
				inter.setSaida(UtilBanco.converte(rs.getDate("saida")));
				
				retorno.add(inter);
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retorno;
	}

	private List<Internacao> recuperaPorPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Internacao entidade) throws Exception {
		// TODO Exercício
		
	}

	@Override
	public void apaga(long id) throws Exception {
		String sql = "DELETE FROM TBL_INTERNACAO WHERE id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = new ConectionFactory().getConexao();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //propaga a exception
		}
		finally {
			pstmt.close();
			con.close();
		}		
	}

	@Override
	public void salva(Internacao entidade) throws Exception {
		String sql = "INSERT INTO TBL_INTERNACAO(entrada, saida, motivo, paciente_id, leito_id, funcionario_id)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = new ConectionFactory().getConexao();
			pstmt = con.prepareStatement(sql, new String[]{"id"});
			
			pstmt.setDate(1, UtilBanco.converte(entidade.getEntrada()));
			pstmt.setDate(2, UtilBanco.converte(entidade.getSaida()));
			
			pstmt.setInt(3, entidade.getMotivo().ordinal());
			pstmt.setLong(4, entidade.getPaciente().getId());
			pstmt.setLong(5, entidade.getLeito().getId());
			pstmt.setDouble(6, entidade.getFuncionario().getId());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getBigDecimal(1).longValue();
				entidade.setId(id);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //propaga a exception
		}
		finally {
			pstmt.close();
			con.close();
		}		
	}
	
	

}