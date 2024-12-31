package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEnDiag4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetEnDiag4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
		if (billNos == null && billNos.length == 0)
			throw new BizException("请录入发票单号！");
		if (StringUtil.isEmpty(codePat))
			throw new BizException("请录入患者编码！");
		this.billNos = billNos;
		this.codePat = codePat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(codePat);
		for (String string : billNos) {
			param.addParam(string);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT ");
		sql.append(" ENT.CODE VISIT_NO"); //就诊号
		sql.append(" ,PAT.CODE PID"); //患者ID
//		sql.append(" --DIAG_SORTNO"); //诊断序号
//		sql.append(" --DIAG_CAT"); //诊断分类
//		sql.append(" --DIAG_TYPE"); //诊断类型
		sql.append(" ,CIDITM.id_didef_code DIAG_CODE"); //诊断icd
		sql.append(" ,CIDITM.id_didef_code CUSTOM_CODE"); //自定义code
		sql.append(" ,CIDITM.supplement  VALUE_ST_TXT"); //诊断文本
		sql.append(" ,CIDITM.fg_majdi ISMAIN"); //是否主诊断
		sql.append(" ,CIDITM.fg_chronic ISINFECTIOUS"); //是否传染病
		sql.append(" ,CIDITM.fg_chronic ISCHRONIC"); //是否慢性病
		sql.append(" ,CIDITM.fg_special ISSPECIAL"); //是否特种病
		sql.append(" ,CIDITM.id_didef_name DiagnosisName");//诊断名称
		sql.append(" ,PSNDOC.code DOCTORCODE"); //诊断医生
		sql.append(" ,PSNDOC.NAME DOCTORNAME"); //诊断医生姓名
		sql.append(" ,CIDI.dt_sign DIAG_DATE"); //诊断时间
		sql.append(" ,CIDITM.id_didef_code diagnosisId"); //诊断编码
		sql.append(" FROM EN_ENT ENT ");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON ENT.ID_ENT=STOEP.ID_ENT ");
		sql.append(" INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append(" INNER JOIN CI_DI CIDI ON CIDI.ID_EN=ENT.ID_ENT ");
		sql.append(" LEFT JOIN CI_DI_ITM CIDITM ON CIDI.ID_DI=CIDITM.ID_DI ");
		sql.append(" LEFT JOIN BD_PSNDOC PSNDOC ON PSNDOC.ID_PSNDOC = CIDI.id_emp_sign ");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=ENT.ID_PAT ");
		sql.append(" WHERE PAT.code=? ");
		sql.append(" AND INCOEP.INCNO in (");
		for (int i = 0; i < billNos.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		return sql.toString();
	}
}