package fiap.nac2.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Paciente;
import fiap.nac2.negocio.PacienteBO;

/**
 * Servlet implementation class PacienteConsultaController
 */
@WebServlet("/PacienteConsultaController")
public class PacienteConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteConsultaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpServletResponse hres = (HttpServletResponse) response;
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpSession session = hreq.getSession();

		Funcionario u = (Funcionario) session.getAttribute("usuarioLogado");
		if (u == null) {
			session.invalidate();
			hres.sendRedirect("login.jsp");
		}
		
		
		
		String pesquisa = request.getParameter("pesquisa");
		String id = request.getParameter("id");
		
		List<Paciente> lst = null;
		PacienteBO negocio = new PacienteBO();
		try {
			if (pesquisa != null && pesquisa != "") {
			lst = negocio.pesquisa(pesquisa);
			//if(lst != null || lst.size() > 0) {
				request.setAttribute("lst", lst);
			//}
			}else if (id != null && id != "") {
				long i = Long.parseLong(id);
				Paciente p = negocio.ConsultaPorId(i);
				if(p != null) {
					lst = new ArrayList<Paciente>();
					lst.add(p);
					request.setAttribute("msg", "Inseriu dados com sucesso!");
					request.setAttribute("lst", lst);
					
				}
			}
			request.getRequestDispatcher("/views/consultaPaciente.jsp").forward(request, response);
			
		} catch (Exception e) {

			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("/views/consultaPaciente.jsp").forward(request, response);
		}
		
		
		
	}



}
