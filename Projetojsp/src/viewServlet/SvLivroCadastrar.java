package viewServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.LivroControl;
import model.Livro;

/**
 * Servlet implementation class SvLivroCadastrar
 */
@WebServlet("/SvLivroCadastrar")
public class SvLivroCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvLivroCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Livro l=new Livro();
		LivroControl lc= new LivroControl();
		l.setNome(request.getParameter("nome"));
		l.setAutor(request.getParameter("autor"));
		l.setEditora(request.getParameter("editora"));
		l.setNrPaginas(Integer.parseInt(request.getParameter("nrPaginas")));
		l.setPreco(Double.parseDouble(request.getParameter("preco")));
		if(lc.cadastrarLivro(l)) {
			session.setAttribute("alertMsg","Cadastro com sucesso");
			request.getRequestDispatcher("cadastroLivro.jsp").forward(request, response);
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
