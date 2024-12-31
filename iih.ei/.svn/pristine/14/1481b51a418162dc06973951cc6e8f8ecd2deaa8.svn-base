package iih.ei.std.consis.v1.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询药品字典
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class FindDrugDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String baseSql = getBaseSql();
		return baseSql;
	}

	private String getBaseSql() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDMM.CODE AS DRUG_CODE,");
		sql.append("BDMM.printname AS DRUG_NAME,");
		sql.append("BDMM.SPEC AS DRUG_SPEC,");
		sql.append("MEASDOC_PKGSP.NAME AS UNIT,");
		sql.append("MEASDOC_BASE.NAME AS MINUNIT,");
		sql.append("MEASDOC_PKGSP.NAME AS MAXUNIT,");
		sql.append("NVL(BDSRV.QUAN_MED,0) AS DOSAGE,");
		sql.append("BDMM.PRICE AS PRICE1,");
		sql.append("1 AS CONVERTION1,");
		sql.append("DECODE(BDMMPKGU.FACTOR,NULL,1,BDMM.FACTOR_SB/BDMMPKGU.FACTOR) AS CONVERTION2,");
		sql.append("0 AS STORAGETYPE,");
		sql.append("BDMM.FG_ACTIVE AS ALLOWIND,");
		sql.append("BDMM.APPRNO AS PASSNO,");
		sql.append("SUP.CODE AS CODE_SUP,");
		sql.append("SUP.NAME AS NAME_SUP,");
		sql.append("BDSRV.NAME as NAME_SRV ");
		sql.append("FROM BD_MM BDMM ");
		sql.append("LEFT JOIN BD_MEASDOC MEASDOC_BASE ");
		sql.append("ON BDMM.ID_UNIT_PKGBASE = MEASDOC_BASE.ID_MEASDOC ");
		sql.append("LEFT JOIN BD_MM_PKGU BDMMPKGU ");
		sql.append(
				"ON BDMM.ID_MM = BDMMPKGU.ID_MM AND BDMMPKGU.EN_OPPKGTP = '1' AND BDMMPKGU.SD_MMPKGUPRO IN ('0','1')");
		sql.append("LEFT JOIN BD_MEASDOC MEASDOC_PKGSP ");
		sql.append("ON BDMM.ID_UNIT_PKGSP = MEASDOC_PKGSP.ID_MEASDOC ");
		sql.append("LEFT JOIN BD_SRV BDSRV ");
		sql.append("ON BDMM.ID_SRV = BDSRV.ID_SRV ");
		sql.append("LEFT JOIN BD_SUP SUP ");
		sql.append("ON BDMM.ID_SUP = SUP.ID_SUP ");
		sql.append("WHERE (BDMM.SD_MMTP LIKE '101%' OR BDMM.SD_MMTP LIKE '102%') ");
		return sql.toString();
	}
}
