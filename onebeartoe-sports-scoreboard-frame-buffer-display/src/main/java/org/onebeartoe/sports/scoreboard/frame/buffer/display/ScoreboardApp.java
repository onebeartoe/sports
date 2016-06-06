package org.onebeartoe.sports.scoreboard.frame.buffer.display;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class ScoreboardApp extends Application 
{
    private static int period;
    
    private static int awayScore;
    
    private static int homeScore;
    
    public static int adjustAwayScore(int delta)
    {
        awayScore += delta;
        
        return awayScore;
    }
    
    public static int adjustHomeScore(int delta)
    {
        homeScore += delta;
        
        return homeScore;
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
    
    private static void resetGame()
    {
        awayScore = 0;
        
        homeScore = 0;
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Diego's Basketball Scoreboard");
        stage.setScene(scene);
        stage.show();
    }
}