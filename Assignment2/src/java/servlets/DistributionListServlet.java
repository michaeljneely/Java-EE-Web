package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michael Neely - 13100590
 */
@WebServlet(name = "DistributionListServlet", urlPatterns = {"/DistributionListServlet"})
public class DistributionListServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        //Try and get distribution list
        ArrayList<String> dl = (ArrayList<String>)session.getAttribute("distributionList");
        //If null -> set up the distribution list. respond with 'list is empty', forward to index.jsp
        if(dl == null){
            session.setAttribute("distributionList", new ArrayList<String>());
            session.setAttribute("message", "The list is empty");
            RequestDispatcher back = request.getRequestDispatcher("index.jsp");
            back.forward(request, response);
        }
        //If empty respond with 'list is empty', forward to index.jsp
        else if(dl.isEmpty()){
            session.setAttribute("message", "The list is empty");
            RequestDispatcher back = request.getRequestDispatcher("index.jsp");
            back.forward(request, response);
        }
        //Otherwise, forward to displayList.jsp
        else {
            session.setAttribute("message", null);
            RequestDispatcher display = request.getRequestDispatcher("displayList.jsp");
            display.forward(request, response);
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