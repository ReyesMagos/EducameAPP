package co.com.educame.process.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;

import co.com.educame.dao.IDAOInstitucionEducativa;
import co.com.educame.dao.impl.DAOIntitucionEducativaImpl;
import co.com.educame.modelo.entidades.InstitucionEducacionSuperior;
import co.com.educame.persistence.sqlite.contract.InstitucionEducacionSuperiorContract;
import co.com.educame.process.IProcessInstitucionEducativa;

public class ProcessInstitucionEducativaImpl implements
		IProcessInstitucionEducativa {

	private IDAOInstitucionEducativa daoInstitucionEducativa;

	public ProcessInstitucionEducativaImpl(Context context) {
		super();
		this.daoInstitucionEducativa = DAOIntitucionEducativaImpl
				.getInstance(context);
	}

	@Override
	public InstitucionEducacionSuperior saveInstitucionEducacionSuperior(
			InstitucionEducacionSuperior institucionEducacionSuperior) {

		return ((this.daoInstitucionEducativa
				.saveInstitucion(this
						.convertInstitucionToContentValue(institucionEducacionSuperior)) != null) ? institucionEducacionSuperior
				: null);

	}

	@Override
	public List<InstitucionEducacionSuperior> findAllInstitucionEducacionSuperior() {

		try {
			List<ContentValues> conteValuesList = this.daoInstitucionEducativa
					.findAll(Boolean.FALSE,
							InstitucionEducacionSuperiorContract.TABLE_NAME,
							InstitucionEducacionSuperiorContract.Column
									.getAllColumns(), null, null, null, null,
							null, null);

			List<InstitucionEducacionSuperior> institucionEducacionSuperiorList = new ArrayList<InstitucionEducacionSuperior>();

			for (ContentValues contentValues : conteValuesList) {
				institucionEducacionSuperiorList.add(this
						.convertContentValueToInstitucion(contentValues));
			}

			return institucionEducacionSuperiorList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
	}

	private ContentValues convertInstitucionToContentValue(
			InstitucionEducacionSuperior institucionEducacionSuperior) {

		ContentValues contentValues = new ContentValues();

		contentValues.put(
				InstitucionEducacionSuperiorContract.Column.CODIGO_INSTITUCION,
				String.valueOf(institucionEducacionSuperior
						.getCodigoInstitucion()));
		contentValues.put(
				InstitucionEducacionSuperiorContract.Column.NOMBRE_INSTITUCION,
				institucionEducacionSuperior.getNombreInstitucion());

		// contentValues.put(
		// InstitucionEducacionSuperiorContract.Column.PARTITION_KEY,
		// institucionEducacionSuperior.getPartitionKey());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.CODIGO_CARACTER_INSTITUCIONAL,
		// institucionEducacionSuperior
		// .getCodigoCaracterInstitucional());

		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.CODIGO_MARCO_CREACION,
		// institucionEducacionSuperior.getCodigoMarcoCreacion());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.CODIGO_ORDEN_INSTITUCIONAL,
		// institucionEducacionSuperior
		// .getCodigoOrdenInstitucional());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.CODIGO_ORIGEN_INSTITUCIONAL,
		// institucionEducacionSuperior
		// .getCodigoOrigenInstitucional());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.CODIGO_TIPO_ACREDITACION,
		// institucionEducacionSuperior
		// .getCodigoTipoAcreditacion());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.NOMBRE_CARACTER_ACADEMICO,
		// institucionEducacionSuperior
		// .getNombreCaracterAcademico());

		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.NOMBRE_MARCO_CREACION,
		// institucionEducacionSuperior.getNombreMarcoCreacion());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.NOMBRE_ORIGEN_INSTITUCIONAL,
		// institucionEducacionSuperior
		// .getNombreOrigenInstitucional());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.NOMBRE_TIPO_ACREDITACION,
		// institucionEducacionSuperior
		// .getNombreTipoAcreditacion());
		// contentValues
		// .put(InstitucionEducacionSuperiorContract.Column.ORDEN_INSTITUCIONAL,
		// institucionEducacionSuperior.getOrdenInstitucional());
		// contentValues.put(
		// InstitucionEducacionSuperiorContract.Column.UBICACION,
		// institucionEducacionSuperior.getUbicacion().getDepartamento()
		// .getNombre());

		return contentValues;

	}

	public InstitucionEducacionSuperior convertContentValueToInstitucion(
			ContentValues contentValues) {

		InstitucionEducacionSuperior institucionEducacionSuperior = new InstitucionEducacionSuperior();

		institucionEducacionSuperior
				.setCodigoInstitucion(contentValues
						.getAsInteger(InstitucionEducacionSuperiorContract.Column.CODIGO_INSTITUCION));
		institucionEducacionSuperior
				.setNombreInstitucion(contentValues
						.getAsString(InstitucionEducacionSuperiorContract.Column.NOMBRE_INSTITUCION));
		return institucionEducacionSuperior;

	}

}
