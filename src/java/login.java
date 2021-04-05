/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stane
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        TODO: Sesija, Cookies ?

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("username").toLowerCase();
        String pw = request.getParameter("password");
        String dbu = "Mekere".toLowerCase();
//        session get att db id  || session get att novi id ?
        String dbpw = "1337";
        int id = 0;

        if (uname.toLowerCase().equals(dbu) && pw.equals(dbpw)) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 5);
            session.setAttribute("username", uname);
//            session.setAttribute("id", id++);
            response.sendRedirect("/index/home.html");

//           response.sendRedirect("https://www.youtube.com");
//            out.println(
//                    "<!DOCTYPE html>"
//                    + "<html>"
//                    + "<body>"
//                    + "<h1>"
//                    + "<b>Successful Login</b>"
//                    + "</h1>"
//                    + "</body>"
//                    + "</html>"
//            );
        } else {
            request.getRequestDispatcher("login.html").include(request, response);
            out.println(
                    "<!DOCTYPE html>"
                    + "<html>"
                    + "<body>"
                    + "<h1>"
                    + "<b>Username/Password is incorrect</b>"
                    + "</h1>"
                    + "<a href='login.html'> Try again </a>"
                    + "</body>"
                    + "</html>"
            );
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
