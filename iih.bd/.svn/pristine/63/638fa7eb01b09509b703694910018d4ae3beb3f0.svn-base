package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.iemsg.d.IEOpLisItmCateDTO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BaseDTO;

/**
 * MS034：检验类型字典</br>
 * 对应服务基本分类_集团（组织）中的 化验类目录下的分类数据维护
 *
 */
public class GetIEOpMsgInfo4LisItemCateBP {

	public BaseDTO[] exec(SrvCateDO[] cates,String eventType){
		
		List<IEOpLisItmCateDTO> dtolist=new ArrayList<>();
		for (SrvCateDO cate : cates) {
			IEOpLisItmCateDTO dto=new IEOpLisItmCateDTO();
			dto.setId_ieoplisitmcate(cate.getId_srvca());
			dto.setAction(UtilsIE.GetActionStr(eventType));
			dto.setCode(cate.getCode());
			dto.setName(cate.getName());
			dto.setPy_code(cate.getPycode());
			dto.setDomain_id("01");
			dtolist.add(dto);
		}
		return dtolist.toArray(new IEOpLisItmCateDTO[1]);
		
	}
	
}
