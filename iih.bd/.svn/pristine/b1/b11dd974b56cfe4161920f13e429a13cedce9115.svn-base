package iih.bd.pp.anhuiinsur.bgtasks.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保药品个数差异SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedIDrugCountDiffSql implements ITransQry {

	private MedInsurRecDiffDO _recDiff;
	private Integer _diffType;

	public FindMedIDrugCountDiffSql(MedInsurRecDiffDO recDiff, Integer diffType) {
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
		sqlBuilder.append(" SELECT *					      ");
		sqlBuilder.append(" FROM					      ");
		sqlBuilder.append("   (SELECT ? AS EU_DIFFTYPE,			      ");
		sqlBuilder.append("     A0.ID_GRP,				      ");
		sqlBuilder.append("     A0.ID_ORG,				      ");
		sqlBuilder.append("     A0.ID_DOWN,				      ");
		sqlBuilder.append("     A0.NAME_ENGLISH,			      ");
		sqlBuilder.append("     A0.DRUG_TYPE,				      ");
		sqlBuilder.append("     A0.STR_OCT,				      ");
		sqlBuilder.append("     A0.DRUG_GRADE,				      ");
		sqlBuilder.append("     A0.DOSE_UNIT,				      ");
		sqlBuilder.append("     A0.DOSAGE,				      ");
		sqlBuilder.append("     A0.SINGLE_DOSE,				      ");
		sqlBuilder.append("     A0.FREQ,				      ");
		sqlBuilder.append("     A0.USAGE,				      ");
		sqlBuilder.append("     A0.SPEC,				      ");
		sqlBuilder.append("     A0.UNIT,				      ");
		sqlBuilder.append("     A0.AMT_PREPAY_MAX,			      ");
		sqlBuilder.append("     A0.STR_PREP_SELF,			      ");
		sqlBuilder.append("     A0.HOSPITAL_CODE,			      ");
		sqlBuilder.append("     A0.STR_APPROVE,				      ");
		sqlBuilder.append("     A0.MIN_HOSPITAL_RANK,			      ");
		sqlBuilder.append("     A0.MIN_DOCTOR_RANK,			      ");
		sqlBuilder.append("     A0.STR_ADD_INSUR,			      ");
		sqlBuilder.append("     A0.STR_ADD_INSUR_SAL,			      ");
		sqlBuilder.append("     A0.STR_BIDDING_DRUG,			      ");
		sqlBuilder.append("     A0.BIDDING_PRICE,			      ");
		sqlBuilder.append("     A0.STR_SPEC_DRUG,			      ");
		sqlBuilder.append("     A0.STR_TWO_INSURPAY,			      ");
		sqlBuilder.append("     A0.DRUG_NAME,				      ");
		sqlBuilder.append("     A0.DRUG_NAME_PRICE,			      ");
		sqlBuilder.append("     A0.DRUG_NAME_PYCODE,			      ");
		sqlBuilder.append("     A0.DRUG_NAME_WBCODE,			      ");
		sqlBuilder.append("     A0.PHARM_FIRM_NAME,			      ");
		sqlBuilder.append("     A0.PRC_DRUG_CERTI,			      ");
		sqlBuilder.append("     A0.ID_EMP_HANDLE,			      ");
		sqlBuilder.append("     A0.DT_HANDLE,				      ");
		sqlBuilder.append("     A0.PRC_DIREC_CODE,			      ");
		sqlBuilder.append("     A0.REFERENCE_PRICE,			      ");
		sqlBuilder.append("     A0.REFERENCE_HOSPITAL,			      ");
		sqlBuilder.append("     A0.ORIGIN_PLACE,			      ");
		sqlBuilder.append("     A0.STR_EFFECTIVE,			      ");
		sqlBuilder.append("     A0.STR_PRC_B_DRUGLIST,			      ");
		sqlBuilder.append("     A0.STR_RESIDENT_USE,			      ");
		sqlBuilder.append("     A0.SEX_LIMIT_PAY,			      ");
		sqlBuilder.append("     A0.DISEASE_LIMIT_PAY,			      ");
		sqlBuilder.append("     A0.PY_CODE,				      ");
		sqlBuilder.append("     A0.WB_CODE,				      ");
		sqlBuilder.append("     A0.ZDY_CODE,				      ");
		sqlBuilder.append("     A0.STR_PRC_DRUGLIST,			      ");
		sqlBuilder.append("     A0.MAX_USE_DAYS,			      ");
		sqlBuilder.append("     A0.CODE,				      ");
		sqlBuilder.append("     A0.NAME,				      ");
		sqlBuilder.append("     A0.CODE_CA,				      ");
		sqlBuilder.append("     A0.NAME_CA,				      ");
		sqlBuilder.append("     A0.SD_HPSRVTP,				      ");
		sqlBuilder.append("     A0.PRI_MAX,				      ");
		sqlBuilder.append("     A0.RETIRE_EY_PRI_MAX,			      ");
		sqlBuilder.append("     A0.DES,					      ");
		sqlBuilder.append("     A0.DT_B,				      ");
		sqlBuilder.append("     A0.DT_E,				      ");
		sqlBuilder.append("     A0.RATE_SELF_OEP,			      ");
		sqlBuilder.append("     A0.RATE_SELF_IP,			      ");
		sqlBuilder.append("     A0.RATE_RETIRE,				      ");
		sqlBuilder.append("     A0.RATE_INJURY,				      ");
		sqlBuilder.append("     A0.RATE_BIRTH,				      ");
		sqlBuilder.append("     A0.RATE_EY,				      ");
		sqlBuilder.append("     A0.RATE_UNIT,				      ");
		sqlBuilder.append("     A0.RATE_FAMILY,				      ");
		sqlBuilder.append("     A0.RATE_IMPORT_DIFF,			      ");
		sqlBuilder.append("     A0.NOTE,				      ");
		sqlBuilder.append("     A1.ID_DRUGREC AS PREDRUGREC			");
		sqlBuilder.append("   FROM BD_ANMEDI_DRUG_REC A0		      ");
		sqlBuilder.append("   LEFT JOIN BD_ANMEDI_DRUG_REC A1		      ");
		sqlBuilder.append("   ON A1.ID_DOWN          = ?		      ");
		sqlBuilder.append(" AND ((A0.CODE            IS NULL		       ");
		sqlBuilder.append(" AND A1.CODE              IS NULL)		       ");
		sqlBuilder.append(" OR (A0.CODE               = A1.CODE ))	       ");
		sqlBuilder.append(" AND ((A0.NAME            IS NULL		       ");
		sqlBuilder.append(" AND A1.NAME              IS NULL)		       ");
		sqlBuilder.append(" OR (A0.NAME               = A1.NAME ))	       ");
		sqlBuilder.append(" AND ((A0.DOSAGE          IS NULL		       ");
		sqlBuilder.append(" AND A1.DOSAGE            IS NULL)		       ");
		sqlBuilder.append(" OR (A0.DOSAGE             = A1.DOSAGE ))	       ");
		sqlBuilder.append(" AND ((A0.PHARM_FIRM_NAME IS NULL		       ");
		sqlBuilder.append(" AND A1.PHARM_FIRM_NAME   IS NULL)		       ");
		sqlBuilder.append(" OR (A0.PHARM_FIRM_NAME    = A1.PHARM_FIRM_NAME ))  ");
		sqlBuilder.append(" AND ((A0.PRC_DRUG_CERTI  IS NULL		       ");
		sqlBuilder.append(" AND A1.PRC_DRUG_CERTI    IS NULL)		       ");
		sqlBuilder.append(" OR (A0.PRC_DRUG_CERTI     = A1.PRC_DRUG_CERTI ))   ");
		sqlBuilder.append(" AND ((A0.PRC_DIREC_CODE  IS NULL		       ");
		sqlBuilder.append(" AND A1.PRC_DIREC_CODE    IS NULL)		       ");
		sqlBuilder.append(" OR (A0.PRC_DIREC_CODE     = A1.PRC_DIREC_CODE ))   ");
		sqlBuilder.append("   )						      ");
		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" AND ID_DOWN   = ?	AND PREDRUGREC IS NULL ");
		return wherePartBuilder.toString();
	}
}
