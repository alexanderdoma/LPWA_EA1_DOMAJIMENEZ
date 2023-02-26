package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import bean.Cine;

/**
 * Servlet implementation class svlCine
 */
public class svlCine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlCine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		switch(id) {
		case "listarCines":
				List<Cine> listCines = new dao.CineDAO().getCines();
				session.setAttribute("id", listCines == null ? null : "listarCines");
				session.setAttribute("data", listCines);
			break;
		case "buscarCine":
				Cine objCine = new dao.CineDAO().getCine(Integer.parseInt(request.getParameter("idCine")));
				session.setAttribute("id", objCine == null ? null : "buscarCine");
				session.setAttribute("data", objCine);
			break;
		}
		response.sendRedirect("index.jsp");
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
