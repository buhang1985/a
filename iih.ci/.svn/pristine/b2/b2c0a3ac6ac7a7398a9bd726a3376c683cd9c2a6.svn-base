package iih.ci.ord.s.external.thirdws.utils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 人员查询工具类
 * @author zhangwq
 *
 */
public class PsndocUtils {
	/**
	 * 查询人员信息
	 * @param code
	 * @return
	 * @throws BizException 
	 */
	public static PsnDocDO getPsnDocByCode(String code) throws BizException{
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndocs = service.findByAttrValString(PsnDocDO.CODE, code);
		if(psndocs != null && psndocs.length>0){
			return psndocs[0];
		}
		return null;
	}
}
