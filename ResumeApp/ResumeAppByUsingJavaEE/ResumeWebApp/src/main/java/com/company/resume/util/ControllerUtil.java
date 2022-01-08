package com.company.resume.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class ControllerUtil {

    public static void errorPage(HttpServletResponse response, Exception ex) {
        try {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
