package iih.ei.std.s.v1.bp.common;

import iih.ei.std.d.v1.utils.EiValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

public class PsnDocEP {
	/**
	 * 根据人员编码查询人员
	 * 
	 * @param code
	 *            人员id
	 * @return 人员档案DO
	 * @throws BizException
	 */
	public PsnDocDO getPsnByCode(String code) throws BizException {
		if(StringUtil.isEmptyWithTrim(code))
			return null;
		// 人员档案查询服务
		IPsndocMDORService qryService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psns = qryService.findByAttrValString(PsnDocDO.CODE, code);
		return ArrayUtil.isEmpty(psns) ? null : psns[0];
	}
	
	/**
	 * 根据人员id查询人员
	 * 
	 * @param psnId
	 *            人员id
	 * @return 人员档案DO
	 * @throws BizException
	 */
	public PsnDocDO getPsnById(String psnId) throws BizException {
		EiValidator.validateParam("人员ID", psnId);
		// 人员档案查询服务
		IPsndocMDORService qryService = ServiceFinder.find(IPsndocMDORService.class);
		return qryService.findById(psnId);
	}
	
}
