package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEIpOrDictDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BaseDTO;

/**
 * MS036：医嘱字典 增、删、改事件
 *
 */
public class GetIEIpMsgInfo4OrDictBP {

	public BaseDTO[] exec(MedsrvAggDO[] aggDOs, String eventType) {

		List<IEIpOrDictDTO> dtolist = new ArrayList<>();
		for (MedsrvAggDO item : aggDOs) {
			MedSrvDO srv = item.getParentDO();
			IEIpOrDictDTO dto = new IEIpOrDictDTO();
			dto.setId_ieipordict(srv.getId_srv());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setOrder_code(srv.getCode());
			dto.setOrder_name(srv.getName());
			dto.setPy_code(srv.getPycode());
			dto.setDomain_id("02");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEIpOrDictDTO[1]);

	}

}
