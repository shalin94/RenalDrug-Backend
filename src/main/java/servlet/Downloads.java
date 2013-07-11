package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Downloads
 */
@WebServlet("/Downloads")
public class Downloads extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/octet-stream");
        ServletContext ctx = getServletContext();
        res.setHeader("Content-Disposition","attachment;filename=".concat("drugs"));
        try {
            InputStream in = ctx.getResourceAsStream("/drugs.db");
            int read = 0;
            byte[] buffer = new byte[1024];
            OutputStream out = res.getOutputStream();
            while((read=in.read(buffer))!= -1)
                out.write(buffer, 0, read);
            out.flush();
            out.close();
        }catch(Exception e) {
            System.err.println("Failed to get resource: drugs.db: " + e);
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
