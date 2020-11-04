package Aspecto;

import observer.fx.mainClass;
import observer.fx.ColorsStorage;


public aspect Notification {

	
	pointcut cambio(): call(* setStyle*(..));

	after(): cambio(){
		
		
		System.out.println("Se ha cambiado el color de la ventana a:"+ColorsStorage.getcolorActual());
			
	}

	pointcut nuevo(): call(* nuevoBoton*(..));

	after(): nuevo(){
		
		
		System.out.println("Se ha agregado un nuevo boton de color: "+ mainClass.colorNuevoBoton);
			
	}
	
	
}