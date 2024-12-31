package iih.bd.srv.medsrv.s.rule.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 计算医疗服务套临床必选项目数量SQL
 * 
 * @author hao_wu
 *
 */
public class CalMedSrvSetItmChkNumSql implements ITransQry {

	private String[] _medSrvSetIds;

	public CalMedSrvSetItmChkNumSql(String[] medSrvSetIds) {
		this._medSrvSetIds = medSrvSetIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT);
		sqlParam.addParam(IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = GetWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础Sql
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" UPDATE BD_SRV				     ");
		sqlBuilder.append(" SET BD_SRV.SETITMCHKNUM =				     ");
		sqlBuilder.append("   (SELECT SUM(bd_srvset_def.quan_medu)			     ");
		sqlBuilder.append("   FROM bd_srvset_def			     ");
		sqlBuilder.append("   WHERE bd_srvset_def.id_srv = BD_SRV.id_srv     ");
		sqlBuilder.append("   AND bd_srvset_def.fg_clinical            = 'Y'		     ");
		sqlBuilder.append("   AND (bd_srvset_def.fg_edit              IS NULL		     ");
		sqlBuilder.append("   OR bd_srvset_def.fg_edit                 = 'N')		     ");
		sqlBuilder.append("   AND ((BD_SRV.SD_PRIMD     <> ?		     ");
		sqlBuilder.append("   AND bd_srvset_def.fg_clinical_bl         = 'Y')		     ");
		sqlBuilder.append("   OR (BD_SRV.SD_PRIMD        = ?))	     ");
		sqlBuilder.append("   )						     ");
		sqlBuilder.append(" WHERE BD_SRV.fg_set = 'Y'			     ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");

		String wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		if (this._medSrvSetIds != null && this._medSrvSetIds.length > 0) {
			wherePart = SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, this._medSrvSetIds);
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

}
