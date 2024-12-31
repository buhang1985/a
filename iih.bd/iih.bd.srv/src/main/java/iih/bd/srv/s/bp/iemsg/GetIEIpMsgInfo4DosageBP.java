package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEIpDosageDTO;
import xap.mw.core.data.BaseDTO;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetIEIpMsgInfo4DosageBP {

	public BaseDTO[] exec(UdidocDO[] udis,String eventType){
		
		List<IEIpDosageDTO> preslist=new ArrayList<>();
		for (UdidocDO udidocDO : udis) {
			IEIpDosageDTO dto=new IEIpDosageDTO();
			dto.setId_ieipdosage(udidocDO.getId_udidoc());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(udidocDO.getCode());
			dto.setName(udidocDO.getName());
			dto.setPy_code(udidocDO.getPycode());
			dto.setDomain_id("0");//"02"
			preslist.add(dto);
		}
		return preslist.toArray(new IEIpDosageDTO[1]);
		
	}

}
