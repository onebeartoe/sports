
package org.onebeartoe.sports.scoreboard.webapp;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;

//remove this endpoint
//@ServerEndpoint("/current/game")
/**
 *
 * @author Roberto Marquez
 */
@WebServlet(urlPatterns = {"/current/game/"}, loadOnStartup = 1)
public class CurrentGameServlet extends HttpServlet
{
    private Logger logger;
    
    public static final String SCOREBOARD_KEY = "SCOREBOARD_KEY";

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
        
        String DEFAULT_PAGE = "/current/game/index.jsp";
        RequestDispatcher rd = servletContext.getRequestDispatcher(DEFAULT_PAGE);
        rd.forward(request, response);
    }
    
    @Override
    public void init()
    {
        logger = Logger.getLogger(getClass().getName());
    }
}
