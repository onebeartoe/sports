
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
@WebServlet(urlPatterns = {"/game/away/*", "/game/home/*"})
public class GameScoreServlet extends HttpServlet
{
    private Logger logger;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String servletPath = request.getServletPath();
        
        String pi = request.getPathInfo();
        String operation = pi.substring(1);
        
        String r = getResponse(servletPath, operation);
        
        ServletOutputStream outputStream = response.getOutputStream();
        try (PrintWriter pw = new PrintWriter(outputStream)) 
        {
            pw.write(r);
            pw.flush();
        }
    }

    private int getOperation(String operation)
    {
        int op;
        
        switch (operation)
        {
            case "increment":
            {
                op = +1;
                
                break;
            }
            case "decrement":
            {
                op = -1;
                
                break;
            }
            default:
            {
                op = 0;
                
                logger.log(Level.WARNING, "The score servlet could not determine between incrementing or decremeting the score.");
            }
        }

        return op;
    }
    
    private String getResponse(String servletPath, String operation)
    {
        int op = getOperation(operation);
        
        String response = "-1";
        
        switch (servletPath)
        {
            case "/game/home":
            {
                int r = ScoreboardApp.adjustHomeScore(op);
                response = String.valueOf(r);
                
                break;
            }
            case "/game/away":
            {
                int r = ScoreboardApp.adjustAwayScore(op);
                
                response = String.valueOf(r);
                
                break;
            }
            default:
            {
                logger.log(Level.WARNING, "The score servlet could not determine between home and away teams.");
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
