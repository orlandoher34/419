package servlet;

import beans.CustomerCatalog;
import controller.CustomerCatalogBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {

   private static final long serialVersionUID = 1L;
	
	public CustomerController(){
		super();
	}
	List<CustomerCatalog> result = null;
	
	public List<CustomerCatalog> getResult() {
		return result;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strAction = request.getParameter("action");
                PrintWriter out = response.getWriter();
                
                
		if (strAction != null && !strAction.equals("")) {
			if (strAction.equals("getaccount")) {
                                
				CustomerCatalog inputCredentials = getAccount(request);
                                CustomerCatalog credentialsFromMap = CustomerCatalogBean.
                                        getUserID(inputCredentials.getUserID());
                                if(credentialsFromMap != null){
                                    if(inputCredentials.compare(credentialsFromMap)){
                                        HttpSession session = request.getSession();
                                        session.setAttribute("userID", inputCredentials.getUserID());
                                        String position = credentialsFromMap.getPosition();
                                        if(position.equals("manager")){
                                            response.sendRedirect("../Managerportal.jsp");
                                        }else if(position.equals("customer")){
                                            response.sendRedirect("../Customerportal.jsp");
                                        }else if(position.equals("account")){
                                            response.sendRedirect("../Accountportal.jsp");
                                    }else if(position.equals("technical")){
                                            response.sendRedirect("../Technicalportal.jsp");
                                }
								}
                            }								
			}
		}
                out.println("<b>Whoops! Your username/password does not match our records. Please contact the help desk at 1-888-123-1234 to reset your account.</b>");	
	}
	
protected CustomerCatalog getAccount(HttpServletRequest request) {
            String strItemID = request.getParameter("userID");
            String strPassword = request.getParameter("password");
            String position = request.getParameter("position");
            return new CustomerCatalog(strItemID, strPassword, position);
        }

}