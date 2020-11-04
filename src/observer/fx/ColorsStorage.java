package observer.fx;

import java.util.ArrayList;
import javafx.scene.layout.GridPane;



public class ColorsStorage {
	private GridPane root;	
	private static String colorActual;
	private ArrayList<ColorButton> botones;
	
	
	
    
    public ColorsStorage(){
    	this.root = new GridPane();
    	this.botones=new ArrayList<ColorButton>();
        
    	    	
    	this.botones.add(new ColorButton("Amarillo","-fx-background-color: #ffff55",this));
    	this.botones.add(new ColorButton("Azul","-fx-background-color: #293492",this));
    	this.botones.add(new ColorButton("Rojo","-fx-background-color: #a00000",this));
    	
           	
    	
    }
    

    
    public GridPane getRoot() {
    	return this.root;
    }
    
       
    public static String getcolorActual() {
    	return ColorsStorage.colorActual;
    }
    
    public static void setcolorActual(String colorActual) {
    	ColorsStorage.colorActual=colorActual;
    }
    
    public ArrayList<ColorButton> getBotones(){
    	return this.botones;
    }
    
   
}
