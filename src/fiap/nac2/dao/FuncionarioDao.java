package fiap.nac2.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Internacao;
import fiap.nac2.modelo.Leito;
import fiap.nac2.modelo.LiberacaoLeito;
import fiap.nac2.modelo.Paciente;
import fiap.nac2.modelo.TipoFuncionario;
import fiap.nac2.modelo.TipoLeito;

public class FuncionarioDao implements Dao<Funcionario> {

	@Override
	public Funcionario recuperaPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> recupera(Map<String, Object> param) throws Exception {
		if (param.containsKey("login")) {
			String login = (String) param.get("login");
			return recuperaPorLogin(login);
		}else if(param.containsKey("login_e_senha")) {
			Funcionario func = (Funcionario)param.get("login_e_senha");
			return login(func);
		}

		return null;
	}
	
	private List<Funcionario> login(Funcionario f) throws SQLException, Exception {
		List<Funcionario> retorno = new ArrayList();

		String sql = "select id, nome, tipo, login, senha from tbl_funcionario where login = ? and senha = ? ";
		try (Connection con = new ConectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, f.getLogin());
			pstmt.setString(2, f.getSenha());
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setTipo(TipoFuncionario.valueOf(rs.getString(3)));
				funcionario.setLogin(rs.getString(4));
				funcionario.setSenha(rs.getString(5));
				retorno.add(funcionario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retorno;

	}

	private List<Funcionario> recuperaPorLogin(String login) throws SQLException, Exception {
		List<Funcionario> retorno = new ArrayList();

		String sql = "select id, nome, tipo, login, senha from tbl_funcionario where login = ?";
		try (Connection con = new ConectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setTipo(TipoFuncionario.valueOf(rs.getString(3)));
				funcionario.setLogin(rs.getString(4));
				funcionario.setSenha(rs.getString(5));
				retorno.add(funcionario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retorno;

	}

	@Override
	public void altera(Funcionario entidade) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void apaga(long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void salva(Funcionario entidade) throws Exception {
		String sql = "insert into tbl_funcionario(nome, tipo, login, senha) values(?,?,?,?)";
		String generatedColumns[] = {"ID"};
		try (Connection con = new ConectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql, generatedColumns)) {

			pstmt.setString(1, entidade.getNome());
			pstmt.setString(2, entidade.getTipo().toString());
			pstmt.setString(3, entidade.getLogin());
			pstmt.setString(4, entidade.getSenha());

			pstmt.execute();

			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					
					long id = generatedKeys.getBigDecimal(1).longValue();
					entidade.setId(id);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
