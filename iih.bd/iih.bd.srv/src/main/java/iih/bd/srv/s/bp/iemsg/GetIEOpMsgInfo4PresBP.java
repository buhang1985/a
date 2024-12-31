package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEOpPresTypeDTO;
import xap.mw.core.data.BaseDTO;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetIEOpMsgInfo4PresBP {

	
	public BaseDTO[] exec(UdidocDO[] udis,String eventType){
		
		List<IEOpPresTypeDTO> preslist=new ArrayList<>();
		for (UdidocDO udidocDO : udis) {
			IEOpPresTypeDTO pres=new IEOpPresTypeDTO();
			pres.setId_ieoppres(udidocDO.getId_udidoc());
			pres.setAction(UtilsIE.GetActionStr(eventType));
			pres.setCode(udidocDO.getCode());
			pres.setName(udidocDO.getName());
			pres.setPy_code(udidocDO.getPycode());
			pres.setDomain_id("0");//"01"
			preslist.add(pres);
		}
		return preslist.toArray(new IEOpPresTypeDTO[1]);
		
	}
	
}
