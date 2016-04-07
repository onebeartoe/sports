package org.onebeartoe.sports.scoreboard.frame.buffer.display;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * The scoreboard was inspired by this image: http://www.electro-mech.com/colorpicker_image.php?model=lx2340&primary=navy_blue&leds=amber&caption=white&accent=white
 * 
 * @author Roberto Marquez
 */
public class FXMLController implements Initializable 
{   
    @FXML
    private Label clockLabel;
    
    @FXML
    private Label homeScoreLabel;
    
    @FXML
    private Label homeLabel;
    
    @FXML
    private Label awayScoreLabel;
    
    private Timer timer;
    
    private TimerTask clickTask;
    
    private int clockValue = 60;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Font font = fourteenSegementFont();
        Background bg = new Background( new BackgroundFill(Color.BLACK, null, null) );
        
        clockLabel.setFont(font);
        clockLabel.setTextFill(Color.YELLOW);
        clockLabel.setBackground(bg);
        
        homeScoreLabel.setFont(font);
        homeScoreLabel.setTextFill(Color.RED);
        homeScoreLabel.setBackground(bg);
        
        awayScoreLabel.setFont(font);
        awayScoreLabel.setTextFill(Color.RED);
        awayScoreLabel.setBackground(bg);
        
        Date firstTime = new Date();
        clickTask = new ClockTask();

        timer = new Timer();
        
        final long period = Duration.ofSeconds(1).toMillis();
        
        timer.schedule(clickTask, firstTime, period);
    }

    /**
     * The resource used for setting the font in Javafx text componants: http://docs.oracle.com/javafx/2/text/jfxpub-text.htm
     * The custom 14 segment font from: https://fontlibrary.org/en/font/segment14
     * The 14 segment was referenced from: http://graphicdesign.stackexchange.com/questions/15571/where-can-i-find-a-font-with-numbers-letters-and-symbols-to-use-in-a-design-of
     * 
     * @return a font that looks like a 14 segment display
     */    
    private Font fourteenSegementFont()
    {
        String fontName = "Segment14.otf";
        String fontClasspath = "/" + fontName;
        InputStream instream = getClass().getResourceAsStream(fontClasspath);
        
        Font font = Font.loadFont(instream, 40);
        
        return font;
    }
    
    public void stopThreads()
    {
        timer.cancel();
    }
    
    private class ClockTask extends TimerTask
    {
        @Override
        public void run()
        {                
            clockValue--;
            
            if(clockValue < 0)
            {
                clockValue = 100;
            }
            
            Platform.runLater( new Runnable()
            {
                @Override
                public void run()
                {
                    String clock = "1(" + clockValue;
                    clockLabel.setText(clock);
                }
            } );
        }
    }    
}