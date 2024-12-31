package iih.mi.itf2.service.bp.bdservice.treat.sql;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询诊疗和服务设施对照SQL
 * Title: FindTreatAndFwssCompNewSql.java
 * @author zhang.hw
 * @date 2019年5月27日  
 * @version 1.0
 */
public class FindTreatAndFwssCompSql implements ITransQry {

	private String _wherePart;
	private String _hpId;

	public FindTreatAndFwssCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(MiDirEnum.MIDIRSRV);
		sqlParam.addParam(MiDirEnum.MIDIRFACILITY);
		sqlParam.addParam(MiDirEnum.MIDIRMC);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append("SRVORCA.ID_MM = '~'");
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  * ");
		sql.append("     FROM  (SELECT  SRVORCA.ID_HP, ");
		sql.append("                                   SRV.ID_SRV                      ID_SRV, ");
		sql.append("                                   SRV.CODE                          SRV_CODE, ");
		sql.append("                                   SRV.NAME                          SRV_NAME,   ");
		sql.append("                                   SRV_PRI.PRICE                SRV_PRICE,   ");
		sql.append("                                   SRV.PYCODE                      SRV_PYCODE,   ");
		sql.append("                                   SRV.WBCODE                      SRV_WBCODE,   ");
		sql.append("                                   SRV_UNIT.NAME                AS  SRV_UNIT,   ");
		sql.append("                                   SRV.QUAN_MED                  AS  SRV_QUAN,   ");
		sql.append("                                   SRV_FREQ.NAME                AS  SRV_FREQ,   ");
		sql.append("                                   SRVORCA.DT_B,   ");
		sql.append("                                   SRVORCA.DT_E,   ");
		sql.append("                                   SRVORCA.ID_HPSRVORCA,  ");
		sql.append("                                   SRVORCA.EU_HPSRVTP,  ");
		sql.append("                                   SRVORCA.EU_STATUS        EU_STATUS,   ");
		sql.append("                                   SRVORCA.ID_MM                AS  ID_MM, ");
		sql.append("                                   SRVORCA.code                  as  mi_code, ");
		sql.append("                                   SRVORCA.Name                  as  mi_name ");
		sql.append("                         FROM  BD_HP_SRVORCA  SRVORCA ");
		sql.append("                         LEFT  OUTER  JOIN  BD_SRV  SRV ");
		sql.append("                             ON  SRV.ID_SRV  =  SRVORCA.ID_SRV ");
		sql.append("                           AND  SRV.DS  =  0 ");
		sql.append("                         LEFT  OUTER  JOIN  BD_PRI_SRV  SRV_PRI ");
		sql.append("                             ON  SRV_PRI.ID_SRV  =  SRVORCA.ID_SRV ");
		sql.append("                           AND  SRV_PRI.DT_E  =  '2099-12-31  23:59:59' ");
		sql.append("                         LEFT  JOIN  BD_MEASDOC  SRV_UNIT ");
		sql.append("                             ON  SRV_UNIT.ID_MEASDOC  =  SRV.ID_UNIT_MED ");
		sql.append("                         LEFT  JOIN  BD_ROUTE  SRV_ROUTE ");
		sql.append("                             ON  SRV_ROUTE.ID_ROUTE  =  SRV.ID_ROUTE ");
		sql.append("                         LEFT  JOIN  BD_FREQ  SRV_FREQ ");
		sql.append("                             ON  SRV_FREQ.ID_FREQ  =  SRV.ID_FREQ ");
		sql.append("                       WHERE  SRV.DS  =  '0'  AND　SRVORCA.ID_HP  =  ? ");
		sql.append("                           AND  (SRVORCA.EU_HPSRVTP  =  ?  or  SRVORCA.EU_HPSRVTP  =  ? or  SRVORCA.EU_HPSRVTP  =  ?)  )  SRVORCA ");

		return sql.toString();
	}
}
