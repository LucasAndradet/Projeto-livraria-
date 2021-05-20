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
 * Servlet implementation class SvFuncionarioCadastrar
 */
@WebServlet("/SvFuncionarioCadastrar")
public class SvFuncionarioCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvFuncionarioCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Funcionario f= new Funcionario();
		FuncionarioControl fc= new FuncionarioControl();
		f.setNome(request.getParameter("nome"));
		f.setCpf(request.getParameter("cpf"));
		f.setTel(request.getParameter("tel"));
		f.setCel(request.getParameter("cel"));
		f.setIdt(request.getParameter("idt"));
		f.setEmail(request.getParameter("email"));
		if(fc.criarFuncionario(f)) {
			session.setAttribute("alertMsg","Cadastro com sucesso");
			request.getRequestDispatcher("cadastroFuncionario.jsp").forward(request, response);
		}else {
			session.setAttribute("alertMsg","Cadastro não realizado");
			request.getRequestDispatcher("cadastroFuncionario.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
