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
 * Servlet implementation class SvAtualizarFuncionario
 */
@WebServlet("/SvAtualizarFuncionario")
public class SvAtualizarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvAtualizarFuncionario() {
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
		System.out.println(f.getCpf());
		System.out.println(f.getIdt());
		System.out.println(f.getTel());
		System.out.println(f.getNome());
		System.out.println(f.getEmail());
		System.out.println(f.getCel());
		if(fc.editarFuncionario(f,f.getCpf())) {
			session.setAttribute("alertMsg","alterações feitas com sucesso");
			request.getRequestDispatcher("editarFuncionario.jsp").forward(request, response);
		}else {
			session.setAttribute("alertMsg","alterações não conseguiram ser concluidas");
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
