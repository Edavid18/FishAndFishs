/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.scene.control.Label;


/**
 *
 * @author eliasvidal
 */
public class TimeThread extends Thread{
    private Label timeLabel;
    LocalTime time;
    
    public TimeThread(Label time){
        this.timeLabel = time;
    }
    
    @Override
    public void run(){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            while(true){
                time = LocalTime.now();
                Platform.runLater(() -> timeLabel.setText(String.valueOf(time.format(formatter))));
                Thread.sleep(1000);
            }
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
