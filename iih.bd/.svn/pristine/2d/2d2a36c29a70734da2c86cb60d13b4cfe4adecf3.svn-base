package iih.bd.pp.anhuiinsur.bgtasks.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保服务设施数据差异SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedISrvFacDataDiffSql implements ITransQry {
	private MedInsurRecDiffDO _recDiff;
	private Integer _diffType;

	public FindMedISrvFacDataDiffSql(MedInsurRecDiffDO recDiff, Integer diffType) {
		this._recDiff = recDiff;
		this._diffType = diffType;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._diffType);
		if (this._diffType.equals(AHMedIRecDiffType.AFTERMODIFY)) {
			sqlParam.addParam(this._recDiff.getId_curdown());
			sqlParam.addParam(this._recDiff.getId_predown());
		}
		if (this._diffType.equals(AHMedIRecDiffType.BEFOREMODIFY)) {
			sqlParam.addParam(this._recDiff.getId_predown());
			sqlParam.addParam(this._recDiff.getId_curdown());
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
		sqlBuilder.append(" SELECT ? AS EU_DIFFTYPE,					  ");
		sqlBuilder.append("   a0.ID_GRP,						  ");
		sqlBuilder.append("   a0.ID_ORG,						  ");
		sqlBuilder.append("   a0.ID_DOWN,						  ");
		sqlBuilder.append("   a0.STR_EFFECTIVE,						  ");
		sqlBuilder.append("   a0.HOSPITAL_RANK,						  ");
		sqlBuilder.append("   a0.HOSPITAL_BED_RANK,					  ");
		sqlBuilder.append("   a0.FWSS_PAY_STANDARD,					  ");
		sqlBuilder.append("   a0.ID_EMP_HANDLE,						  ");
		sqlBuilder.append("   a0.DT_HANDLE,						  ");
		sqlBuilder.append("   a0.PY_CODE,						  ");
		sqlBuilder.append("   a0.WB_CODE,						  ");
		sqlBuilder.append("   a0.ZDY_CODE,						  ");
		sqlBuilder.append("   a0.STR_PRC_DRUG_LIST,					  ");
		sqlBuilder.append("   a0.STR_PRC_B_DRUG_LIST,					  ");
		sqlBuilder.append("   a0.STR_RESIDENT_USE,					  ");
		sqlBuilder.append("   a0.CODE,							  ");
		sqlBuilder.append("   a0.NAME,							  ");
		sqlBuilder.append("   a0.CODE_CA,						  ");
		sqlBuilder.append("   a0.NAME_CA,						  ");
		sqlBuilder.append("   a0.SD_HPSRVTP,						  ");
		sqlBuilder.append("   a0.PRI_MAX,						  ");
		sqlBuilder.append("   a0.RETIRE_EY_PRI_MAX,					  ");
		sqlBuilder.append("   a0.DES,							  ");
		sqlBuilder.append("   a0.DT_B,							  ");
		sqlBuilder.append("   a0.DT_E,							  ");
		sqlBuilder.append("   a0.HOSPITAL_CODE						  ");
		sqlBuilder.append(" FROM BD_ANMEDI_SRVFAC_REC a0				  ");
		sqlBuilder.append(" INNER JOIN BD_ANMEDI_SRVFAC_REC a1				  ");
		sqlBuilder.append(" ON A0.ID_DOWN               = ?				  ");
		sqlBuilder.append(" AND A1.ID_DOWN              = ?				  ");
		sqlBuilder.append(" AND ((A0.CODE              IS NULL				  ");
		sqlBuilder.append(" AND A1.CODE                IS NULL)				  ");
		sqlBuilder.append(" OR (A0.CODE                 = A1.CODE ))			  ");
		sqlBuilder.append(" AND ((A0.NAME              IS NULL				  ");
		sqlBuilder.append(" AND A1.NAME                IS NULL)				  ");
		sqlBuilder.append(" OR (A0.NAME                 = A1.NAME ))			  ");
		sqlBuilder.append(" AND ( (a0.STR_EFFECTIVE    IS NULL				  ");
		sqlBuilder.append(" AND a1.STR_EFFECTIVE       IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_EFFECTIVE       IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.STR_EFFECTIVE       IS NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_EFFECTIVE       <> a1.STR_EFFECTIVE )		  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_RANK       IS NULL				  ");
		sqlBuilder.append(" AND a1.HOSPITAL_RANK       IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_RANK       IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.HOSPITAL_RANK       IS NULL )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_RANK       <> a1.HOSPITAL_RANK )		  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_BED_RANK   IS NULL				  ");
		sqlBuilder.append(" AND a1.HOSPITAL_BED_RANK   IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_BED_RANK   IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.HOSPITAL_BED_RANK   IS NULL )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_BED_RANK   <> a1.HOSPITAL_BED_RANK )	  ");
		sqlBuilder.append(" OR (a0.FWSS_PAY_STANDARD   IS NULL				  ");
		sqlBuilder.append(" AND a1.FWSS_PAY_STANDARD   IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.FWSS_PAY_STANDARD   IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.FWSS_PAY_STANDARD   IS NULL )			  ");
		sqlBuilder.append(" OR (a0.FWSS_PAY_STANDARD   <> a1.FWSS_PAY_STANDARD )	  ");
		sqlBuilder.append(" OR (a0.ID_EMP_HANDLE       IS NULL				  ");
		sqlBuilder.append(" AND a1.ID_EMP_HANDLE       IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.ID_EMP_HANDLE       IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.ID_EMP_HANDLE       IS NULL )			  ");
		sqlBuilder.append(" OR (a0.ID_EMP_HANDLE       <> a1.ID_EMP_HANDLE )		  ");
		sqlBuilder.append(" OR (a0.DT_HANDLE           IS NULL				  ");
		sqlBuilder.append(" AND a1.DT_HANDLE           IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.DT_HANDLE           IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.DT_HANDLE           IS NULL )			  ");
		sqlBuilder.append(" OR (a0.DT_HANDLE           <> a1.DT_HANDLE )		  ");
		sqlBuilder.append(" OR (a0.PY_CODE             IS NULL				  ");
		sqlBuilder.append(" AND a1.PY_CODE             IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.PY_CODE             IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.PY_CODE             IS NULL )			  ");
		sqlBuilder.append(" OR (a0.PY_CODE             <> a1.PY_CODE )			  ");
		sqlBuilder.append(" OR (a0.WB_CODE             IS NULL				  ");
		sqlBuilder.append(" AND a1.WB_CODE             IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.WB_CODE             IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.WB_CODE             IS NULL )			  ");
		sqlBuilder.append(" OR (a0.WB_CODE             <> a1.WB_CODE )			  ");
		sqlBuilder.append(" OR (a0.ZDY_CODE            IS NULL				  ");
		sqlBuilder.append(" AND a1.ZDY_CODE            IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.ZDY_CODE            IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.ZDY_CODE            IS NULL )			  ");
		sqlBuilder.append(" OR (a0.ZDY_CODE            <> a1.ZDY_CODE )			  ");
		sqlBuilder.append(" OR (a0.STR_PRC_DRUG_LIST   IS NULL				  ");
		sqlBuilder.append(" AND a1.STR_PRC_DRUG_LIST   IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_PRC_DRUG_LIST   IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.STR_PRC_DRUG_LIST   IS NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_PRC_DRUG_LIST   <> a1.STR_PRC_DRUG_LIST )	  ");
		sqlBuilder.append(" OR (a0.STR_PRC_B_DRUG_LIST IS NULL				  ");
		sqlBuilder.append(" AND a1.STR_PRC_B_DRUG_LIST IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_PRC_B_DRUG_LIST IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.STR_PRC_B_DRUG_LIST IS NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_PRC_B_DRUG_LIST <> a1.STR_PRC_B_DRUG_LIST )	  ");
		sqlBuilder.append(" OR (a0.STR_RESIDENT_USE    IS NULL				  ");
		sqlBuilder.append(" AND a1.STR_RESIDENT_USE    IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_RESIDENT_USE    IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.STR_RESIDENT_USE    IS NULL )			  ");
		sqlBuilder.append(" OR (a0.STR_RESIDENT_USE    <> a1.STR_RESIDENT_USE )		  ");
		sqlBuilder.append(" OR (a0.CODE_CA             IS NULL				  ");
		sqlBuilder.append(" AND a1.CODE_CA             IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.CODE_CA             IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.CODE_CA             IS NULL )			  ");
		sqlBuilder.append(" OR (a0.CODE_CA             <> a1.CODE_CA )			  ");
		sqlBuilder.append(" OR (a0.NAME_CA             IS NULL				  ");
		sqlBuilder.append(" AND a1.NAME_CA             IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.NAME_CA             IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.NAME_CA             IS NULL )			  ");
		sqlBuilder.append(" OR (a0.NAME_CA             <> a1.NAME_CA )			  ");
		sqlBuilder.append(" OR (a0.SD_HPSRVTP          IS NULL				  ");
		sqlBuilder.append(" AND a1.SD_HPSRVTP          IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.SD_HPSRVTP          IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.SD_HPSRVTP          IS NULL )			  ");
		sqlBuilder.append(" OR (a0.SD_HPSRVTP          <> a1.SD_HPSRVTP )		  ");
		sqlBuilder.append(" OR (a0.PRI_MAX             IS NULL				  ");
		sqlBuilder.append(" AND a1.PRI_MAX             IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.PRI_MAX             IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.PRI_MAX             IS NULL )			  ");
		sqlBuilder.append(" OR (a0.PRI_MAX             <> a1.PRI_MAX )			  ");
		sqlBuilder.append(" OR (a0.RETIRE_EY_PRI_MAX   IS NULL				  ");
		sqlBuilder.append(" AND a1.RETIRE_EY_PRI_MAX   IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.RETIRE_EY_PRI_MAX   IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.RETIRE_EY_PRI_MAX   IS NULL )			  ");
		sqlBuilder.append(" OR (a0.RETIRE_EY_PRI_MAX   <> a1.RETIRE_EY_PRI_MAX )	  ");
		sqlBuilder.append(" OR (a0.DES                 IS NULL				  ");
		sqlBuilder.append(" AND a1.DES                 IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.DES                 IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.DES                 IS NULL )			  ");
		sqlBuilder.append(" OR (a0.DES                 <> a1.DES )			  ");
		sqlBuilder.append(" OR (a0.DT_B                IS NULL				  ");
		sqlBuilder.append(" AND a1.DT_B                IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.DT_B                IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.DT_B                IS NULL )			  ");
		sqlBuilder.append(" OR (a0.DT_B                <> a1.DT_B )			  ");
		sqlBuilder.append(" OR (a0.DT_E                IS NULL				  ");
		sqlBuilder.append(" AND a1.DT_E                IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.DT_E                IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.DT_E                IS NULL )			  ");
		sqlBuilder.append(" OR (a0.DT_E                <> a1.DT_E )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_CODE       IS NULL				  ");
		sqlBuilder.append(" AND a1.HOSPITAL_CODE       IS NOT NULL )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_CODE       IS NOT NULL			  ");
		sqlBuilder.append(" AND a1.HOSPITAL_CODE       IS NULL )			  ");
		sqlBuilder.append(" OR (a0.HOSPITAL_CODE       <> a1.HOSPITAL_CODE ))		  ");

		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		return wherePartBuilder.toString();
	}
}
