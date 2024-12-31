package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEIpPoisDTO;
import xap.mw.core.data.BaseDTO;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetIEIpMsgInfo4PoisBP {

	public BaseDTO[] exec(UdidocDO[] udis,String eventType){
		
		List<IEIpPoisDTO> preslist=new ArrayList<>();
		for (UdidocDO udidocDO : udis) {
			IEIpPoisDTO dto=new IEIpPoisDTO();
			dto.setId_ieippois(udidocDO.getId_udidoc());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(udidocDO.getCode());
			dto.setName(udidocDO.getName());
			dto.setPy_code(udidocDO.getPycode());
			dto.setDomain_id("0");//"02"
			preslist.add(dto);
		}
		return preslist.toArray(new IEIpPoisDTO[1]);
		
	}
	
}
