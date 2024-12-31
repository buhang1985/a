package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEOpRisItmCateDTO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BaseDTO;

/**
 * MS040：集成平台事件</br>
 * 检查项目分组
 *
 */

public class GetIEOpMsgInfo4RisItemCateBP {

	public BaseDTO[] exec(SrvCateDO[] cates, String eventType) {

		List<IEOpRisItmCateDTO> dtolist = new ArrayList<>();
		for (SrvCateDO cate : cates) {
			IEOpRisItmCateDTO dto = new IEOpRisItmCateDTO();
			dto.setId_ieoprisitmcate(cate.getId_srvca());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(cate.getCode());
			dto.setName(cate.getName());
			dto.setPy_code(cate.getPycode());
			dto.setDomain_id("01");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEOpRisItmCateDTO[1]);

	}

}
