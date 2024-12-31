package iih.bd.srv.emrtpl.s.bp.sql;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 设置医疗记录模板为非默认sql
 * 
 * @author hao_wu
 *
 */
public class SetMrtplNotDefaultSql implements ITransQry {

	private EmrTplDO _defaultMrtpl;

	public SetMrtplNotDefaultSql(EmrTplDO defaultMrtpl) {
		this._defaultMrtpl = defaultMrtpl;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._defaultMrtpl.getId_mrtp());
		sqlParam.addParam(this._defaultMrtpl.getId_owtp());
		sqlParam.addParam(this._defaultMrtpl.getId_mrtpl());
		if (this._defaultMrtpl.getSd_owtp().equals(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT)) {
			sqlParam.addParam(this._defaultMrtpl.getId_dept());
		} else if (this._defaultMrtpl.getSd_owtp().equals(IBdSrvDictCodeConst.SD_OWTP_PERSONAL)) {
			sqlParam.addParam(this._defaultMrtpl.getId_emp());
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(String.format("UPDATE %s SET ISDEFAULT = 'N' ", new EmrTplDO().getTableName()));
		String wherePart = BuildWherePart();
		if (wherePart != null && !wherePart.isEmpty()) {
			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(this._defaultMrtpl, false);
		wherePartBuilder.append(bdModeWherePart);
		wherePartBuilder.append(" AND ID_MRTP = ? AND ID_OWTP = ? AND ID_MRTPL <> ?");
		if (this._defaultMrtpl.getSd_owtp().equals(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT)) {
			wherePartBuilder.append(" AND ID_DEPT = ?");
		} else if (this._defaultMrtpl.getSd_owtp().equals(IBdSrvDictCodeConst.SD_OWTP_PERSONAL)) {
			wherePartBuilder.append(" AND ID_EMP = ?");
		} else if (this._defaultMrtpl.getSd_owtp().equals(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL)) {
			wherePartBuilder.append(" AND ID_EMP = '~' AND ID_DEPT = '~'");
		} else {
			wherePartBuilder.append(" AND 1 <> 1");
		}
		return wherePartBuilder.toString();
	}
}
