
package org.onebeartoe.sports.scoreboard.webapp;

import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Roberto Marquez
 */
@WebServlet(urlPatterns = {"/game/current"}, loadOnStartup = 1)
public class CurrentGameServlet extends HttpServlet
{
    private Logger logger;
    
    public static final String SCOREBOARD_KEY = "SCOREBOARD_KEY";
    
    @Override
    public void init()
    {
        logger = Logger.getLogger(getClass().getName());
    
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        
        Object attribute = servletContext.getAttribute(SCOREBOARD_KEY);
        Scoreboard
        if(attribute == null)
            
        
        servletContext.setAttribute(LIZARD_ENCLOSURE_ID, enclosure);
    }
}
