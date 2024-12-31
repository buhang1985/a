package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEIpOrCateDTO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BaseDTO;

public class GetIEIpMsgInfo4OrCateBP {

	public BaseDTO[] exec(SrvCateDO[] cates,String eventType){
		
		List<IEIpOrCateDTO> dtolist=new ArrayList<>();
		for (SrvCateDO cate : cates) {
			IEIpOrCateDTO dto=new IEIpOrCateDTO();
			dto.setId_ieiporcate(cate.getId_srvca());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(cate.getCode());
			dto.setName(cate.getName());
			dto.setPy_code(cate.getPycode());
			dto.setDomain_id("02");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEIpOrCateDTO[1]);
		
	}
	
}
