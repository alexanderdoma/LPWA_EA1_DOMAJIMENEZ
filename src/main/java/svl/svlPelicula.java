package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import bean.Pelicula;

/**
 * Servlet implementation class svlPelicula
 */
public class svlPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlPelicula() {
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
			case "cartelera":
					List<Pelicula> listPeliculaCartelera = new dao.PeliculaDAO().getPeliculas(1);
					session.setAttribute("id", listPeliculaCartelera== null ? null : "cartelera");
					session.setAttribute("data", listPeliculaCartelera);
					break;
			case "estrenos":
					List<Pelicula> listPeliculaEstreno = new dao.PeliculaDAO().getPeliculas(2);
					session.setAttribute("id", listPeliculaEstreno == null ? null : "estrenos");
					session.setAttribute("data", listPeliculaEstreno);
					break;
			case "buscarPelicula":
					Pelicula objPelicula = new dao.PeliculaDAO().getPelicula(Integer.parseInt(request.getParameter("idPelicula")));
					session.setAttribute("id", objPelicula == null ? null : "buscarPelicula");
					session.setAttribute("data", objPelicula);
				break;
		}
		response.sendRedirect("index.jsp");
		
		
		/*if ( id != null && ( id.equals("cartelera") || id.equals("estrenos") ) ) {
			Object data = new dao.PeliculaDAO().getPeliculas( id.equals("cartelera") ? 1 : 2 );
			session.setAttribute("id", data == null ? null : "peliculas");
			session.setAttribute("data", data);
		}*/
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
