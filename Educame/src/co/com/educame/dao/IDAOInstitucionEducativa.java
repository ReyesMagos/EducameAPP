package co.com.educame.dao;

import java.util.List;

import android.content.ContentValues;

public interface IDAOInstitucionEducativa {

	public ContentValues saveInstitucion(ContentValues institucionContentValue);

	public List<ContentValues> findAll(Boolean disctinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupby, String having, String orderBy, String limit);

}
