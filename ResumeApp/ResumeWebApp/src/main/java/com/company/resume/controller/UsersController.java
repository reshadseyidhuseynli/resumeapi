package com.company.resume.controller;

import mycompany.main.Context;
import com.company.entity.User;
import com.company.inter.UserDAOInter;
import com.company.resume.util.ControllerUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {

    private UserDAOInter dao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            List<User> list = dao.searchingUsers(name, surname);

            if (list.isEmpty()) {
                throw new IllegalArgumentException("There is not user with this name/surname");
            } else {
                request.setAttribute("list", list);
                request.getRequestDispatcher("view/users.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }
    }
}
