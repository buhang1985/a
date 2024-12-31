package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEIpRouteDTO;
import iih.bd.srv.medusage.d.MedUsageDO;
import xap.mw.core.data.BaseDTO;

/**
 *
 * 用法增、删、改操作
 *
 */
public class GetIEIpMsgInfo4MedUsageBP {

	public BaseDTO[] exec(MedUsageDO[] cates,String eventType){
		
		List<IEIpRouteDTO> dtolist=new ArrayList<>();
		for (MedUsageDO cate : cates) {
			IEIpRouteDTO dto=new IEIpRouteDTO();
			dto.setId_ieiproute(cate.getId_route());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setSupply_code(cate.getCode());
			dto.setSupply_name(cate.getName());
			dto.setPy_code(cate.getPycode());
			dto.setDomain_id("02");
			dto.setStopflag("Y");
			dto.setCodevalue("");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEIpRouteDTO[1]);
		
	}
	
}
