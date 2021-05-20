package viewServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ClienteControl;
import model.Cliente;

/**
 * Servlet implementation class SvClienteCadastrar
 */
@WebServlet("/SvClienteCadastrar")
public class SvClienteCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvClienteCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	Cliente c = new Cliente();
	ClienteControl cc= new ClienteControl();
	c.setNome(request.getParameter("nome"));
	c.setCpf(request.getParameter("cpf"));
	c.setSexo(request.getParameter("sexo"));
	c.setIdade(Integer.parseInt(request.getParameter("idade")));
	if (cc.cadastrarCliente(c)) {
		
		session.setAttribute("alertMsg","Cadastro com sucesso");
		request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
	}else {
		
		session.setAttribute("alertMsg","Cadastro não realizado");
		request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
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
