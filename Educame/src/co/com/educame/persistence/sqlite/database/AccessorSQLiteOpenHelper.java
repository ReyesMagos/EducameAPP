package co.com.educame.persistence.sqlite.database;

import co.com.educame.persistence.sqlite.contract.InstitucionEducacionSuperiorContract;
import co.com.educame.persistence.sqlite.contract.PersistanceContract;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AccessorSQLiteOpenHelper extends SQLiteOpenHelper {

	private static final String TAG = AccessorSQLiteOpenHelper.class
			.getSimpleName();

	public AccessorSQLiteOpenHelper(Context context) {
		super(context, PersistanceContract.DATABASE_NAME, null,
				PersistanceContract.DATABASE_VERSION);

		Log.d(TAG, "Se creo la Base de datos");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlcreator = String
				.format("CREATE TABLE %s(%s TEXT PRIMARY KEY,"
						+ " %s TEXT)",
						InstitucionEducacionSuperiorContract.TABLE_NAME,
						InstitucionEducacionSuperiorContract.Column.CODIGO_INSTITUCION,
						InstitucionEducacionSuperiorContract.Column.NOMBRE_INSTITUCION);
		// InstitucionEducacionSuperiorContract.Column.PARTITION_KEY,
		// InstitucionEducacionSuperiorContract.Column.CODIGO_CARACTER_INSTITUCIONAL,
		 
		// InstitucionEducacionSuperiorContract.Column.CODIGO_MARCO_CREACION,
		// InstitucionEducacionSuperiorContract.Column.CODIGO_ORDEN_INSTITUCIONAL,
		// InstitucionEducacionSuperiorContract.Column.CODIGO_ORIGEN_INSTITUCIONAL,
		// InstitucionEducacionSuperiorContract.Column.CODIGO_TIPO_ACREDITACION,
		// InstitucionEducacionSuperiorContract.Column.NOMBRE_CARACTER_ACADEMICO,
		// InstitucionEducacionSuperiorContract.Column.NOMBRE_MARCO_CREACION,
		// InstitucionEducacionSuperiorContract.Column.NOMBRE_ORIGEN_INSTITUCIONAL,
		// InstitucionEducacionSuperiorContract.Column.NOMBRE_TIPO_ACREDITACION,
		// InstitucionEducacionSuperiorContract.Column.ORDEN_INSTITUCIONAL,
		// InstitucionEducacionSuperiorContract.Column.UBICACION);

		Log.d(TAG, sqlcreator);
		db.execSQL(sqlcreator);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL(String.format("DROP TABLE IF EXISTS %s",
				InstitucionEducacionSuperiorContract.TABLE_NAME));
		this.onCreate(db);

	}

}
