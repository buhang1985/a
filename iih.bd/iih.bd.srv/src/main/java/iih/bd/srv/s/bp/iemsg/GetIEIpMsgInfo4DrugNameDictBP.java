package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEIpDrugNameDictDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BaseDTO;

/**
 * MS053：药品名称字典
 *
 */
public class GetIEIpMsgInfo4DrugNameDictBP {

	public BaseDTO[] exec(MedsrvAggDO[] aggDOs, String eventType) {

		List<IEIpDrugNameDictDTO> dtolist = new ArrayList<>();
		for (MedsrvAggDO item : aggDOs) {
			MedSrvDO srv = item.getParentDO();
			IEIpDrugNameDictDTO dto = new IEIpDrugNameDictDTO();
			dto.setId_ieipdrugnamedict(srv.getId_srv());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(srv.getCode());
			dto.setName(srv.getName());
			dto.setPycode(srv.getPycode());
			dto.setDomain_id("02");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEIpDrugNameDictDTO[1]);

	}
}
