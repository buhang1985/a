package iih.bd.pp.anhuiinsur.bgtasks.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保诊疗个数差异SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedITreatCountDiffSql implements ITransQry {
	private MedInsurRecDiffDO _recDiff;
	private Integer _diffType;

	public FindMedITreatCountDiffSql(MedInsurRecDiffDO recDiff, Integer diffType) {
		this._recDiff = recDiff;
		this._diffType = diffType;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._diffType);
		if (this._diffType.equals(AHMedIRecDiffType.ADD)) {
			sqlParam.addParam(this._recDiff.getId_predown());
			sqlParam.addParam(this._recDiff.getId_curdown());
		}
		if (this._diffType.equals(AHMedIRecDiffType.DEL)) {
			sqlParam.addParam(this._recDiff.getId_curdown());
			sqlParam.addParam(this._recDiff.getId_predown());
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = GetWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT *					");
		sqlBuilder.append(" FROM					");
		sqlBuilder.append("   (SELECT ? AS EU_DIFFTYPE,       			");
		sqlBuilder.append("     A0.ID_GRP,             			");
		sqlBuilder.append("     A0.ID_ORG,             			");
		sqlBuilder.append("     A0.ID_DOWN,            			");
		sqlBuilder.append("     A0.PAY_SELF_TP,        			");
		sqlBuilder.append("     A0.STR_APPROVE,        			");
		sqlBuilder.append("     A0.STR_TWO_INSURPAY,   			");
		sqlBuilder.append("     A0.STR_ADD_INSUR,      			");
		sqlBuilder.append("     A0.STR_ADD_INSUR_SAL,  			");
		sqlBuilder.append("     A0.STR_SPECIAL_ITM,    			");
		sqlBuilder.append("     A0.ORIGIN_PLACE,       			");
		sqlBuilder.append("     A0.AMT_PREPAY_MAX,     			");
		sqlBuilder.append("     A0.DOMESTIC_PRI_MAX,   			");
		sqlBuilder.append("     A0.STR_HOSPITAL_HELP,  			");
		sqlBuilder.append("     A0.HOSPITAL_CODE,      			");
		sqlBuilder.append("     A0.UNIT,               			");
		sqlBuilder.append("     A0.FIRM_NAME,          			");
		sqlBuilder.append("     A0.ID_EMP_HANDLE,      			");
		sqlBuilder.append("     A0.DT_HANDLE,          			");
		sqlBuilder.append("     A0.STR_EFFECTIVE,      			");
		sqlBuilder.append("     A0.PY_CODE,            			");
		sqlBuilder.append("     A0.WB_CODE,            			");
		sqlBuilder.append("     A0.ZDY_CODE,           			");
		sqlBuilder.append("     A0.STR_PRC_DRUGLIST,   			");
		sqlBuilder.append("     A0.STR_PRC_B_DRUGLIST, 			");
		sqlBuilder.append("     A0.STR_RESIDENT_USE,   			");
		sqlBuilder.append("     A0.CODE,               			");
		sqlBuilder.append("     A0.NAME,               			");
		sqlBuilder.append("     A0.CODE_CA,            			");
		sqlBuilder.append("     A0.NAME_CA,            			");
		sqlBuilder.append("     A0.SD_HPSRVTP,         			");
		sqlBuilder.append("     A0.PRI_MAX,            			");
		sqlBuilder.append("     A0.RETIRE_EY_PRI_MAX,  			");
		sqlBuilder.append("     A0.NOTE,               			");
		sqlBuilder.append("     A0.DES,                			");
		sqlBuilder.append("     A0.DT_B,               			");
		sqlBuilder.append("     A0.DT_E,               			");
		sqlBuilder.append("     A0.RATE_SELF_OEP,      			");
		sqlBuilder.append("     A0.RATE_SELF_IP,       			");
		sqlBuilder.append("     A0.RATE_RETIRE,        			");
		sqlBuilder.append("     A0.RATE_INJURY,        			");
		sqlBuilder.append("     A0.RATE_BIRTH,         			");
		sqlBuilder.append("     A0.RATE_EY,            			");
		sqlBuilder.append("     A0.RATE_UNIT,          			");
		sqlBuilder.append("     A0.RATE_FAMILY,        			");
		sqlBuilder.append("     A0.RATE_IMPORT_DIFF,   			");
		sqlBuilder.append("     A1.ID_TREATREC AS PRETREATREC		");
		sqlBuilder.append("   FROM BD_ANMEDI_TREAT_REC A0		");
		sqlBuilder.append("   LEFT JOIN BD_ANMEDI_TREAT_REC A1		");
		sqlBuilder.append("   ON A1.ID_DOWN = ?	");
		sqlBuilder.append(" AND ((A0.CODE            IS NULL		       ");
		sqlBuilder.append(" AND A1.CODE              IS NULL)		       ");
		sqlBuilder.append(" OR (A0.CODE               = A1.CODE ))	       ");
		sqlBuilder.append(" AND ((A0.NAME            IS NULL		       ");
		sqlBuilder.append(" AND A1.NAME              IS NULL)		       ");
		sqlBuilder.append(" OR (A0.NAME               = A1.NAME ))	       ");
		sqlBuilder.append("   )						");

		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" AND ID_DOWN = ? AND PRETREATREC IS NULL");
		return wherePartBuilder.toString();
	}
}
