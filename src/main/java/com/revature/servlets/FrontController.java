package com.revature.servlets;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AuthController;
import com.revature.controllers.ErrorController;
import com.revature.controllers.EmployeeController;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;

/**
 * Servlet implementation class FrontController
 */
@SuppressWarnings("serial")
public class FrontController extends HttpServlet {
	
	private AuthController authController = new AuthController();
	
	private ErrorController errorController = new ErrorController();
	
	private EmployeeController empController = new EmployeeController();

	
	protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//to handle all internal errors/exceptions
		try {
			directControlRouter(request, response);
		}catch (Throwable t) {
			errorController.handle(request, response, t);//go to the error controller
		}
	}
	
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, UserNotFoundException, InternalErrorException {
		//how to get a value from your init params
		System.out.println(this.getInitParameter("DefaultRole"));
		ServletContext sc = this.getServletContext();
		
		System.out.println(sc.getInitParameter("JavaCoolFactor"));
		
		//be our front controller
		String URI = req.getRequestURI().substring(req.getContextPath().length(), 
													req.getRequestURI().length());
		
		System.out.println(URI);
		switch (URI) {
			case "/login":
				System.out.println(req.getMethod());
				
				switch (req.getMethod()) {
					case "GET":
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					case "POST":
						authController.userLogin(req, res);
						break;
					case "PUT":
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					case "DELETE":
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					default:
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
				}
				
			case "/reimbursements":
				switch (req.getMethod()) {
					case "GET":
						empController.viewAllRequests(req, res);
						break;
					case "POST":
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					case "PUT":
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					case "DELETE":
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					default:
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
				}
				
			default:
				res.setStatus(404);
				res.getWriter().write("No Such Resource");
				break;
			
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

}
