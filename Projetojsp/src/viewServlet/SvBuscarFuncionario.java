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
 * Servlet implementation class SvBuscarFuncionario
 */
@WebServlet("/SvBuscarFuncionario")
public class SvBuscarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvBuscarFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	Funcionario f = new Funcionario();
	FuncionarioControl fc=new FuncionarioControl(); 
	String cpf = request.getParameter("cpf");
	f=fc.localizar(cpf);
	if(f==null) {
		session.setAttribute("alertMsg","funcionario não encontrado");
		request.getRequestDispatcher("pesquisarFuncionario.jsp").forward(request, response);	
	}else {
		session.setAttribute("funcionario",f);
		request.getRequestDispatcher("editarFuncionario.jsp").forward(request, response);		
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
