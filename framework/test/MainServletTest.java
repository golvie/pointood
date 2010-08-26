import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mock.web.MockHttpServletRequest;

import ee.framework.general.MainServlet;

import junit.framework.TestCase;


public class MainServletTest extends TestCase {
	Servlet servlet;

	protected void setUp() throws Exception {
		super.setUp();
		servlet = new MainServlet();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testService() throws ServletException, IOException {
		HttpServletRequest req = new MockHttpServletRequest();
		req.setAttribute("id", 12);
		servlet.service(req, null);
	}

}
