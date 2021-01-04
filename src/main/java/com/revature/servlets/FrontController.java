package com.revature.servlets;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AuthController;
import com.revature.controllers.ErrorController;
import com.revature.controllers.ManagerController;
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
	
	private ManagerController manController = new ManagerController();

	protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// to handle all internal errors/exceptions
		try {
			directControlRouter(request, response);
		} catch (Throwable t) {
			errorController.handle(request, response, t);// go to the error controller
		}
	}

	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, UserNotFoundException, InternalErrorException {

		String URI = req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length());

		System.out.println(URI);
		switch (URI) {

		case "/controller/login":
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
			break;
			
		case "/controller/employee/submit-request":
			switch (req.getMethod()) {
			case "GET":
				res.setStatus(400);
				res.getWriter().write("Method Not Supported");
				break;
			case "POST":
				empController.submitReimbRequest(req, res);
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
			break;
			
		case "/controller/employee/view-requests":
			switch (req.getMethod()) {
			case "GET":
				res.setStatus(400);
				res.getWriter().write("Method Not Supported");
				break;
			case "POST":
				empController.viewAllRequests(req, res);
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
			break;
			
		case "/controller/manager/view-pending-requests":
			switch (req.getMethod()) {
			case "GET":
				res.setStatus(400);
				res.getWriter().write("Method Not Supported");
				break;
			case "POST":
				manController.viewAllReimbs(req, res);
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
			break;
			
		case "/controller/manager/approve-request":
			switch (req.getMethod()) {
			case "GET":
				res.setStatus(400);
				res.getWriter().write("Method Not Supported");
				break;
			case "POST":
				manController.approveReimbRequest(req, res);
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
			break;
			
		case "/controller/manager/deny-request":
			switch (req.getMethod()) {
			case "GET":
				res.setStatus(400);
				res.getWriter().write("Method Not Supported");
				break;
			case "POST":
				manController.denyReimbRequest(req, res);
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
			break;
			
		case "/controller/manager/view-all-requests":
			switch (req.getMethod()) {
			case "GET":
				res.setStatus(400);
				res.getWriter().write("Method Not Supported");
				break;
			case "POST":
				manController.viewAllReimbs(req, res);
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
			break;

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
