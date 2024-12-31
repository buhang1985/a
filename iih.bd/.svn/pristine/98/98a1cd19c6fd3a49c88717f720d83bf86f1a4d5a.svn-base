package iih.bd.pp.medsrvrealpriceqry.s.bp;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.handler.BaseHandler;

/**
 * 键值对字典处理器
 * 
 * @author hao_wu
 *
 */
public class MedSrvRefPriMapHandler extends BaseHandler {
	private static final long serialVersionUID = 1L;

	/**
	 * 键列名，值列名
	 */
	private String _keyColName, _valColName;

	/**
	 * 
	 * @param keyColName 键列名
	 * @param valColName 值列名
	 */
	public MedSrvRefPriMapHandler(String keyColName, String valColName) {
		this._keyColName = keyColName;
		this._valColName = valColName;
	}

	public Object processRs(ResultSet rs) throws SQLException {
		FMap results = new FMap();
		while (rs.next()) {
			String key = (String) rs.getObject(this._keyColName);
			Object value = rs.getObject(this._valColName);
			FDouble pri = convertToDouble(value);
			results.put(key, pri);
		}
		return results;
	}

	/**
	 * 转换价格类型到FDouble
	 * 
	 * @param valueObj
	 * @return
	 */
	private FDouble convertToDouble(Object valueObj) {
		FDouble doubleValue = null;
		if (valueObj instanceof Integer) {
			doubleValue = new FDouble((Integer) valueObj);
		} else if (valueObj instanceof BigDecimal) {
			doubleValue = new FDouble((BigDecimal) valueObj);
		}
		return doubleValue;
	}
}
