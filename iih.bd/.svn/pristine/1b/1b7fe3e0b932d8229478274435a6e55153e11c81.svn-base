package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEOpRisItmDictDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BaseDTO;

/**
 * MS039:检查项目字典 </br>
 * 诊疗项目 检查类下的服务项目
 *
 */
public class GetIEOpMsgInfo4RisItemDictBP {

	public BaseDTO[] exec(MedsrvAggDO[] aggDOs, String eventType) {

		List<IEOpRisItmDictDTO> dtolist = new ArrayList<>();
		for (MedsrvAggDO item : aggDOs) {
			MedSrvDO srv = item.getParentDO();
			IEOpRisItmDictDTO dto = new IEOpRisItmDictDTO();
			dto.setId_ieoprisitmdict(srv.getId_srv());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setSub_code(srv.getCode());
			dto.setType_code(srv.getSrvca_code());
			dto.setName(srv.getName());
			dto.setPy_code(srv.getPycode());
			dto.setDomain_id("01");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEOpRisItmDictDTO[1]);
	}
}
