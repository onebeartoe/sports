
package org.onebeartoe.sports.scoreboard.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.onebeartoe.sports.scoreboard.frame.buffer.display.ScoreboardApp;

/**
 *
 * @author Roberto Marquez
 */
@WebServlet(name = "NewGameServlet", urlPatterns = {"/game/new"})
public class NewGameServlet extends HttpServlet 
{    
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
            throws ServletException, IOException 
    {
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        
        String DEFAULT_PAGE = "/game/new/index.jsp";
        RequestDispatcher rd = servletContext.getRequestDispatcher(DEFAULT_PAGE);
        rd.forward(request, response);
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
            throws ServletException, IOException 
    {
        String length = request.getParameter("periodLength");
        int minutes = Integer.valueOf(length);
        Duration periodLength = Duration.ofMinutes(minutes);
        
        String periods = request.getParameter("periods");
        int periodCount = Integer.valueOf(periods);
        
        ScoreboardApp.newGame(periodCount, periodLength);
        
        request.setAttribute("newGame", "A new Game was created.");
        
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() 
    {
        return "This servlet creates a new game for the scoreboard to manage.";
    }
}