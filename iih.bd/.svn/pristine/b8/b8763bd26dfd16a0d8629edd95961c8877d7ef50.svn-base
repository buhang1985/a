package iih.bd.srv.s.bp;

import iih.bd.srv.d.BdSrvQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetUdidocExtend {
	public String getCtrlScope(String code) throws BizException{
		String sql="select ctrl5 from bd_udidoc where id_udidoclist='0001ZZ20000000000011' and code='"+code+"'";
		Object list=new DAFacade().execQuery(sql, new BeanListHandler(BdSrvQryDTO.class));
		return list.toString();
	}

}
