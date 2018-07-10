package com.pd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pd.beans.DTO;
import com.pd.beans.VO;
import com.pd.service.PlayerService;
import com.pd.service.PlayerServiceImpl;

/**
 * Servlet implementation class PlayerController
 */
@WebServlet("/PlayerController")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String esal=request.getParameter("esal");
		
		VO obj=new VO();
		obj.setEid(eid);
		obj.setEname(ename);
		obj.setEsal(esal);
		
		DTO obj1=new DTO();
		obj1.setEid(Integer.parseInt(obj.getEid()));
		obj1.setEname(obj.getEname());
		
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		PlayerService obj2=new PlayerServiceImpl();
		try {
			int count=obj2.insert(obj1);
			
			if(count==1){
				rd=request.getRequestDispatcher("/success.jsp");
				rd.forward(request, response);
				return;
			}
			else
				out.println("failed");
		} catch (Exception e) {
			out.print("try again");
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
