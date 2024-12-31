package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlCc4CmlInsDTOQry  implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetBlCc4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
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
		sql.append(" STOEP.CODE_ST HISTRADENO"); //HIS交易流水号
		sql.append(" ,PAT.CODE PID"); //患者ID
//		sql.append(" --BXJSID"); //保险结算ID
//		sql.append(" --JS_BILL_CODE_BZ"); //账单码标准
//		sql.append(" --JS_BILL_CODE"); //账单码
//		sql.append(" --JS_BILL_VALUE"); //账单值
		sql.append(" FROM BL_ST_OEP STOEP");
		sql.append(" INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=STOEP.ID_PAT");
		
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
