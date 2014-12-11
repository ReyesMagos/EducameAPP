package co.com.educame.servicios;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import co.com.educame.controladores.AbstractController;
import co.com.educame.controladores.MainController;

public class GetRestServices extends AsyncTask<String, String, String> {

	private AbstractController controller;

	public GetRestServices(AbstractController controller) {
		this.controller = controller;
	}

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub

		// http://goo.gl/GdjxX2

		String url = params[0];
		HttpClient cliente = new DefaultHttpClient();
		HttpGet del = new HttpGet(url);

		String stringResp;
		try {

			HttpResponse resp = cliente.execute(del);
			HttpEntity entity = resp.getEntity();
			stringResp = EntityUtils.toString(entity);
			JSONObject respJSON = new JSONObject(stringResp);
			
			if(controller instanceof MainController){
				MainController mainController = (MainController) controller;
				mainController.processRestFulResponse(respJSON);
				
			}

		} catch (Exception e) {
			Log.i("Erro", e.getMessage());
			// return TAG_RESPONSE_ERROR;

		}
		// return TAG_RESPONSE_OK;
		return null;
	}

}
