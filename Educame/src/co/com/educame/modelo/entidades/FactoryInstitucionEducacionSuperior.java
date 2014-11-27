package co.com.educame.modelo.entidades;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import co.com.educame.modelo.entidades.interfaces.IFactoryInstitucionEducacionSuperior;

public class FactoryInstitucionEducacionSuperior implements
		IFactoryInstitucionEducacionSuperior {

	private List<InstitucionEducacionSuperior> listaInstituciones;
	private static FactoryInstitucionEducacionSuperior instance;

	private FactoryInstitucionEducacionSuperior() {

	}

	public static FactoryInstitucionEducacionSuperior getInstance() {
		if (instance == null)
			instance = new FactoryInstitucionEducacionSuperior();

		return instance;
	}

	@Override
	public List<InstitucionEducacionSuperior> getInstitucionesEducacionSuperior() {
		// TODO Auto-generated method stub
		return listaInstituciones;
	}

	@Override
	public void createInstitucionesEducacionSuperior(JSONArray arreglo,
			String[] propertyNames) {
		JSONObject object;
		InstitucionEducacionSuperior institucionEducacionSuperior;
		listaInstituciones = new ArrayList<InstitucionEducacionSuperior>();

		try {
			for (int i = 0; i < arreglo.length(); i++) {
				int j=0;
				object = arreglo.getJSONObject(i);

				institucionEducacionSuperior = new InstitucionEducacionSuperior();
				
				institucionEducacionSuperior.setCodigoInstitucion(Integer
						.parseInt(object
								.getString(propertyNames[j])));
				j++;
				
				institucionEducacionSuperior.setNombreInstitucion(object
						.getString(propertyNames[j]));
				
				listaInstituciones.add(institucionEducacionSuperior);
				

			}
		} catch (Exception e) {

		}

	}

}
