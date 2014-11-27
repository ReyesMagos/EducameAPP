package co.com.educame.controladores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.com.educame.R;
import co.com.educame.modelo.entidades.FactoryInstitucionEducacionSuperior;
import co.com.educame.servicios.GetRestServices;

import android.app.Activity;

public class MainController extends AbstractController {

	public MainController(Activity activity) {
		super(activity);

	}

	public void getRestFulServices() {
		showProgressDialog("alerta", "Llendo por los datos");
		String url = "http://servicedatosabiertoscolombia.cloudapp.net/v1/Ministerio_de_educacion_nacional/ies?$format=json";
		GetRestServices getRestService = new GetRestServices(this);
		getRestService.execute(url);
	}

	public void processRestFulResponse(JSONObject respJSON) {
		JSONArray arregloJSON;
		String[] properties = getActivity().getResources().getStringArray(
				R.array.ies_properties_names);
		try {
			arregloJSON = respJSON.getJSONArray("d");
			FactoryInstitucionEducacionSuperior.getInstance()
					.createInstitucionesEducacionSuperior(arregloJSON,
							properties);
			dismissProgressDialog();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
