package co.com.educame.modelo.entidades;

import java.util.List;

import org.json.JSONArray;

import co.com.educame.modelo.entidades.interfaces.IFactoryInstitucionEducacionSuperior;

public class FactoryInstitucionEducacionSuperior implements IFactoryInstitucionEducacionSuperior {

	
	
	private static  FactoryInstitucionEducacionSuperior instance;
	
	private FactoryInstitucionEducacionSuperior(){
		
	}
	
	public static FactoryInstitucionEducacionSuperior getInstance(){
		if(instance==null)
			instance= new FactoryInstitucionEducacionSuperior();
		
		return instance;
	}
	
	@Override
	public List<InstitucionEducacionSuperior> getInstitucionesEducacionSuperior() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createInstitucionesEducacionSuperior(JSONArray arreglo,
			String[] propertyNames) {
		// TODO Auto-generated method stub
		
	}

}
