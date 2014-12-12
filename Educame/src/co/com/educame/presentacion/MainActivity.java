package co.com.educame.presentacion;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import co.com.educame.R;
import co.com.educame.controladores.MainController;
import co.com.educame.modelo.entidades.InstitucionEducacionSuperior;
import co.com.educame.presentacion.adaptadores.CustomAdapterIes;

public class MainActivity extends Activity {

	private ListView lvIes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MainController mainController = new MainController(this);
		mainController.getRestFulServices();
		lvIes = (ListView) findViewById(R.id.lv_ies);
	}

	public void init(
			List<InstitucionEducacionSuperior> listaInstitucionEducacionSuperior) {

		String[] iesNames = new String[listaInstitucionEducacionSuperior.size()];
		int i = 0;
		for (InstitucionEducacionSuperior ies : listaInstitucionEducacionSuperior) {
			iesNames[i] = ies.getNombreInstitucion();
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, iesNames);
		;
		CustomAdapterIes customAdapterIes = new CustomAdapterIes(
				getApplicationContext(), listaInstitucionEducacionSuperior);

		lvIes.setAdapter(customAdapterIes);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
