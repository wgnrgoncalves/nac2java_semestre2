package fiap.nac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Paciente;
import fiap.nac2.modelo.TipoFuncionario;




public class PacienteDao implements Dao<Paciente> {

	@Override
	public Paciente recuperaPorId(long id) throws Exception {
		// TODO Auto-generated method stub

		
		String sql = "select id, nome, telefone, email, cpf, responsavel, nascimento from tbl_paciente where id = ? ";
		
		try (Connection con = new ConectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Paciente p = new Paciente();
				p.setId(rs.getLong(1));
				p.setNome(rs.getString(2));
				p.setTelefone(rs.getString(3));
				p.setEmail(rs.getString(4));
				p.setCpf(rs.getLong(5));
				p.setResponsavel(rs.getString(6));
				p.setNascimento(UtilBanco.converteDt(rs.getDate(7)));
				return p;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public List<Paciente> recupera(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		//return null;
		if(param.containsKey("pesquisa")) {
			return PesquisaPorNome((String)param.get("pesquisa"));
		}
		return null;
		
	}
	
	private List<Paciente> PesquisaPorNome(String pesquisa) throws Exception{
		
		List<Paciente> lst = new ArrayList();
		
		String sql = "select id, nome, telefone, email, cpf, responsavel, nascimento from tbl_paciente where nome like ?";
		pesquisa = "%" + pesquisa + "%";		
		try (Connection con = new ConectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, pesquisa);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Paciente p = new Paciente();
				p.setId(rs.getLong(1));
				p.setNome(rs.getString(2));
				p.setTelefone(rs.getString(3));
				p.setEmail(rs.getString(4));
				p.setCpf(rs.getLong(5));
				p.setResponsavel(rs.getString(6));
				p.setNascimento(UtilBanco.converteDt(rs.getDate(7)));
				lst.add(p);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return lst;
		
		
	}

	@Override
	public void altera(Paciente entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apaga(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salva(Paciente entidade) throws Exception {
		String sql = "INSERT INTO TBL_PACIENTE(nome, telefone, email, cpf, responsavel, nascimento)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = new ConectionFactory().getConexao();
			pstmt = con.prepareStatement(sql, new String[]{"id"});
			
			pstmt.setString(1, entidade.getNome());
			pstmt.setString(2, entidade.getTelefone());
			pstmt.setString(3, entidade.getEmail());
			pstmt.setLong(4, entidade.getCpf());
			pstmt.setString(5, entidade.getResponsavel());
			pstmt.setDate(6, UtilBanco.converte(entidade.getNascimento()));
			
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