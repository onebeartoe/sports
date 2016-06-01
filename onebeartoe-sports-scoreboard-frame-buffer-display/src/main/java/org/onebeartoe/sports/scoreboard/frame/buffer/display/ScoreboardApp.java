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