
package org.onebeartoe.sports.scoreboard.webapp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.onebeartoe.chronos.digital.clock.DigitalClock;

/**
 * @author Roberto Marquez
 */
@WebServlet(urlPatterns = {"/frame-buffer-screen"})
public class ScoreboardFrameBufferServlet extends HttpServlet
{
    private Logger logger;
    
//    private DigitalClock clock;
    
    @Override
    public void init() throws ServletException 
    {
        super.init();
        
        logger = Logger.getLogger( getClass().getName() );
   
        logger.log(Level.INFO, "loading clock yay!");
//        clock = new DigitalClock();
        Application.launch(DigitalClock.class);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        request.setAttribute("att-key", "sring-value");
                
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
