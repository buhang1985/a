package iih.bl.prop.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class GetPropArIdHpBP {

	
	public String exec(String idStOep) throws BizException{
		
		StringBuilder sb=new StringBuilder();
        sb.append("select id_hp from bl_prop_ar_oep where id_propoep=(");
        sb.append("select id_propoep from bl_prop_oep where id_stoep='"+ idStOep +"')");
 
        String id= (String) new DAFacade().execQuery(sb.toString(), new ColumnHandler());
		
		return id;
	}
}
