package fiap.nac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import fiap.nac2.modelo.Prontuario;

public class ProntuarioDao implements Dao<Prontuario> {

	@Override
	public Prontuario recuperaPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prontuario> recupera(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Prontuario entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apaga(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salva(Prontuario entidade) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO TBL_PRONTUARIO(DATA, OBSERVACOES, PACIENTE_ID, FUNCIONARIO_ID)"
				+ " VALUES(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = new ConectionFactory().getConexao();
			pstmt = con.prepareStatement(sql, new String[]{"id"});
			 
			
			pstmt.setDate(1, UtilBanco.converte(entidade.getData()));
			pstmt.setString(2, entidade.getObservacoes());
			pstmt.setLong(3, entidade.getPaciente().getId());
			pstmt.setLong(4, entidade.getResponsavel().getId());
			
			
			
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
