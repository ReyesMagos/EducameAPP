package co.com.educame.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import co.com.educame.dao.IDAOInstitucionEducativa;
import co.com.educame.persistence.sqlite.contract.InstitucionEducacionSuperiorContract;
import co.com.educame.persistence.sqlite.database.AccessorSQLiteOpenHelper;

public class DAOIntitucionEducativaImpl implements IDAOInstitucionEducativa {

	private static final String TAG = DAOIntitucionEducativaImpl.class
			.getSimpleName();

	private static DAOIntitucionEducativaImpl instance = null;
	private AccessorSQLiteOpenHelper accessorSQLiteOpenHelper;

	private DAOIntitucionEducativaImpl(Context context) {
		super();
		this.accessorSQLiteOpenHelper = new AccessorSQLiteOpenHelper(context);
	}

	public static synchronized DAOIntitucionEducativaImpl getInstance(
			Context context) {
		if (instance == null) {
			instance = new DAOIntitucionEducativaImpl(context);
		}

		return instance;
	}

	@Override
	public ContentValues saveInstitucion(ContentValues institucionContentValue) {

		try {
			SQLiteDatabase sqLiteDatabase = accessorSQLiteOpenHelper
					.getWritableDatabase();

			long rowId = sqLiteDatabase.insertWithOnConflict(
					InstitucionEducacionSuperiorContract.TABLE_NAME, null,
					institucionContentValue, SQLiteDatabase.CONFLICT_IGNORE);
			return ((rowId != -1L) ? institucionContentValue : null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<ContentValues> findAll(Boolean disctinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupby, String having, String orderBy, String limit) {

		try {
			SQLiteDatabase sqLiteDatabase = accessorSQLiteOpenHelper
					.getReadableDatabase();
			Cursor cursor = sqLiteDatabase.query(disctinct.booleanValue(),
					table, columns, selection, selectionArgs, groupby, having,
					orderBy, limit);
			List<ContentValues> contentValuesList = this.convertCursorToEntity(
					cursor, columns);
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private List<ContentValues> convertCursorToEntity(Cursor cursor,
			String[] columns) {
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		ContentValues contentValues = null;
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			contentValues = new ContentValues();

			for (String column : columns) {
				contentValues.put(column,
						cursor.getString(cursor.getColumnIndex(column)));
			}

			contentValuesList.add(contentValues);
			cursor.moveToNext();
		}

		return (contentValuesList);
	}

}
