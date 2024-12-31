package iih.bd.srv.medusage.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.d.BdSrvQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetMedUsaTreeDataBP {
   public BdSrvQryDTO[]exec() throws BizException{
	   String sql="select name,ID_UDIDOC as id,null as id_parent  from bd_udidoc where id_parent='~' and id_udidoclist='"+IBdSrvDictCodeTypeConst.ID_SRVTP+"' "
			   + "union "
			   + "select name,id_route as id,id_srvtp as id_parent  from bd_route where ds = 0 " ;
		List<BdSrvQryDTO> list= (List<BdSrvQryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(BdSrvQryDTO.class));
		return list.toArray(new BdSrvQryDTO[0]);
	   
	   
   }
}
