package mainresources.com.mycompany.resume.controller;

import com.company.entity.User;
import com.company.inter.UserDAOInter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mycompany.main.Context;

@WebServlet(name = "UserInfoController", urlPatterns = {"/userinfo"})
public class UserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        UserDAOInter dao = Context.instanceUserDao();
        User u = dao.getUserByID(id);
        request.setAttribute("user", u);
        request.getRequestDispatcher("view/userinfo.jsp").forward(request, response);
    }

}
