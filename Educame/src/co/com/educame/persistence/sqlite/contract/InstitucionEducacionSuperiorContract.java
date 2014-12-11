package co.com.educame.persistence.sqlite.contract;

public class InstitucionEducacionSuperiorContract {

	public static final String TABLE_NAME = "INSTITUCION_EDUCACION_SUPERIOR";

	public InstitucionEducacionSuperiorContract() {
		super();
	}

	public static final class Column {
		// public static final String PARTITION_KEY ="partition_key";
		public static final String CODIGO_INSTITUCION = "codigo_institucion";
		public static final String NOMBRE_INSTITUCION = "nombre_institucion";

		// public static final String CODIGO_ORDEN_INSTITUCIONAL =
		// "codigo_orden_institucional";
		// public static final String ORDEN_INSTITUCIONAL =
		// "orden_institucional";
		// public static final String CODIGO_ORIGEN_INSTITUCIONAL =
		// "codigo_origen_institucional";
		// public static final String NOMBRE_ORIGEN_INSTITUCIONAL =
		// "nombre_origen_institucional";
		// public static final String CODIGO_CARACTER_INSTITUCIONAL =
		// "codigo_caracter_institucional";
		// public static final String NOMBRE_CARACTER_ACADEMICO =
		// "nombre_caracter_academico";
		// public static final String CODIGO_TIPO_ACREDITACION =
		// "codigo_tipo_acreditacion";
		// public static final String NOMBRE_TIPO_ACREDITACION =
		// "nombre_tipo_acreditacion";
		// public static final String CODIGO_MARCO_CREACION =
		// "codigo_marco_creacion";
		// public static final String NOMBRE_MARCO_CREACION =
		// "nombre_marco_creacion";
		// public static final String UBICACION = "ubicacion";

		public static final String[] getAllColumns() {

			return (new String[] { CODIGO_INSTITUCION, NOMBRE_INSTITUCION, });
		}
	}

}
