package fiap.nac2.controle;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fiap.nac2.modelo.Paciente;
import fiap.nac2.negocio.PacienteBO;

/**
 * Servlet implementation class IncluiPaciente
 */
@WebServlet("/PacienteController")
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PacienteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/cadastraPaciente.jsp").forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pegando informações do paciente através do formulário
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String nascimento = request.getParameter("nascimento");
		String responsavel = request.getParameter("responsavel");
		String telefone = request.getParameter("telefone");
		
		//criando e preenchendo objeto Paciente
		Paciente pac = new Paciente();
		pac.setNome(nome);
		pac.setEmail(email);
		pac.setCpf(Long.parseLong(cpf));
		pac.setResponsavel(responsavel);
		pac.setTelefone(telefone);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		pac.setNascimento(LocalDate.parse(nascimento, dtf));
		
		//Instancia o Business Object (BO)
		PacienteBO negocio = new PacienteBO();
		try {
			negocio.inclui(pac);
		
			request.setAttribute("paciente", pac);
			request.setAttribute("msg", "Paciente incluído com sucesso!");
		
			request.getRequestDispatcher("/views/exibePaciente.jsp").forward(request, response);
		}
		catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
	}

}
