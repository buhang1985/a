package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetHisBlSt4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetHisBlSt4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
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
		sql.append(" SELECT PAT.CODE PID,STOEP.CODE_ST HISTRADENO,ENT.CODE VISIT_NO,PAT.NAME PATIENTNAME FROM BL_INC_OEP INCOEP");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=INCOEP.ID_PAT");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON STOEP.ID_STOEP=INCOEP.ID_STOEP");
		sql.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=STOEP.ID_ENT");
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