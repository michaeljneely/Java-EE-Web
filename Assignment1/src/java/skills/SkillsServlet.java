/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skills;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
@WebServlet(name = "SkillsServlet", urlPatterns = {"/SkillsServlet"})
public class SkillsServlet extends HttpServlet {

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
            
            //Arrays For Cookie Loop
            String[] languages = {"C", "Java", "PHP", "SQL", "C#", "JavaScript"};
            String[] checks = {"c-check", "j-check", "p-check", "sql-check", "csharp-check", "js-check"};
            String[] skill = {"c-skill", "j-skill", "p-skill", "sql-skill", "csharp-skill", "js-skill"};
            
            //For Each Language
            for(int i = 0; i < languages.length; i++){
                //If Check Box Value Not Null
                if(request.getParameter(checks[i]) != null){
                    //If Checkbox is Checked
                    if(request.getParameter(checks[i]).equals("yes")){
                        //Set new cookie with that language and its specified skill level
                        Cookie c = new Cookie(languages[i], request.getParameter(skill[i]));
                        c.setMaxAge(60*60*24*365);
                        response.addCookie(c);
                    }
                } 
            }
            //Forward on to next page
            RequestDispatcher next = request.getRequestDispatcher("select.html");
            next.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
