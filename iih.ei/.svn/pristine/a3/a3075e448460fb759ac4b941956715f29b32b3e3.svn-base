package iih.ei.std.consis.v1.s.bp.qry;

import iih.mp.dg.opdrugdisp.d.PresMpStatus;
import iih.mp.dg.opdrugdisp.d.PresPrepStatus;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取处方集合信息
 * 
 * @author dj.zhang
 * @data 2018年7月12日下午4:57:05
 * 
 */
public class FindPrescListQry implements ITransQry {

	private String _presIds;
	private String _depwh;
	private String _enCardCode;

	public FindPrescListQry(String presIds, String depwh, String enCardCode) {
		this._presIds = presIds;
		this._depwh = depwh;
		this._enCardCode = enCardCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._enCardCode);
		sqlParam.addParam(this._depwh);
		sqlParam.addParam(PresPrepStatus.PREP_YES);
		sqlParam.addParam(PresMpStatus.DISP_NO);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePart = new StringBuilder("1 = 1 ");
		wherePart.append("AND " + this._presIds);
		wherePart.append("AND ORSRV.ID_DEP_WH = ? ");
		wherePart.append("AND PRESST.EN_DISP < ? ");
		wherePart.append("AND PRESST.EU_SU_MPDGOP= ? ");
		return wherePart.toString();
	}

	private String getBaseSql() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PRESST.ID_PRES, ");
		sql.append("ORSRV.ID_ORSRV, ");
		sql.append("0 AS COSTS, ");
		sql.append("SRVMM.PRICE_PGKU_CUR AS COSTS_DETAIL, ");
		sql.append("PRES.DT_ENTRY PRESC_DATE, ");
		sql.append("PRES.ID_PRES PRESC_NO, ");
		sql.append("BDDEP.CODE AS DISPENSARY, ");
		sql.append("? AS PATIENT_ID, ");
		sql.append("PAT.NAME AS PATIENT_NAME, ");
		sql.append("PAT.DT_BIRTH AS DATE_OF_BIRTH, ");
		sql.append("SEXDOC.NAME AS SEX, ");
		sql.append("ORD.ORDERS AS REPETITION, ");
		sql.append("BDDEP.CODE AS ORDERED_BY, ");
		sql.append("BDDEP.NAME AS ORDERED_BY_NAME, ");
		sql.append("BDPSNDOC.NAME AS PRESCRIBED_BY, ");
		sql.append("'1' AS DISPENSE_PRI, ");
		sql.append("MM.CODE AS ITEM_NO, ");
		sql.append("MM.CODE AS DRUG_CODE,  ");
		sql.append("MM.SPEC AS DRUG_SPEC, ");
		sql.append("MM.PRINTNAME AS DRUG_NAME, ");
		sql.append("NVL(SRVMM.QUAN_CUR,0) AS QUANTITY, ");
		sql.append("MEASDOC.NAME AS UNIT, ");
		sql.append("ORSRV.QUAN_MEDU AS DOSAGE, ");
		sql.append("BDMEASDOC.NAME AS DOSAGE_UNITS, ");
		sql.append("NVL(BDROUTE.NAME,'') || DECODE(ORSRV.FG_SKINTEST,'Y','(皮试)','') AS ADMINISTRATION, ");
		sql.append("PRES.Str_Name_Di AS rcpt_info, ");
		sql.append("BDFREQ.NAME AS FREQUENCY ");
		sql.append("FROM MP_DG_PRESST PRESST ");
		sql.append("JOIN CI_PRES PRES ");
		sql.append("ON PRESST.ID_PRES = PRES.ID_PRES ");
		sql.append("LEFT JOIN EN_ENT ENT ");
		sql.append("ON ENT.ID_ENT = PRES.ID_EN ");
		sql.append("LEFT JOIN PI_PAT PAT ");
		sql.append("ON PAT.ID_PAT = PRES.ID_PATI ");
		sql.append("LEFT JOIN BD_UDIDOC SEXDOC ");
		sql.append("ON SEXDOC.ID_UDIDOC = PAT.ID_SEX ");
		sql.append("JOIN CI_OR_SRV ORSRV ");
		sql.append("ON ORSRV.ID_PRES=PRESST.ID_PRES ");
		sql.append("JOIN CI_OR_SRV_MM SRVMM ");
		sql.append("ON SRVMM.ID_ORSRV=ORSRV.ID_ORSRV ");
		sql.append("LEFT JOIN BD_MM MM ");
		sql.append("ON SRVMM.ID_MM = MM.ID_MM  ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON BDDEP.ID_DEP = ORSRV.ID_DEP_WH ");
		sql.append("JOIN CI_ORDER ORD ");
		sql.append("ON ORD.ID_OR = ORSRV.ID_OR ");
		sql.append("LEFT JOIN BD_MEASDOC BDMEASDOC ");
		sql.append("ON BDMEASDOC.ID_MEASDOC = ORSRV.ID_MEDU ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON BDDEP.ID_DEP = ORD.ID_DEP_OR  ");
		sql.append("LEFT JOIN BD_PSNDOC BDPSNDOC ");
		sql.append("ON BDPSNDOC.ID_PSNDOC = ORD.ID_EMP_OR ");
		sql.append("LEFT JOIN BD_ROUTE BDROUTE ");
		sql.append("ON BDROUTE.ID_ROUTE = ORD.ID_ROUTE ");
		sql.append("LEFT JOIN BD_FREQ BDFREQ ");
		sql.append("ON BDFREQ.ID_FREQ = ORD.ID_FREQ ");
		sql.append("LEFT JOIN BD_MEASDOC MEASDOC ");
		sql.append("ON MEASDOC.ID_MEASDOC = SRVMM.id_pgku_cur ");
		return sql.toString();
	}

}
