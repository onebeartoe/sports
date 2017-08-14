
package org.onebeartoe.sports.scoreboard.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.onebeartoe.sports.scoreboard.frame.buffer.display.ScoreboardApp;

/**
 *
 * @author Roberto Marquez
 */
@WebServlet(urlPatterns = {"/game/clock/*"})
public class GameClockStartStopServlet extends HttpServlet
{
    private Logger logger;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
//        String servletPath = request.getServletPath();
        
        String pi = request.getPathInfo();
        String operation = pi.substring(1);
        
        String r = getResponse(
//                servletPath, 
                operation);
        
        ServletOutputStream outputStream = response.getOutputStream();
  //      try (
                PrintWriter pw = new PrintWriter(outputStream);
//                ) 
//        {
            pw.write(r);
            pw.flush();
  //      }
    }    

    private String getResponse(
//            String servletPath, 
            String operation)
    {
//        int op = getOperation(operation);
        
        String response = "-1";
        
        switch (operation)
        {
            case "start":
            {
                long r = ScoreboardApp.startClock();
                response = String.valueOf(r);
                
                break;
            }
            case "stop":
            {
                long r = ScoreboardApp.stopClock();
                
                response = String.valueOf(r);
                
                break;
            }
            default:
            {
                logger.log(Level.WARNING, "The game clock servlet could not determine between start and stop states: " + operation);
            }
        }

        return response;        
    }    
    
    @Override
    public void init() throws ServletException 
    {
        logger = Logger.getLogger(getClass().getName());
    }    
}
