package observer.fx;

import java.util.Arrays;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainClass extends Application{
	
	ArrayList<String> colores = new ArrayList<String>(Arrays.asList("#55ff55","#aa00aa","#005d63","#ffaa00 ","#55ffff"));
	ArrayList<String> nombrecolores= new ArrayList<String>(Arrays.asList("Verde","Dark Purple","Turquesa","Gold","Aqua"));
	public static ColorsStorage station;
	public static String colorNuevoBoton;
	
	public static void main(String[] args) {
        launch(args);
    }
		
	@Override
    public void start(Stage primaryStage) {
    	
    	station = new ColorsStorage();         
       
        VBox hb=new VBox();
        VBox hb2=new VBox();        
        
        Button nuevoBoton=new Button("Nuevo Color");
        nuevoBoton.setPrefWidth(200);
        
        cambiarColorNuevo(nuevoBoton,hb);
        
        for (ColorButton c:station.getBotones()){
            hb.getChildren().add(c.getBtn());
            	
            }
        
        
        hb2.getChildren().add(nuevoBoton);
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb2.setSpacing(5);
        hb2.setAlignment(Pos.BOTTOM_CENTER);
        hb2.setPadding(new Insets(0,0,10,0));
        
        station.getRoot().add(hb,0,1);
        station.getRoot().add(hb2,0,0);
        station.getRoot().setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(station.getRoot(), 500, 500);
        
        primaryStage.setTitle("Cambio de color de la ventana");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }   
    
    public void cambiarColorNuevo(final Button bt,final VBox hb) {
    	
    	bt.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
            	nuevoBoton(bt,hb);
            }
        });
    }
    
    public void nuevoBoton(Button bt,VBox hb) {
    	String color = nombrecolores.get(nombrecolores.size()-1);
    	String colorCode = colores.get(colores.size()-1);
    	colorNuevoBoton=color;
    	
    	ColorButton nuevof=new ColorButton(color,"-fx-background-color: "+colorCode,station);
    	hb.getChildren().add(nuevof.getBtn());
    	nombrecolores.remove(nombrecolores.size()-1);
    	colores.remove(colores.size()-1);
    	
    	if (nombrecolores.size()==0) {
    		bt.setDisable(true);
    	}
    }
}



