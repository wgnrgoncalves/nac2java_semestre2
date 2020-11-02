package fiap.nac2.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fiap.nac2.modelo.Funcionario;
import fiap.nac2.modelo.Internacao;
import fiap.nac2.negocio.InternacaoBO;
import fiap.nac2.negocio.ProntuarioBO;

/**
 * Servlet implementation class PacienteDetalhesController
 */
@WebServlet("/PacienteDetalhesController")
public class PacienteDetalhesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contextPath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacienteDetalhesController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init(FilterConfig filterConfig) {
        this.contextPath = filterConfig.getServletContext().getContextPath();
    }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpServletResponse hres = (HttpServletResponse) response;
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpSession session = hreq.getSession();

		Funcionario u = (Funcionario) session.getAttribute("usuarioLogado");
		if (u == null) {
			session.invalidate();
			hres.sendRedirect("login.jsp");
		}
		
		
		
		

		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		
		long i = Long.parseLong(id);
		
		if(acao.equals("RandInternacao")) {
			
		
			ProntuarioBO negocio = new ProntuarioBO();
			try {
				negocio.AtendimentoFake(i, u.getId());
				request.setAttribute("id", i);
				request.getRequestDispatcher("/PacienteConsultaController").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}else if(acao.equals("Detalhes")) {
			
			InternacaoBO negocio = new InternacaoBO();
			List<Internacao> lst = null;
			try {
				lst = negocio.getInternacaoPorPaciente(i);
				request.setAttribute("lst", lst);
				
				request.getRequestDispatcher("/views/detalhesPaciente.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}else {
			request.getRequestDispatcher("/Index").forward(request, response);
		}

	}

}
