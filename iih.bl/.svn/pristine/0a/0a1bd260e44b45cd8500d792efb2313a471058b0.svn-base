package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPropArOepDOQry implements ITransQry{
	String billNo;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetBlPropArOepDOQry(String billNo, String codePat) throws BizException {
		
		this.billNo = billNo;
		this.codePat = codePat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(codePat);
		
		param.addParam(billNo);
		
		return param;
	}
	

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM BL_PROP_AR_OEP ");
		sql.append("where ");
		sql.append(" ID_PROPOEP=");
		sql.append("(SELECT ID_PROPOEP ");
		sql.append("FROM ");
		sql.append("BL_PROP_OEP PROPOEP");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON PROPOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append( "INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT=STOEP.ID_PAT");
		sql.append( " WHERE PAT.CODE=?");
		sql.append(" AND INCOEP.INCNO=?)");
		
		return sql.toString();
	}
}
