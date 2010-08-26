package ee.framework.general;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{

	private static final long serialVersionUID = -3068139836733403037L;
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		if (req.getAttribute("id")!=null && req.getAttribute("id") instanceof Integer) {
			int i = (Integer) req.getAttribute("id") + 5;
			System.out.println(i);
		}
		
	}

}
