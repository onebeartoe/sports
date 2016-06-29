
package org.onebeartoe.sports.scoreboard.frame.buffer.display;

import java.net.URL;
import java.time.Duration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class ScoreboardApp extends Application 
{
    private static int period;
    
    private FXMLLoader loader;
    
    private static FXMLController controller;
    
    public static int adjustAwayScore(int delta)
    {
        int updatedValue = controller.adjustAwayScore(delta);
        
        return updatedValue;
    }
    
    public static int adjustHomeScore(int delta)
    {
        int updatedValue = controller.adjustHomeScore(delta);
        
        return updatedValue;
    }
    
    public static String getDescription()
    {
        return "some scoreboard description";
    }

    public static int getPeriod()
    {
        return period;
    }
    
    @Override
    public void init()
    {
        period = 2;
        
        resetGame();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    public static void newGame(int periodCount, Duration periodLenth)
    {
        if(controller == null)
        {
            System.out.println("The controller is null.  A new game cannot be made with a null controller");
        }
        else
        {
            controller.newGame(periodCount, periodLenth);            
        }
    }
    
    private static void resetGame()
    {
        if(controller == null)
        {
            System.out.println("The controller is null, not going to reset game.");
        }
        else
        {
            controller.resetGame();
        }
    }
    
    public static void shutdown()
    {
        controller.stopThreads();
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        URL url = getClass().getResource("/fxml/Scene.fxml");
        
        loader = new FXMLLoader(url);
        
        Parent root = loader.load();

        controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Diego's Basketball Scoreboard");
        stage.setScene(scene);
        stage.show();
    }
    
    public static long startClock()
    {
        long time = controller.startClock();
        
        return time;
    }
    
    public static long stopClock()
    {
        long time = controller.stopClock();
        
        return time;
    }
}