package iih.bd.srv.srvdc.bp;

import java.util.List;

import iih.bd.srv.d.FixedChargePKgDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class SrvdcCrudBp {
	
	
	
	public FixedChargePKgDTO[] getFCPKgTreeList(String Id_own)throws BizException {
      
        String sql = "select id_srvdc, name,id_owtp as id_parent  from bd_srv_dc  where id_owtp ='"+Id_own+"'";
	     List<FixedChargePKgDTO> list= (List<FixedChargePKgDTO>)new DAFacade().execQuery(sql, new BeanListHandler(FixedChargePKgDTO.class));
			return list.toArray(new FixedChargePKgDTO[0]);

			
		}

}
