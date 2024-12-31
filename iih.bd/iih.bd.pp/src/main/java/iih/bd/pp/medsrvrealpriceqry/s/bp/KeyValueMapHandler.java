package iih.bd.pp.medsrvrealpriceqry.s.bp;

import java.sql.ResultSet;
import java.sql.SQLException;

import xap.mw.core.data.FMap2;
import xap.sys.jdbc.handler.BaseHandler;

/**
 * 键值对字典处理器
 * 
 * @author hao_wu
 *
 */
public class KeyValueMapHandler extends BaseHandler {
	private static final long serialVersionUID = 1L;

	/**
	 * 键列名，值列名
	 */
	private String _keyColName, _valColName;

	/**
	 * 
	 * @param keyColName
	 *            键列名
	 * @param valColName
	 *            值列名
	 */
	public KeyValueMapHandler(String keyColName, String valColName) {
		this._keyColName = keyColName;
		this._valColName = valColName;
	}

	public Object processRs(ResultSet rs) throws SQLException {
		FMap2 results = new FMap2();
		while (rs.next()) {
			String key = (String) rs.getObject(this._keyColName);
			Object value = rs.getObject(this._valColName);
			results.put(key, value);
		}
		return results;
	}
}
