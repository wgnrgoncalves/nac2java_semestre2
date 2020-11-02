package fiap.nac2.negocio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Set;

import fiap.nac2.dao.Dao;
import fiap.nac2.dao.ExceptionDao;
import fiap.nac2.dao.FuncionarioDao;
import fiap.nac2.modelo.Funcionario;

public class FuncionarioBO {
	Dao<Funcionario> dao = null;

	public FuncionarioBO() {
		this.dao = new FuncionarioDao();
	}

	public void Incluir(Funcionario funcionario) throws Exception {

		// verifica se campos estão preenchidos
		if (funcionario.getNome().trim() == "") {
			throw new ExceptionDao("Nome vazio");
		}

		if (funcionario.getLogin().trim() == "") {
			throw new ExceptionDao("Login vazio");
		}

		if (funcionario.getSenha().trim() == "") {
			throw new ExceptionDao("Senha vazia");
		}

		if (Existe(funcionario.getLogin())) {
			throw new ExceptionDao("Usuário já existe!");
		}
		
		funcionario.setSenha(MD5(funcionario.getSenha()));

		
		dao.salva(funcionario);

	}

	private String MD5(String str) throws NoSuchAlgorithmException {

		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(str.getBytes(), 0, str.length());
		return new BigInteger(1, m.digest()).toString(16);
	}
	
	
	public Funcionario login(String login, String senha) throws Exception{
		
		if(login == null) {
			throw new ExceptionDao("Login vazio");
		}
		if(senha == null) {
			throw new ExceptionDao("Senha vazia");
		}
		Funcionario f = new Funcionario();
		f.setLogin(login);
		f.setSenha(MD5(senha));
		
		List<Funcionario> lst = null;
		
		Map<String, Object> param = new HashMap();
		param.put("login_e_senha", f);
		
		try {
			lst = dao.recupera(param);
			
			if(lst != null) {
				return lst.get(0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return null;	
	}
	

	public boolean Existe(String login) {
		List<Funcionario> lst = null;

		Map<String, Object> param = new HashMap();
		param.put("login", login);

		try {
			lst = dao.recupera(param);

			return lst != null && lst.size() > 0;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
