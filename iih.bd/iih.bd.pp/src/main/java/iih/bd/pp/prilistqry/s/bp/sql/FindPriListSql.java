package iih.bd.pp.prilistqry.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 查询价表SQL
 * 
 * @author hao_wu
 *
 */
public class FindPriListSql implements ITransQry {

	private String _wherePart;

	public FindPriListSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		sqlParam.addParam(srvDateTime);
		sqlParam.addParam(srvDateTime);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = GeBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = GetWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String GeBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT * FROM ( ");
		sqlBuilder.append(" SELECT SRV.ID_SRV, SRV.NAME NAME_SRV, SRV.CODE CODE_SRV, SRV.ID_UNIT_MED,");
		sqlBuilder.append(" PRISRV.PRICE AS PRICE, MEASDOC.NAME AS NAME_UNIT, SRV.ID_SRVCA, ");
		sqlBuilder.append(" SRVCA.NAME AS SRVCA_NAME ");
		sqlBuilder.append(" FROM BD_SRV SRV							    ");
		sqlBuilder.append(" LEFT JOIN BD_PRI_SRV PRISRV ON PRISRV.DS  = 0 AND PRISRV.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND PRISRV.DT_B   <= ?				    ");
		sqlBuilder.append(" AND PRISRV.DT_E   > ? AND PRISRV.ID_SRV  = SRV.ID_SRV ");
		sqlBuilder.append(" LEFT JOIN BD_MEASDOC MEASDOC ON MEASDOC.DS   = 0 		    ");

		// 数据管控
		String wherePart = BdEnvContextUtil.processEnvContext(new MeasDocDO(), "MEASDOC");
		sqlBuilder.append(" AND ");
		sqlBuilder.append(wherePart);

		sqlBuilder.append(" AND SRV.ID_UNIT_MED=MEASDOC.ID_MEASDOC 					    ");
		sqlBuilder.append(" LEFT JOIN BD_SRVCA SRVCA ON SRVCA.DS = 0 ");

		// 数据管控
		wherePart = BdEnvContextUtil.processEnvContext(new SrvCateDO(), "SRVCA");
		sqlBuilder.append(" AND ");
		sqlBuilder.append(wherePart);

		sqlBuilder.append(" AND SRVCA.ID_SRVCA = SRV.ID_SRVCA					    ");
		sqlBuilder.append(" WHERE SRV.DS =0 AND SRV.FG_BL   ='Y' AND SRV.FG_ACTIVE = 'Y' 	    ");
		sqlBuilder.append(" AND SRV.FG_MM   = 'N' 						    ");

		// 数据管控
		wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "SRV");
		sqlBuilder.append(" AND ");
		sqlBuilder.append(wherePart);

		sqlBuilder.append(" )");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

}
