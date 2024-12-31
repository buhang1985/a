package iih.bl.cg.service.s.bp.qry;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class OldBlPropArQry {

	public String query(String idStoep) throws BizException{
		
		StringBuilder sb=new StringBuilder();
		sb.append("select id_proparoep from bl_prop_ar_oep where id_propoep=(");
		sb.append("select id_propoep from bl_prop_oep where id_stoep='"+ idStoep +"')");

		String id= (String) new DAFacade().execQuery(sb.toString(), new ColumnHandler());
		return id;
	}
}
