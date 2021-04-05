/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stane
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
            out.println("<title>Servlet register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("username").trim();
        String pw = request.getParameter("password");
        /*
        treba proveriti da li korisnik vec postoji, vratiti ga na pocetak
        ako postoji, a ako ne postoji uneti novog korisnika u db
         */
        if (!uname.isEmpty() && !pw.isEmpty()) {
//  TODO:  treba napraviti proveru za null, specijalne karaktere i broj karaktera(prekoracenje)
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 5);
            session.setAttribute("username", uname);
//            session.setAttribute("id", id++);
            response.sendRedirect("home.html");
            out.println(
                    "<!DOCTYPE html>"
                    + "<head>"
                    + "<meta charset = 'UTF-8'>"
                    + "<link href = 'style.css' rel = 'stylesheet'>"
                    + "</head>"
                    + "<html>"
                    + "<body>"
                    + "<h1>"
                    + "<b>You have successfully registered!</b><br>"
                    + "Welcome <b>" + uname
                    + "</b></h1>"
                    + "</body>"
                    + "</html>"
            );
//  TODO: Proslediti korisnika na home stranicu
        } else {
            request.getRequestDispatcher("register.html").include(request, response);

            out.println(
                    "<b>Make sure you havent used any special characters in your username</b>");
//                    "<!DOCTYPE html>"
//                    + "<html>"
//                    + "<body>"
//                    + "<h1>"
//                    + "<b>Username/Make sure you havent used any special characters in your username</b>"
//                    + "</h1>"
//                    + "<a href='register.html'> Try again </a>"
//                    + "</body>"
//                    + "</html>"
//            );
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
