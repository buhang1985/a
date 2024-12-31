package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEOpLisItmDictDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BaseDTO;

/**
 * MS033：检验项目字典</br>
 * 对应诊疗项目中化验类中的服务项目
 *
 */
public class GetIEOpMsgInfo4LisItemDictBP {

	public BaseDTO[] exec(MedsrvAggDO[] aggDOs, String eventType) {

		List<IEOpLisItmDictDTO> dtolist = new ArrayList<>();
		for (MedsrvAggDO item : aggDOs) {
			MedSrvDO srv = item.getParentDO();
			IEOpLisItmDictDTO dto = new IEOpLisItmDictDTO();
			dto.setId_ieoplisitmdict(srv.getId_srv());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(srv.getCode());
			dto.setName(srv.getName());
			dto.setPy_code(srv.getPycode());
			dto.setDomain_id("01");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEOpLisItmDictDTO[1]);

	}

}
