package co.com.educame.modelo.entidades.interfaces;

import java.util.List;

import org.json.JSONArray;

import android.util.JsonReader;

import co.com.educame.modelo.entidades.InstitucionEducacionSuperior;

public interface IFactoryInstitucionEducacionSuperior {
	
	List<InstitucionEducacionSuperior> getInstitucionesEducacionSuperior();
	void createInstitucionesEducacionSuperior(JSONArray arreglo, String[] propertyNames);
	

}
