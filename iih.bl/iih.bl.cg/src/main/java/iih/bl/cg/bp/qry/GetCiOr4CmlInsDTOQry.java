package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCiOr4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetCiOr4CmlInsDTOQry(String[] billNos,String codePat) throws BizException {
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
		sql.append(" ,ITMOEP.ID_PRES RECIPENO"); //处方号
		sql.append(" ,PRES.SD_PRESTP RECIPE_CAT"); //处方类别
		sql.append(" ,(CASE  WHEN itmoep.code_applytp ='01' THEN  (CASE WHEN PRES.sd_prestpword LIKE  '%14%' THEN '04' ELSE ( CASE WHEN PRES.sd_prestpword LIKE '%02%' THEN '02' ELSE '10' END) END ) ELSE '01' END ) RECIPETYPE"); //处方类型
		sql.append(" ,PSNDOC.CODE DOCTORCODE"); //开方医生
		sql.append(" ,PSNDOC.NAME DOCTORNAME"); //开方医生姓名
		sql.append(" ,PRES.CREATEDTIME RECIPEDATE"); //处方时间
		sql.append(" ,STOEP.code_st histradeno"); //his交易流水号
		sql.append(" FROM EN_ENT ENT ");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=ENT.ID_PAT ");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON STOEP.ID_PAT=ENT.ID_PAT AND STOEP.ID_ENT=ENT.ID_ENT ");
		sql.append(" INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP");
		sql.append(" LEFT JOIN CI_PRES PRES ON PRES.ID_EN=ENT.ID_ENT ");
		sql.append(" LEFT JOIN BD_PSNDOC PSNDOC ON PSNDOC.ID_PSNDOC = PRES.id_emp_or ");
		sql.append(" INNER JOIN BL_CG_ITM_OEP ITMOEP ON STOEP.ID_STOEP = ITMOEP.ID_STOEP");
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
