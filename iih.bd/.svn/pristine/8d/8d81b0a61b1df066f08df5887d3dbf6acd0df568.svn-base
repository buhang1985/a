package iih.bd.pp.anhuiinsur.bgtasks.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保服务设施个数差异SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedISrvFacCountDiffSql implements ITransQry {
	private MedInsurRecDiffDO _recDiff;
	private Integer _diffType;

	public FindMedISrvFacCountDiffSql(MedInsurRecDiffDO recDiff, Integer diffType) {
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
		sqlBuilder.append(" SELECT *				    ");
		sqlBuilder.append(" FROM				    ");
		sqlBuilder.append("   (SELECT ? AS EU_DIFFTYPE,		    ");
		sqlBuilder.append("     A0.ID_GRP,			    ");
		sqlBuilder.append("     A0.ID_ORG,			    ");
		sqlBuilder.append("     A0.ID_DOWN,			    ");
		sqlBuilder.append("     A0.STR_EFFECTIVE,		    ");
		sqlBuilder.append("     A0.HOSPITAL_RANK,		    ");
		sqlBuilder.append("     A0.HOSPITAL_BED_RANK,		    ");
		sqlBuilder.append("     A0.FWSS_PAY_STANDARD,		    ");
		sqlBuilder.append("     A0.ID_EMP_HANDLE,		    ");
		sqlBuilder.append("     A0.DT_HANDLE,			    ");
		sqlBuilder.append("     A0.PY_CODE,			    ");
		sqlBuilder.append("     A0.WB_CODE,			    ");
		sqlBuilder.append("     A0.ZDY_CODE,			    ");
		sqlBuilder.append("     A0.STR_PRC_DRUG_LIST,		    ");
		sqlBuilder.append("     A0.STR_PRC_B_DRUG_LIST,		    ");
		sqlBuilder.append("     A0.STR_RESIDENT_USE,		    ");
		sqlBuilder.append("     A0.CODE,			    ");
		sqlBuilder.append("     A0.NAME,			    ");
		sqlBuilder.append("     A0.CODE_CA,			    ");
		sqlBuilder.append("     A0.NAME_CA,			    ");
		sqlBuilder.append("     A0.SD_HPSRVTP,			    ");
		sqlBuilder.append("     A0.PRI_MAX,			    ");
		sqlBuilder.append("     A0.RETIRE_EY_PRI_MAX,		    ");
		sqlBuilder.append("     A0.DES,				    ");
		sqlBuilder.append("     A0.DT_B,			    ");
		sqlBuilder.append("     A0.DT_E,			    ");
		sqlBuilder.append("     A0.HOSPITAL_CODE,		    ");
		sqlBuilder.append("     A1.ID_SRVFACREC AS PRESRVFACREC	    ");
		sqlBuilder.append("   FROM BD_ANMEDI_SRVFAC_REC A0	    ");
		sqlBuilder.append("   LEFT JOIN BD_ANMEDI_SRVFAC_REC A1	    ");
		sqlBuilder.append("   ON A1.ID_DOWN  = ?		    ");
		sqlBuilder.append("   AND ((A0.CODE IS NULL		    ");
		sqlBuilder.append("   AND A1.CODE   IS NULL)		    ");
		sqlBuilder.append("   OR (A0.CODE    = A1.CODE ))	    ");
		sqlBuilder.append("   AND ((A0.NAME IS NULL		    ");
		sqlBuilder.append("   AND A1.NAME   IS NULL)		    ");
		sqlBuilder.append("   OR (A0.NAME    = A1.NAME ))	    ");
		sqlBuilder.append("   )					    ");
		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" AND ID_DOWN = ? AND PRESRVFACREC IS NULL");
		return wherePartBuilder.toString();
	}
}
