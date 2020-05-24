package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/cadastroUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if (acao.equalsIgnoreCase("delete")) {
				daoUsuario.delete(user);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
				
			} else if (acao.equalsIgnoreCase("editar")) {
				BeanCursoJsp beanCursoJsp = daoUsuario.consultar(user);
				
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", beanCursoJsp);
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id_login");
		String login = request.getParameter("novo_login");
		String senha = request.getParameter("nova_senha");

		try {
			if (daoUsuario.ValidarNovoUsuario(login)) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				dispatcher.forward(request, response);
				JOptionPane.showMessageDialog(null, "Usuario J� Existe");

			} else {
				BeanCursoJsp usuario = new BeanCursoJsp();
				usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				
				if(id == null || id.isEmpty()) {
					daoUsuario.salvar(usuario);
				}else {
					daoUsuario.atualizar(usuario);
				}
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
