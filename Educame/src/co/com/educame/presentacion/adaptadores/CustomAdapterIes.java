package co.com.educame.presentacion.adaptadores;

import java.util.List;

import co.com.educame.R;
import co.com.educame.modelo.entidades.InstitucionEducacionSuperior;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapterIes extends BaseAdapter {

	private Context context;
	private List<InstitucionEducacionSuperior> listaInstitucionesEducativas;

	public CustomAdapterIes(Context context,
			List<InstitucionEducacionSuperior> listaInstitucionesEducativas) {
		super();
		this.context = context;
		this.listaInstitucionesEducativas = listaInstitucionesEducativas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaInstitucionesEducativas.size();
	}

	@Override
	public InstitucionEducacionSuperior getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.listaInstitucionesEducativas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return this.listaInstitucionesEducativas.indexOf(getItem(arg0));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater.inflate(R.layout.custom_ies_layout, null);

			holder = new viewHolder();
			holder.txtNombre = (TextView) convertView
					.findViewById(R.id.txt_nombre);
			holder.txtubicacion = (TextView) convertView
					.findViewById(R.id.txt_ubicacion);
			convertView.setTag(holder);
		} else {
			holder = (viewHolder) convertView.getTag();
		}
		InstitucionEducacionSuperior institucionEducacionSuperior = getItem(position);

		holder.txtNombre.setText(institucionEducacionSuperior
				.getNombreInstitucion());
		holder.txtubicacion.setText(institucionEducacionSuperior.getUbicacion()
				.getDepartamento().getNombre()
				+ "/"
				+ institucionEducacionSuperior.getUbicacion().getMunicipio()
						.getNombre());

		return convertView;
	}

	private class viewHolder {
		TextView txtNombre;
		TextView txtubicacion;
	}

}
