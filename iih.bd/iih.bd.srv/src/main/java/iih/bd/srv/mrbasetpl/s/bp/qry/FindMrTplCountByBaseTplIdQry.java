package iih.bd.srv.mrbasetpl.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据基础模板主键查询病历模板个数
 * 
 * @author hao_wu 2019-11-25
 *
 */
public class FindMrTplCountByBaseTplIdQry implements ITransQry {

	private String _baseTplId;

	public FindMrTplCountByBaseTplIdQry(String baseTplId) {
		this._baseTplId = baseTplId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._baseTplId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return "select count(1) from bd_mrtpl where id_basemrtpl = ?";
	}

}
