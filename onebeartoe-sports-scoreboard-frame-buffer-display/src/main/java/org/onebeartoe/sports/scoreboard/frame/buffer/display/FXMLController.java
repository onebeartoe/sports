package org.onebeartoe.sports.scoreboard.frame.buffer.display;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import jfxtras.labs.scene.control.gauge.GaugeModel;
import jfxtras.labs.scene.control.gauge.Lcd;

public class FXMLController implements Initializable 
{    
    @FXML
    private Label label;
    
    @FXML
    private BorderPane borderPane;
    
    private Lcd lcd;
    
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        
        GaugeModel gm = new GaugeModel();
        gm.setLcdValue(10.5);
        gm.setLastLabelVisible(true);
        gm.setValue(2.3);
        gm.setTitle("some tiel");
//        lcd.setGaugeModel(gm);
//        lcd.setLcdDesign(LcdDesign.BEIGE);
//        lcd.setPrefWidth(200);
//        lcd.setPrefHeight(85);

//        Platform.runLater( new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                Lcd lcd = LcdBuilder.create()
//                .value(3.4)
//                .title("some tile")
//                .build();
//
//                borderPane.setBottom(lcd);
//            }
//        });

        // resource for setting the font in Javafx text componants: http://docs.oracle.com/javafx/2/text/jfxpub-text.htm
        // custom 14 segment font from: https://fontlibrary.org/en/font/segment14
        // the 14 segment was referenced here: http://graphicdesign.stackexchange.com/questions/15571/where-can-i-find-a-font-with-numbers-letters-and-symbols-to-use-in-a-design-of
        String fontName = "Segment14.otf";
        String fontClasspath = "/" + fontName;
        InputStream instream = getClass().getResourceAsStream(fontClasspath);
        
        Font font = Font.loadFont(instream, 20);

        Text text =  new Text("hi - 22 - 24");
        text.setFont(font);
        text.setFill(Color.RED);
        borderPane.setBottom(text);
    }    
}
