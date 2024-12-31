package iih.bd.pp.anhuiinsur.bgtasks.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保诊疗数据差异SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedITreatDataDiffSql implements ITransQry {
	private MedInsurRecDiffDO _recDiff;
	private Integer _diffType;

	public FindMedITreatDataDiffSql(MedInsurRecDiffDO recDiff, Integer diffType) {
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
		sqlBuilder.append(" SELECT ? AS EU_DIFFTYPE,				     ");
		sqlBuilder.append("   A0.ID_GRP,					     ");
		sqlBuilder.append("   A0.ID_ORG,					     ");
		sqlBuilder.append("   A0.ID_DOWN,					     ");
		sqlBuilder.append("   A0.PAY_SELF_TP,					     ");
		sqlBuilder.append("   A0.STR_APPROVE,					     ");
		sqlBuilder.append("   A0.STR_TWO_INSURPAY,				     ");
		sqlBuilder.append("   A0.STR_ADD_INSUR,					     ");
		sqlBuilder.append("   A0.STR_ADD_INSUR_SAL,				     ");
		sqlBuilder.append("   A0.STR_SPECIAL_ITM,				     ");
		sqlBuilder.append("   A0.ORIGIN_PLACE,					     ");
		sqlBuilder.append("   A0.AMT_PREPAY_MAX,				     ");
		sqlBuilder.append("   A0.DOMESTIC_PRI_MAX,				     ");
		sqlBuilder.append("   A0.STR_HOSPITAL_HELP,				     ");
		sqlBuilder.append("   A0.HOSPITAL_CODE,					     ");
		sqlBuilder.append("   A0.UNIT,						     ");
		sqlBuilder.append("   A0.FIRM_NAME,					     ");
		sqlBuilder.append("   A0.ID_EMP_HANDLE,					     ");
		sqlBuilder.append("   A0.DT_HANDLE,					     ");
		sqlBuilder.append("   A0.STR_EFFECTIVE,					     ");
		sqlBuilder.append("   A0.PY_CODE,					     ");
		sqlBuilder.append("   A0.WB_CODE,					     ");
		sqlBuilder.append("   A0.ZDY_CODE,					     ");
		sqlBuilder.append("   A0.STR_PRC_DRUGLIST,				     ");
		sqlBuilder.append("   A0.STR_PRC_B_DRUGLIST,				     ");
		sqlBuilder.append("   A0.STR_RESIDENT_USE,				     ");
		sqlBuilder.append("   A0.CODE,						     ");
		sqlBuilder.append("   A0.NAME,						     ");
		sqlBuilder.append("   A0.CODE_CA,					     ");
		sqlBuilder.append("   A0.NAME_CA,					     ");
		sqlBuilder.append("   A0.SD_HPSRVTP,					     ");
		sqlBuilder.append("   A0.PRI_MAX,					     ");
		sqlBuilder.append("   A0.RETIRE_EY_PRI_MAX,				     ");
		sqlBuilder.append("   A0.NOTE,						     ");
		sqlBuilder.append("   A0.DES,						     ");
		sqlBuilder.append("   A0.DT_B,						     ");
		sqlBuilder.append("   A0.DT_E,						     ");
		sqlBuilder.append("   A0.RATE_SELF_OEP,					     ");
		sqlBuilder.append("   A0.RATE_SELF_IP,					     ");
		sqlBuilder.append("   A0.RATE_RETIRE,					     ");
		sqlBuilder.append("   A0.RATE_INJURY,					     ");
		sqlBuilder.append("   A0.RATE_BIRTH,					     ");
		sqlBuilder.append("   A0.RATE_EY,					     ");
		sqlBuilder.append("   A0.RATE_UNIT,					     ");
		sqlBuilder.append("   A0.RATE_FAMILY,					     ");
		sqlBuilder.append("   A0.RATE_IMPORT_DIFF				     ");
		sqlBuilder.append(" FROM BD_ANMEDI_TREAT_REC A0				     ");
		sqlBuilder.append(" INNER JOIN BD_ANMEDI_TREAT_REC A1			     ");
		sqlBuilder.append(" ON A0.ID_DOWN               = ?			     ");
		sqlBuilder.append(" AND A1.ID_DOWN              = ?			     ");
		sqlBuilder.append(" AND ((A0.CODE              IS NULL			     ");
		sqlBuilder.append(" AND A1.CODE                IS NULL)			     ");
		sqlBuilder.append(" OR (A0.CODE                 = A1.CODE ))		     ");
		sqlBuilder.append(" AND ((A0.NAME              IS NULL			     ");
		sqlBuilder.append(" AND A1.NAME                IS NULL)			     ");
		sqlBuilder.append(" OR (A0.NAME                 = A1.NAME ))		     ");
		sqlBuilder.append(" AND ( (A0.PAY_SELF_TP      IS NULL			     ");
		sqlBuilder.append(" AND A1.PAY_SELF_TP         IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.PAY_SELF_TP         IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.PAY_SELF_TP         IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.PAY_SELF_TP        <> A1.PAY_SELF_TP )	     ");
		sqlBuilder.append(" OR (A0.STR_APPROVE         IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_APPROVE         IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_APPROVE         IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_APPROVE         IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_APPROVE        <> A1.STR_APPROVE )	     ");
		sqlBuilder.append(" OR (A0.STR_TWO_INSURPAY    IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_TWO_INSURPAY    IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_TWO_INSURPAY    IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_TWO_INSURPAY    IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_TWO_INSURPAY   <> A1.STR_TWO_INSURPAY )	     ");
		sqlBuilder.append(" OR (A0.STR_ADD_INSUR       IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_ADD_INSUR       IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_ADD_INSUR       IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_ADD_INSUR       IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_ADD_INSUR      <> A1.STR_ADD_INSUR )	     ");
		sqlBuilder.append(" OR (A0.STR_ADD_INSUR_SAL   IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_ADD_INSUR_SAL   IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_ADD_INSUR_SAL   IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_ADD_INSUR_SAL   IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_ADD_INSUR_SAL  <> A1.STR_ADD_INSUR_SAL )     ");
		sqlBuilder.append(" OR (A0.STR_SPECIAL_ITM     IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_SPECIAL_ITM     IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_SPECIAL_ITM     IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_SPECIAL_ITM     IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_SPECIAL_ITM    <> A1.STR_SPECIAL_ITM )	     ");
		sqlBuilder.append(" OR (A0.ORIGIN_PLACE        IS NULL			     ");
		sqlBuilder.append(" AND A1.ORIGIN_PLACE        IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.ORIGIN_PLACE        IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.ORIGIN_PLACE        IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.ORIGIN_PLACE       <> A1.ORIGIN_PLACE )	     ");
		sqlBuilder.append(" OR (A0.AMT_PREPAY_MAX      IS NULL			     ");
		sqlBuilder.append(" AND A1.AMT_PREPAY_MAX      IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.AMT_PREPAY_MAX      IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.AMT_PREPAY_MAX      IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.AMT_PREPAY_MAX     <> A1.AMT_PREPAY_MAX )	     ");
		sqlBuilder.append(" OR (A0.DOMESTIC_PRI_MAX    IS NULL			     ");
		sqlBuilder.append(" AND A1.DOMESTIC_PRI_MAX    IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.DOMESTIC_PRI_MAX    IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.DOMESTIC_PRI_MAX    IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.DOMESTIC_PRI_MAX   <> A1.DOMESTIC_PRI_MAX )	     ");
		sqlBuilder.append(" OR (A0.STR_HOSPITAL_HELP   IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_HOSPITAL_HELP   IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_HOSPITAL_HELP   IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_HOSPITAL_HELP   IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_HOSPITAL_HELP  <> A1.STR_HOSPITAL_HELP )     ");
		sqlBuilder.append(" OR (A0.HOSPITAL_CODE       IS NULL			     ");
		sqlBuilder.append(" AND A1.HOSPITAL_CODE       IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.HOSPITAL_CODE       IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.HOSPITAL_CODE       IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.HOSPITAL_CODE      <> A1.HOSPITAL_CODE )	     ");
		sqlBuilder.append(" OR (A0.UNIT                IS NULL			     ");
		sqlBuilder.append(" AND A1.UNIT                IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.UNIT                IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.UNIT                IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.UNIT               <> A1.UNIT )		     ");
		sqlBuilder.append(" OR (A0.FIRM_NAME           IS NULL			     ");
		sqlBuilder.append(" AND A1.FIRM_NAME           IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.FIRM_NAME           IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.FIRM_NAME           IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.FIRM_NAME          <> A1.FIRM_NAME )	     ");
		sqlBuilder.append(" OR (A0.ID_EMP_HANDLE       IS NULL			     ");
		sqlBuilder.append(" AND A1.ID_EMP_HANDLE       IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.ID_EMP_HANDLE       IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.ID_EMP_HANDLE       IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.ID_EMP_HANDLE      <> A1.ID_EMP_HANDLE )	     ");
		sqlBuilder.append(" OR (A0.DT_HANDLE           IS NULL			     ");
		sqlBuilder.append(" AND A1.DT_HANDLE           IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.DT_HANDLE           IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.DT_HANDLE           IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.DT_HANDLE          <> A1.DT_HANDLE )	     ");
		sqlBuilder.append(" OR (A0.STR_EFFECTIVE       IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_EFFECTIVE       IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_EFFECTIVE       IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_EFFECTIVE       IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_EFFECTIVE      <> A1.STR_EFFECTIVE )	     ");
		sqlBuilder.append(" OR (A0.PY_CODE             IS NULL			     ");
		sqlBuilder.append(" AND A1.PY_CODE             IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.PY_CODE             IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.PY_CODE             IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.PY_CODE            <> A1.PY_CODE )		     ");
		sqlBuilder.append(" OR (A0.WB_CODE             IS NULL			     ");
		sqlBuilder.append(" AND A1.WB_CODE             IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.WB_CODE             IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.WB_CODE             IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.WB_CODE            <> A1.WB_CODE )		     ");
		sqlBuilder.append(" OR (A0.ZDY_CODE            IS NULL			     ");
		sqlBuilder.append(" AND A1.ZDY_CODE            IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.ZDY_CODE            IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.ZDY_CODE            IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.ZDY_CODE           <> A1.ZDY_CODE )		     ");
		sqlBuilder.append(" OR (A0.STR_PRC_DRUGLIST    IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_PRC_DRUGLIST    IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_PRC_DRUGLIST    IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_PRC_DRUGLIST    IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_PRC_DRUGLIST   <> A1.STR_PRC_DRUGLIST )	     ");
		sqlBuilder.append(" OR (A0.STR_PRC_B_DRUGLIST  IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_PRC_B_DRUGLIST  IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_PRC_B_DRUGLIST  IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_PRC_B_DRUGLIST  IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_PRC_B_DRUGLIST <> A1.STR_PRC_B_DRUGLIST )    ");
		sqlBuilder.append(" OR (A0.STR_RESIDENT_USE    IS NULL			     ");
		sqlBuilder.append(" AND A1.STR_RESIDENT_USE    IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.STR_RESIDENT_USE    IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.STR_RESIDENT_USE    IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.STR_RESIDENT_USE   <> A1.STR_RESIDENT_USE )	     ");
		sqlBuilder.append(" OR (A0.CODE_CA             IS NULL			     ");
		sqlBuilder.append(" AND A1.CODE_CA             IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.CODE_CA             IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.CODE_CA             IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.CODE_CA            <> A1.CODE_CA )		     ");
		sqlBuilder.append(" OR (A0.NAME_CA             IS NULL			     ");
		sqlBuilder.append(" AND A1.NAME_CA             IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.NAME_CA             IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.NAME_CA             IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.NAME_CA            <> A1.NAME_CA )		     ");
		sqlBuilder.append(" OR (A0.SD_HPSRVTP          IS NULL			     ");
		sqlBuilder.append(" AND A1.SD_HPSRVTP          IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.SD_HPSRVTP          IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.SD_HPSRVTP          IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.SD_HPSRVTP         <> A1.SD_HPSRVTP )	     ");
		sqlBuilder.append(" OR (A0.PRI_MAX             IS NULL			     ");
		sqlBuilder.append(" AND A1.PRI_MAX             IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.PRI_MAX             IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.PRI_MAX             IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.PRI_MAX            <> A1.PRI_MAX )		     ");
		sqlBuilder.append(" OR (A0.RETIRE_EY_PRI_MAX   IS NULL			     ");
		sqlBuilder.append(" AND A1.RETIRE_EY_PRI_MAX   IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RETIRE_EY_PRI_MAX   IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RETIRE_EY_PRI_MAX   IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RETIRE_EY_PRI_MAX  <> A1.RETIRE_EY_PRI_MAX )     ");
		sqlBuilder.append(" OR (A0.NOTE                IS NULL			     ");
		sqlBuilder.append(" AND A1.NOTE                IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.NOTE                IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.NOTE                IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.NOTE               <> A1.NOTE )		     ");
		sqlBuilder.append(" OR (A0.DES                 IS NULL			     ");
		sqlBuilder.append(" AND A1.DES                 IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.DES                 IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.DES                 IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.DES                <> A1.DES )		     ");
		sqlBuilder.append(" OR (A0.DT_B                IS NULL			     ");
		sqlBuilder.append(" AND A1.DT_B                IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.DT_B                IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.DT_B                IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.DT_B               <> A1.DT_B )		     ");
		sqlBuilder.append(" OR (A0.DT_E                IS NULL			     ");
		sqlBuilder.append(" AND A1.DT_E                IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.DT_E                IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.DT_E                IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.DT_E               <> A1.DT_E )		     ");
		sqlBuilder.append(" OR (A0.RATE_SELF_OEP       IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_SELF_OEP       IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_SELF_OEP       IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_SELF_OEP       IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_SELF_OEP      <> A1.RATE_SELF_OEP )	     ");
		sqlBuilder.append(" OR (A0.RATE_SELF_IP        IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_SELF_IP        IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_SELF_IP        IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_SELF_IP        IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_SELF_IP       <> A1.RATE_SELF_IP )	     ");
		sqlBuilder.append(" OR (A0.RATE_RETIRE         IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_RETIRE         IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_RETIRE         IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_RETIRE         IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_RETIRE        <> A1.RATE_RETIRE )	     ");
		sqlBuilder.append(" OR (A0.RATE_INJURY         IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_INJURY         IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_INJURY         IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_INJURY         IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_INJURY        <> A1.RATE_INJURY )	     ");
		sqlBuilder.append(" OR (A0.RATE_BIRTH          IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_BIRTH          IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_BIRTH          IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_BIRTH          IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_BIRTH         <> A1.RATE_BIRTH )	     ");
		sqlBuilder.append(" OR (A0.RATE_EY             IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_EY             IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_EY             IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_EY             IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_EY            <> A1.RATE_EY )		     ");
		sqlBuilder.append(" OR (A0.RATE_UNIT           IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_UNIT           IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_UNIT           IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_UNIT           IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_UNIT          <> A1.RATE_UNIT )	     ");
		sqlBuilder.append(" OR (A0.RATE_FAMILY         IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_FAMILY         IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_FAMILY         IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_FAMILY         IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_FAMILY        <> A1.RATE_FAMILY )	     ");
		sqlBuilder.append(" OR (A0.RATE_IMPORT_DIFF    IS NULL			     ");
		sqlBuilder.append(" AND A1.RATE_IMPORT_DIFF    IS NOT NULL )		     ");
		sqlBuilder.append(" OR (A0.RATE_IMPORT_DIFF    IS NOT NULL		     ");
		sqlBuilder.append(" AND A1.RATE_IMPORT_DIFF    IS NULL )		     ");
		sqlBuilder.append(" OR ( A0.RATE_IMPORT_DIFF   <> A1.RATE_IMPORT_DIFF ) )    ");
		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		return wherePartBuilder.toString();
	}
}
