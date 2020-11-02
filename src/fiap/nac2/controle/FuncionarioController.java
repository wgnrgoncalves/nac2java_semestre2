package fiap.nac2.controle;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Paciente;
import fiap.nac2.modelo.TipoFuncionario;
import fiap.nac2.negocio.FuncionarioBO;
import fiap.nac2.negocio.PacienteBO;

/**
 * Servlet implementation class FuncionarioController
 */
@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request.getRequestDispatcher("WEB-INF/views/novoFuncionario.jsp").forward(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/novoFuncionario.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipoFuncionario");
		String login = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		//criando e preenchendo objeto Funcionario
		Funcionario func = new Funcionario();
		func.setNome(nome);
		func.setTipo(TipoFuncionario.valueOf(tipo));
		func.setLogin(login);
		func.setSenha(senha);
		
		
		//Instancia o Business Object (BO)
		FuncionarioBO negocio = new FuncionarioBO();
		try {
			negocio.Incluir(func);
			
			request.getSession().setAttribute("usuarioLogado", func);
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}
		catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("/views/novoFuncionario.jsp").forward(request, response);
		}
	}

}
