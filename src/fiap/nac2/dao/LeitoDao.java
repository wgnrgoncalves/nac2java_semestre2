package fiap.nac2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import fiap.nac2.modelo.Leito;

public class LeitoDao implements Dao<Leito>{

	@Override
	public Leito recuperaPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leito> recupera(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Leito entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apaga(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salva(Leito entidade) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO TBL_LEITO(numero, tipo, liberacao, status)"
				+ " VALUES(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = new ConectionFactory().getConexao();
			pstmt = con.prepareStatement(sql, new String[]{"id"});
			 
			
			pstmt.setString(1, entidade.getNumero());
			pstmt.setString(2, entidade.getTipo().toString());
			pstmt.setDate(3, UtilBanco.converte(entidade.getLiberacao()));
			pstmt.setString(4, entidade.getStatus().toString());
			
			
			
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
