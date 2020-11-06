package Aspecto;

import observer.fx.mainClass;
import observer.fx.ColorsStorage;
import observer.fx.Observador;


public aspect Notification implements Observador{

	
	pointcut cambio(): call(* setStyle*(..));

	after(): cambio(){
			
		update();	
	}

	pointcut nuevo(): call(* nuevoBoton*(..));

	after(): nuevo(){
		
		
		System.out.println("Se ha agregado un nuevo boton de color: "+ mainClass.colorNuevoBoton);
			
	}
	
	public void update() {
		System.out.println("Se ha cambiado el color de la ventana a:"+ColorsStorage.getcolorActual());
	}
}