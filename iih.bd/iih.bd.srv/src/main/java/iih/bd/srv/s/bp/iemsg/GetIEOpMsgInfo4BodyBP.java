package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEOpRisBodyPartDTO;
import xap.mw.core.data.BaseDTO;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetIEOpMsgInfo4BodyBP {
	
	public BaseDTO[] exec(UdidocDO[] udis,String eventType){
		
		List<IEOpRisBodyPartDTO> preslist=new ArrayList<>();
		for (UdidocDO udidocDO : udis) {
			IEOpRisBodyPartDTO body=new IEOpRisBodyPartDTO();
			body.setId_ieoprisbodypart(udidocDO.getId_udidoc());
			body.setAction(UtilsIE.GetActionStr(eventType));
			body.setCode(udidocDO.getCode());
			body.setName(udidocDO.getName());
			body.setPy_code(udidocDO.getPycode());
			body.setDomain_id("0");//"01"
			preslist.add(body);
		}
		return preslist.toArray(new IEOpRisBodyPartDTO[1]);
		
	}

}
