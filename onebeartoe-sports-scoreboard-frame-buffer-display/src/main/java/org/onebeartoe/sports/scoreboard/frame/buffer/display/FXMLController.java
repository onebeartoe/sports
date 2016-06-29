package org.onebeartoe.sports.scoreboard.frame.buffer.display;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * The scoreboard was inspired by this image: 
 * 
 *  http://www.electro-mech.com/colorpicker_image.php?model=lx2340&primary=navy_blue&leds=amber&caption=white&accent=white
 * 
 * @author Roberto Marquez
 */
public class FXMLController implements Initializable 
{   
    @FXML
    private Label clockSecondsLabel;
    
    @FXML
    private Label homeScoreLabel;
    
    @FXML
    private Label homeLabel;
    
    @FXML
    private Label awayScoreLabel;
    
    @FXML
    private Label currentPeriodLabel;
    
    private Timer timer;
    
    private TimerTask clickTask;
    
    @FXML
    private Label clockMinutesLabel;
    
    private IntegerProperty awayScore;
    
    private IntegerProperty homeScore;    
    
    private long startTime;
    
    private long stopTime = -1;
    
    private Duration clock;
    
    private Duration periodLength = Duration.ofMinutes(2);
    
    private int periodCount;
    
    private int currentPeriod;

    public int adjustAwayScore(int delta)
    {
        int sum = awayScore.get() + delta;
        
        Platform.runLater( () -> 
        {
            awayScore.set(sum);
        });

        return awayScore.getValue();
    }

    public int adjustHomeScore(int delta)
    {
        int sum = homeScore.get() + delta;
        
        Platform.runLater( () -> 
        {
            homeScore.set(sum);
        });
        
        return homeScore.getValue();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Font font = fourteenSegementFont();
        Background bg = new Background( new BackgroundFill(Color.BLACK, null, null) );
        
        clockSecondsLabel.setFont(font);
        clockSecondsLabel.setTextFill(Color.YELLOW);

        awayScore = new SimpleIntegerProperty(0);
        homeScore = new SimpleIntegerProperty(0);
        
        clockMinutesLabel.setFont(font);
        clockMinutesLabel.setTextFill(Color.YELLOW);
        
        homeScoreLabel.setFont(font);
        homeScoreLabel.setTextFill(Color.RED);
        homeScoreLabel.setBackground(bg);
        
        awayScoreLabel.setFont(font);
        awayScoreLabel.setTextFill(Color.RED);
        awayScoreLabel.setBackground(bg);
        
        awayScoreLabel.textProperty().bind( awayScore.asString() );
        homeScoreLabel.textProperty().bind( homeScore.asString() );        
        
        
        clock = Duration.ofMillis( periodLength.toMillis() );
        
        currentPeriod = 1;
        
        timer = new Timer();
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
        
        Font font = Font.loadFont(instream, 70);
        
        return font;
    }

    public void newGame(int periodCount, Duration periodLength)
    {
        stopClock();
        
        this.periodCount = periodCount;
        this.periodLength = periodLength;
        
        currentPeriod = 0;
        
        clock = Duration.ofMillis( periodLength.toMillis() );
        
        stopTime = -1;
        
        Platform.runLater( 
            () -> 
            {
                awayScore.setValue(0);
                homeScore.setValue(0);
                
                String minutesText = String.valueOf( periodLength.toMinutes() );
                clockMinutesLabel.setText(minutesText);
                clockSecondsLabel.setText("00");
                
                currentPeriodLabel.setText("0");
            }
        );
    }
    
    public void resetGame()
    {
        newGame(1, this.periodLength);
    }    
    
    public long startClock()
    {
        Date firstTime = new Date();
        clickTask = new ClockTask();
        
        final long period = Duration.ofSeconds(1).toMillis();
        startTime = firstTime.getTime();
        
        if(stopTime == -1)
        {
            // this is the first time the clock is started
            stopTime = startTime;
        }
        
        timer.schedule(clickTask, firstTime, period);

        return clock.toMillis();
    }
    
    public long stopClock()
    {
        stopTime = Calendar.getInstance().getTimeInMillis();
        
        if(clickTask != null)
        {
            clickTask.cancel();
        }
        
        return clock.toMillis();
    }
    
    public void stopThreads()
    {
        timer.cancel();
    }
    
    private class ClockTask extends TimerTask
    {
        URL buzzerUrl;
        
        public AudioClip whammySound;
        
        public ClockTask()
        {
            String path = "/whammy.wav";
            buzzerUrl = getClass().getResource(path);
            whammySound = Applet.newAudioClip(buzzerUrl);
        }
        
        @Override
        public void run()
        {
            clock = clock.minus( Duration.ofSeconds(1) );
            long currentClockTime = clock.toMillis();

            int sec = (int) ((currentClockTime / 1000) % 60);
            int min = (int) ((currentClockTime / 1000) / 60);

            Platform.runLater(() -> 
            {
                String minutesLabel = String.format("%02d", min);
                clockSecondsLabel.setText(minutesLabel);
                
                String secondsLabel = String.format("%02d", sec);                
                clockSecondsLabel.setText(secondsLabel);
                
                if(clock.toMillis() <= 0)
                {
                    // the period is over
                    
                    cancel();                    
                    
                    playBuzzer();

                    currentPeriod++;
                    
                    if(currentPeriod >= periodCount)
                    {
                        // end of the game
                    }
                    else
                    {
                        currentPeriodLabel.setText( String.valueOf(currentPeriod) );
                    }
                }
            });
        }
        
        private void playBuzzer()
        {
            whammySound.play();
        }
    }    
}