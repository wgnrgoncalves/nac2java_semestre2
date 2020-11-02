package fiap.nac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import fiap.nac2.modelo.Paciente;




public class PacienteDao implements Dao<Paciente> {

	@Override
	public Paciente recuperaPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> recupera(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	public static void main(String[] args) throws Exception {
		Paciente pac = new Paciente();
		pac.setNome("teste");
		pac.setEmail("teste@fiap.com.br");
		pac.setNascimento(LocalDate.now());
		PacienteDao pdao = new PacienteDao();
		pdao.salva(pac);
		System.out.println(pac.getId());
		
	}
	
}