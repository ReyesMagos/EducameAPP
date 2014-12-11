package co.com.educame.presentacion;

import java.util.List;

import co.com.educame.modelo.entidades.InstitucionEducacionSuperior;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomAdapterIes extends BaseAdapter {
	
	private Context context;
	private  List<InstitucionEducacionSuperior> listaInstitucionesEducativas;
	
	

	public CustomAdapterIes(Context context,
			List<InstitucionEducacionSuperior> listaInstitucionesEducativas) {
		super();
		this.context = context;
		this.listaInstitucionesEducativas = listaInstitucionesEducativas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
