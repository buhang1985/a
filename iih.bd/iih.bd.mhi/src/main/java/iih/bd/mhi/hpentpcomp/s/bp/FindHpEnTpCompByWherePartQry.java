package iih.bd.mhi.hpentpcomp.s.bp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据条件语句查询医保就诊类型对照
 * 
 * @author hao_wu
 *
 */
public class FindHpEnTpCompByWherePartQry implements ITransQry {

	private String _wherePart;

	public FindHpEnTpCompByWherePartQry(String whereStr) {
		this._wherePart = whereStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return null;
	}

}
