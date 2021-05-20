package viewServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.FuncionarioControl;
import model.Funcionario;

/**
 * Servlet implementation class SvLogin
 */
@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		FuncionarioControl fc = new FuncionarioControl();
		Funcionario f = new Funcionario();
		f = fc.localizarUsuario(request.getParameter("usuario"));
		if (f == null) {
			session.setAttribute("alertMsg", "usuario não encontrado");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}else if(f.getSenha()!=request.getParameter("senha")) {
			session.setAttribute("alertMsg", "senha invalida");
			request.getRequestDispatcher("Login.jsp").forward(request, response);	
		}else {
			session.setAttribute("usuario", f);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
