package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.security.MessageDigest;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
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
		if(req.getParameter("checksum").equals("true")) {
			res.setContentType("text/plain");
			ServletContext ctx = getServletContext();
			byte [] buffer = new byte[1024];
			try{
				MessageDigest md = MessageDigest.getInstance("MD5");
				InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/drugs.db");
				ServletOutputStream out = res.getOutputStream();
				int numRead;	
				do {
					numRead = in.read(buffer);
					if (numRead > 0) {
						md.update(buffer,0,numRead);
					}
				} while (numRead != -1);
				in.close();
				byte [] md5 = md.digest();
				String checksum = "";
				for (int i =0;i<md5.length;i++){
					checksum += Integer.toString((md5[i] & 0xff) + 0x100, 16).substring(1);
				}
				out.println(checksum);
				out.flush();
				out.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		res.setContentType("application/octet-stream");
       		ServletContext ctx = getServletContext();
	        res.setHeader("Content-Disposition","attachment;filename=".concat("drugs.db"));
        	try {
		            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/drugs.db");
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
