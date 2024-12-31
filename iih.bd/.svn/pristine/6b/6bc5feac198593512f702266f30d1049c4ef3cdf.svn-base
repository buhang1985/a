package iih.bd.srv.s.bp.iemsg;


import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.iemsg.d.IEOpDiagDictDTO;
import xap.mw.core.data.BaseDTO;

public class GetIEOpMsgInfo4DiagDictBP {

	public BaseDTO[] exec(DiagdefAggDO[] aggDOs,String eventType){
		
		List<IEOpDiagDictDTO> dtolist=new ArrayList<>();
		for (DiagdefAggDO item : aggDOs) {
			DiagDefDO diag=item.getParentDO();
			IEOpDiagDictDTO dto=new IEOpDiagDictDTO();
			dto.setId_ieopdiagdict(diag.getId_didef());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(diag.getCode());
			dto.setName(diag.getName());
			dto.setPy_code(diag.getPycode());
			dto.setDomain_id("01");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEOpDiagDictDTO[1]);
		
	}
}
