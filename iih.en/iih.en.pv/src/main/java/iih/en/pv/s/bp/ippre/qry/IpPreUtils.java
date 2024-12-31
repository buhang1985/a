package iih.en.pv.s.bp.ippre.qry;

import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 预住院工具类
 * @author ltf
 *
 */
public class IpPreUtils {
	
	@SuppressWarnings("unchecked")
	public static String[] pageConvertEntIds(PagingRtnData<EnIppreInfoDTO> dtos){
		FArrayList list = dtos.getPageData();
		if(ListUtil.isEmpty(list))
			return null;
		String[] entIds = new String[list.size()]; 
		// 组装entIds数组
		for (int i=0; i<list.size(); i++) {
			EnIppreInfoDTO regdto = (EnIppreInfoDTO)list.get(i);
			if (!StringUtil.isEmptyWithTrim(regdto.getId_ent()))
			entIds[i] = regdto.getId_ent();
		}
		return entIds;
	}
}
