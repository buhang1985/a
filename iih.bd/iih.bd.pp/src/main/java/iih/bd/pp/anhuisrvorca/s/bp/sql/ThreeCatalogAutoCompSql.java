package iih.bd.pp.anhuisrvorca.s.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class ThreeCatalogAutoCompSql implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" (SELECT NULL AS ID_HPSRVORCA, ");
		sqlBuilder.append("        BD_SRV.ID_SRV, ");
		sqlBuilder.append("        NULL AS ID_MM, ");
		sqlBuilder.append(" 	   ZL_ORGINAL.ID_HP, ");
		sqlBuilder.append(" 	   ZL_ORGINAL.CODE, ");
		sqlBuilder.append("        ZL_ORGINAL.NAME, ");
		sqlBuilder.append("        DECODE(ZL_ORGINAL.CODE,NULL,'0','2') AS EU_STATUS, ");
		sqlBuilder.append("        '2' AS EU_HPSRVTP ");
		sqlBuilder.append(" FROM BD_SRV BD_SRV ");
		sqlBuilder.append(" LEFT JOIN (SELECT NAME, MIN(CODE) ONLYCODE FROM BD_HP_ZL_ORGINAL GROUP BY NAME) A ");
		sqlBuilder.append(" ON A.NAME = BD_SRV.NAME ");
		sqlBuilder.append(" LEFT JOIN BD_HP_ZL_ORGINAL ZL_ORGINAL ");
		sqlBuilder.append(" ON ZL_ORGINAL.CODE = A.ONLYCODE ");
		sqlBuilder.append(" WHERE BD_SRV.FG_MM = 'N' ");
		
		sqlBuilder.append(" AND BD_SRV.ID_SRV NOT IN ( ");
		sqlBuilder.append(" SELECT ");
		sqlBuilder.append(" DISTINCT(BD_SRV.ID_SRV) ");
		sqlBuilder.append(" FROM BD_HP_FWSS_ORGINAL FWSS_ORGINAL ");
		sqlBuilder.append(" INNER JOIN BD_SRV BD_SRV");
		sqlBuilder.append(" ON BD_SRV.name = FWSS_ORGINAL.name ");
	    sqlBuilder.append(" ) ");
		
		sqlBuilder.append(" AND BD_SRV.ID_SRV NOT IN ( ");
		sqlBuilder.append(" 	SELECT ID_SRV FROM BD_HP_SRVORCA WHERE EU_STATUS IN('2','3','4'))) ");
		
		
		sqlBuilder.append(" UNION    ");
		
		
//		sqlBuilder.append(" (SELECT NULL AS ID_HPSRVORCA, ");
//		sqlBuilder.append("        BD_SRV.ID_SRV, ");
//		sqlBuilder.append("        NULL AS ID_MM, ");
//		sqlBuilder.append("        FWSS_ORGINAL.ID_HP, ");
//		sqlBuilder.append("        FWSS_ORGINAL.CODE, ");
//		sqlBuilder.append("        FWSS_ORGINAL.NAME, ");
//		sqlBuilder.append("        DECODE(FWSS_ORGINAL.CODE,NULL,'0','2') AS EU_STATUS ");
//		sqlBuilder.append(" FROM BD_SRV BD_SRV ");
//		sqlBuilder.append(" LEFT JOIN (SELECT NAME, MIN(CODE) ONLYCODE FROM BD_HP_FWSS_ORGINAL GROUP BY NAME) A ");
//		sqlBuilder.append(" ON A.NAME = BD_SRV.NAME ");
//		sqlBuilder.append(" LEFT JOIN BD_HP_FWSS_ORGINAL FWSS_ORGINAL ");
//		sqlBuilder.append(" ON FWSS_ORGINAL.CODE = A.ONLYCODE ");
//		sqlBuilder.append(" WHERE BD_SRV.FG_MM = 'N' ");
//		sqlBuilder.append(" AND BD_SRV.CODE NOT IN ( ");
//		sqlBuilder.append(" 	SELECT CODE FROM BD_HP_SRVORCA WHERE EU_STATUS IN('0','1'))) ");
		
		sqlBuilder.append(" (SELECT NULL AS ID_HPSRVORCA, ");
		sqlBuilder.append(" 		BD_SRV.ID_SRV, ");
		sqlBuilder.append(" 		NULL AS ID_MM, ");
		sqlBuilder.append(" 		FWSS_ORGINAL.ID_HP, ");
		sqlBuilder.append(" 		FWSS_ORGINAL.CODE, ");
		sqlBuilder.append(" 		FWSS_ORGINAL.NAME, ");
		sqlBuilder.append(" 		DECODE(BD_SRV.ID_SRV,NULL,'0','2') AS EU_STATUS, ");
		sqlBuilder.append("        '3' AS EU_HPSRVTP ");
		sqlBuilder.append(" FROM BD_HP_FWSS_ORGINAL FWSS_ORGINAL ");
		sqlBuilder.append(" LEFT JOIN (SELECT NAME, MIN(CODE) ONLYCODE FROM BD_SRV GROUP BY NAME) A ");
		sqlBuilder.append(" ON A.NAME = FWSS_ORGINAL.NAME ");
		sqlBuilder.append(" LEFT JOIN BD_SRV BD_SRV ");
		sqlBuilder.append(" ON BD_SRV.CODE = A.ONLYCODE ");
		sqlBuilder.append(" WHERE FWSS_ORGINAL.CODE NOT IN ");
		sqlBuilder.append(" (SELECT CODE FROM BD_HP_SRVORCA WHERE EU_STATUS IN('2','3','4'))) ");
		
		sqlBuilder.append(" UNION ");
		
		sqlBuilder.append(" (SELECT NULL AS ID_HPSRVORCA, ");
		sqlBuilder.append(" 	   BD_MM.ID_SRV, ");
		sqlBuilder.append("        BD_MM.ID_MM, ");
		sqlBuilder.append("        DRUG_ORGINAL.ID_HP, ");
		sqlBuilder.append("        DRUG_ORGINAL.CODE, ");
		sqlBuilder.append("        DRUG_ORGINAL.NAME, ");
		sqlBuilder.append("        DECODE(DRUG_ORGINAL.CODE,NULL,'0','2') AS EU_STATUS, ");
		sqlBuilder.append("        '1' AS EU_HPSRVTP ");
		sqlBuilder.append(" FROM BD_MM BD_MM ");
		sqlBuilder.append(" LEFT JOIN (SELECT NAME, MIN(CODE) ONLYCODE FROM BD_HP_DRUG_ORGINAL GROUP BY NAME) A ");
		sqlBuilder.append(" ON A.NAME = BD_MM.NAME ");
		sqlBuilder.append(" LEFT JOIN BD_HP_DRUG_ORGINAL DRUG_ORGINAL ");
		sqlBuilder.append(" ON DRUG_ORGINAL.CODE = A.ONLYCODE ");
		sqlBuilder.append(" WHERE BD_MM.ID_MM NOT IN ( ");
		sqlBuilder.append("       SELECT ID_MM FROM BD_HP_SRVORCA WHERE EU_STATUS IN('2','3','4'))) ");
		return sqlBuilder.toString();
	}

}
