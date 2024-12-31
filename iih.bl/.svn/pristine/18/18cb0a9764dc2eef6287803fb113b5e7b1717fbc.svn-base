package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCodePatQry implements ITransQry{

	String[] billNo;
	public GetCodePatQry(String[] billno)throws BizException {
		this.billNo=billno;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		for (String incno : billNo) {
			param.addParam(incno);
		}
		
		
		return param;
	}
	@Override
	public String getQrySQLStr() {
		
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("OEP.INCNO, ");
		sql.append("PAT.CODE ID_PAT ");
		sql.append("FROM BL_INC_OEP OEP ");
		sql.append("INNER JOIN PI_PAT  PAT ON PAT.ID_PAT=OEP.ID_PAT ");
		sql.append("WHERE OEP.INCNO IN (");
		for (int i = 0; i < billNo.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		return sql.toString();
	}
}
