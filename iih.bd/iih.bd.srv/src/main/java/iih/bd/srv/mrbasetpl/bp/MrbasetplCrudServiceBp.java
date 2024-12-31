package iih.bd.srv.mrbasetpl.bp;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class MrbasetplCrudServiceBp {

	
	public Integer getMaxVersion(String code) throws BizException {
		// TODO Auto-generated method stub
		ColumnHandler handler = new ColumnHandler();
		StringBuffer sbf=new StringBuffer();
		sbf.append("select max(ver) from bd_base_mrtpl where code='"+code+"'");
		DAFacade cade = new DAFacade();
		Integer ver = (Integer)cade.execQuery(sbf.toString(),handler);
	 
		return  ver;
	} 
}
