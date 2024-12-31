package iih.bl.cg.s.bp.ip;

import iih.bl.cg.s.bp.ip.qry.GetUnstopPrnOrdQry;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
/*
 *获取未停止的持续医嘱数量
 *
 */
public class BlGetUnstopPrnOrdBP {
	public Integer exec(String patId) throws DAException{
		GetUnstopPrnOrdQry qry= new GetUnstopPrnOrdQry(patId);
		Integer count = (Integer) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new ColumnHandler());
		return count;
	}
}
