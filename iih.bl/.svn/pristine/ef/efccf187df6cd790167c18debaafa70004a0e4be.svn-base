package iih.bl.pay.s.ep;

import iih.bl.comm.IBlConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;


/**
 * 预交金EP
 * @author ly 2018/07/19
 *
 */
public class PrepayPatEP {

	/**
	 * 查询某种支付方式预交金汇总金额
	 * @param pmId
	 * @return
	 * @throws BizException
	 */
	public FDouble getPrepayByPm(String pmId, String idPk, String accTp) throws BizException {
	
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select sum(eu_direct * amt) ");
		sqlSb.append("from bl_prepay_pat ");
		
		switch (accTp) {
		case IBlConst.PREPAY_OPACC:
			sqlSb.append("where id_pat = ? ");
			sqlSb.append("and (code_enttp = '00' or code_enttp = '01') ");
			break;
		case IBlConst.PREPAY_IPACC:
			sqlSb.append("where id_ent = ? ");
			break;
		case IBlConst.PREPAY_PEACC:
			sqlSb.append("where id_pecmpy = ? ");
			break;
		}
		
		sqlSb.append("and id_pm = ? ");
			
		SqlParam param = new SqlParam();
		param.addParam(idPk);
		param.addParam(pmId);
		
		DAFacade daf = new DAFacade();
		Object prepay = daf.execQuery(sqlSb.toString(), param, new ColumnHandler());
		
		if(prepay == null)
			return FDouble.ZERO_DBL;
		
		return (FDouble)FTypeManager.convert2FType(FType.FDouble, prepay);
	}
}
