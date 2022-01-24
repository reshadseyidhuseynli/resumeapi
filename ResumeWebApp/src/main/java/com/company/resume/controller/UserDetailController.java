package com.mycompany.resume.controller;

import com.company.entity.User;
import com.company.inter.UserDAOInter;
import com.company.resume.util.ControllerUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mycompany.main.Context;

@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    private UserDAOInter dao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        int id = Integer.valueOf(request.getParameter("id"));

        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String profileDescription = request.getParameter("profile description");
            String address = request.getParameter("address");

            User u = dao.getUserByID(id);
            u.setName(name);
            u.setSurname(surname);
            u.setEmail(email);
            u.setPhone(phone);
            u.setProfileDescription(profileDescription);
            u.setAddress(address);

            dao.update(u);

        } else if (action.equals("delete")) {
            dao.delete(id);
        }

        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String idStr = request.getParameter("id");
            if (idStr == null || idStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Specify ID");
            } else {
                Integer id = Integer.parseInt(idStr);
                User u = dao.getUserByID(id);
                if (u == null) {
                    throw new IllegalArgumentException("There is not user with this id");
                } else {
                    request.setAttribute("user", u);
                    request.getRequestDispatcher("view/userdetail.jsp").forward(request, response);
                }
            }
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }

    }
}
