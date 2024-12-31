package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetHisBlOrEn4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetHisBlOrEn4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
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
		sql.append(" SELECT ");
		sql.append(" BLSEL.HISTRADENO,");
		sql.append(" BLSEL.REGION_CODE,");
		sql.append(" BLSEL.ORGANIZATION_GROUP,");
		sql.append(" BLSEL.ORGANIZATION_ID,");
		sql.append(" BLSEL.ORGANIZATION_ID,");
		sql.append(" BLSEL.PID,");
		sql.append(" BLSEL.PATIENTNAME,");
		sql.append(" BLSEL.ACCOUNTS_TYPE,");
		sql.append(" BLSEL.COST,");
		sql.append(" BLSEL.SOCIAL_SECURITY,");
		sql.append(" BLSEL.COMMERCIAL_INSURANCE,");
		sql.append(" BLSEL.OTHERS,");
		sql.append(" BLSEL.HOSPITAL,");
		sql.append(" BLSEL.PERSONAL_PAYMENT-BLSEL.COMMERCIAL_INSURANCE-BLSEL.HOSPITAL PERSONAL_PAYMENT,");
		sql.append(" BLSEL.HISFEENO,");
		sql.append(" BLSEL.CHARGE_OPERA,");
		sql.append(" BLSEL.CHARGE_OPERA_NM,");
		sql.append(" BLSEL.CHARGEDATE,");
		sql.append(" BLSEL.YBTRADENO");
		sql.append(" FROM");
		sql.append(" (");
		sql.append(" SELECT");
		sql.append(" STOEP.CODE_ST HISTRADENO");// HIS交易流水号
		sql.append(" ,'110' REGION_CODE"); // 结算地区代码
		sql.append(" ,'110' ORGANIZATION_GROUP"); // 结算医疗集团
		sql.append(" ,ORG.code ORGANIZATION_ID"); // 医疗机构代码
		sql.append(" ,PAT.CODE PID"); // 患者ID
		sql.append(" ,PAT.NAME PATIENTNAME"); // 患者姓名
		sql.append(" ,case STOEP.EU_STTP when '30' then NVL2 ( AROEP.CODE_HP, 	'mz_yb', 'mz_zf') WHEN '31' THEN NVL2 ( AROEP.CODE_HP, 	'gh_yb', 'gh_zf') ELSE '' END  ACCOUNTS_TYPE "); // 结算类型
		sql.append(" ,STOEP.AMT COST"); // 总费用
		sql.append(" ,STOEP.AMT_HP SOCIAL_SECURITY"); // 社保承担
		sql.append(" ,(SELECT NVL(SUM(AMT),0) FROM BL_PAY_ITM_PAT_OEP WHERE SD_PM='17' AND ID_PAYPATOEP=STOEP.ID_PAYPATOEP) COMMERCIAL_INSURANCE"); // 商保承担
		sql.append(" ,'0' OTHERS"); // 第三方承担
		sql.append(" ,(SELECT NVL(SUM(AMT),0) FROM BL_PAY_ITM_PAT_OEP WHERE SD_PM IN ('15','16') AND ID_PAYPATOEP=STOEP.ID_PAYPATOEP) HOSPITAL"); // 医院减免
		sql.append(" ,STOEP.AMT_RATIO-STOEP.AMT_HP PERSONAL_PAYMENT"); // 个人支付
		sql.append(" ,INCOEP.INCNO HISFEENO"); // HIS收费单据号
		sql.append(" ,PDOC.CODE CHARGE_OPERA"); // 收费员
		sql.append(" ,PDOC.NAME CHARGE_OPERA_NM"); // 收费员姓名
		sql.append(" ,STOEP.DT_ST CHARGEDATE"); // 收费时间
		sql.append(" ,'' ybtradeno	");//--医保交易流水号
		sql.append(" FROM BL_ST_OEP STOEP");
		sql.append(" INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP");
		sql.append(" INNER JOIN BD_PSNDOC PDOC ON PDOC.ID_PSNDOC=STOEP.ID_EMP_ST");
		sql.append(" INNER JOIN BD_ORG ORG ON ORG.ID_ORG=STOEP.ID_ORG");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=STOEP.ID_PAT");
		sql.append(" LEFT JOIN BL_PROP_OEP POEP ON POEP.ID_STOEP=STOEP.ID_STOEP");
		sql.append(" LEFT JOIN BL_PROP_AR_OEP AROEP ON AROEP.ID_PROPOEP=POEP.ID_PROPOEP");
		sql.append(" WHERE PAT.code=? ");
		sql.append(" AND INCOEP.INCNO in (");
		for (int i = 0; i < billNos.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		sql.append(" )BLSEL");
		return sql.toString();
	}
}
