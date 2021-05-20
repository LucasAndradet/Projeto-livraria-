package viewServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ClienteControl;
import control.FuncionarioControl;
import model.Cliente;
import model.Funcionario;

/**
 * Servlet implementation class SvNovoUsuario
 */
@WebServlet("/SvNovoUsuario")
public class SvNovoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvNovoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FuncionarioControl fc= new FuncionarioControl();
		HttpSession session = request.getSession();
		Funcionario f=new Funcionario();
	String usuario=request.getParameter("usuario");
	String  senha=request.getParameter("senha");
	String cpf=	request.getParameter("cpf");
	f=fc.localizar(cpf);
		if(f!=null) {
		f.setUsuario(usuario);	
		f.setSenha(senha);
		if(fc.atualizarFuncionario(f)) {;
		session.setAttribute("alertMsg","login criado com sucesso");
		session.setAttribute("usuario",f);
		request.getRequestDispatcher("menuFuncionario.jsp").forward(request, response);
		}else {
			ClienteControl cc=new ClienteControl();
			Cliente c= new Cliente();
			c=cc.localizar(cpf);
			if(c!=null) {
			c.setUsuario(usuario);
				c.setSenha(senha);
				if(cc.atualizarCliente(c)) {
					session.setAttribute("alertMsg","login criado com sucesso");
					session.setAttribute("usuario",c);
					request.getRequestDispatcher("menuCliente.jsp").forward(request, response);
				}
				
			}else {
				session.setAttribute("alertMsg","login não identificado");
				request.getRequestDispatcher("novoUsuario.jsp").forward(request, response);
			}
			}
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
